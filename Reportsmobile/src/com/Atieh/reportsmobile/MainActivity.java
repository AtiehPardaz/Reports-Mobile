package com.Atieh.reportsmobile;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import webservices.NetworkUtils;
import webservices.ServiceGenerator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import authenticationPack.Authentication;
import authenticationPack.AuthenticationInterface;
import authenticationPack.Domain;

public class MainActivity extends Activity {
	LinearLayout loadinglayer;
	public Utils utils = Utils.getInstance();
	public static final String baseURL = "http://demo.atiehpardaz.com/ReportService/ReportService.svc";
	ImageButton login;
	public static Authentication authenticate;
	public static List domainss;
	static Domain dmn;
	public static String[] msg;
	private boolean _doubleBackToExitPressedOnce = false;
	public static int msg2;
	EditText et_username, et_password;
	int i = 0;
	String mUser;
	String mPass;
	NetworkUtils netutil = new NetworkUtils(this);

	public static Typeface titr;

	public void initview() {
		login = (ImageButton) findViewById(R.id.imgbtn_login);
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		loadinglayer = (LinearLayout) findViewById(R.id.linearpb_doamin);

	}

	public void attemplogin() {
		et_password.setError(null);
		et_username.setError(null);
		mUser = et_username.getText().toString();
		mPass = et_password.getText().toString();
		boolean cancel = false;
		View focusview = null;
		if (TextUtils.isEmpty(mUser)) {
			et_username.setError(getString(R.string.pleaseEnterUsername));
			focusview = et_username;
			cancel = true;
		}
		if (TextUtils.isEmpty(mPass)) {
			et_password.setError(getString(R.string.pleaseEnterPassword));
			focusview = et_password;
			cancel = true;
		}
		if (cancel) {
			focusview.requestFocus();
		} else {
			if (netutil.isNetworkAvailable()) {
				autenticateUser();
			} else {
				
				String message = "لطفا از روشن بودن دیتای موبایل و یا وایرلس خود و اتصال به اینترنت اطمینان حاصل نمایید.";
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this).setTitle("توجه")
						.setMessage(message);
				builder.setPositiveButton(R.string.ok, null);
				builder.show();
			}
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initview();
		// utils.setyekanfont(et_password);
		// utils.setyekanfont(et_username);

		loadinglayer.setVisibility(View.INVISIBLE);
		titr = Typeface.createFromAsset(MainActivity.this.getAssets(),
				"titr.TTF");

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				final InputMethodManager imm = (InputMethodManager) getApplicationContext()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);

				attemplogin();
			}
		});

		et_password.setGravity(Gravity.RIGHT);
		et_password.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (et_password.getText().length() == 0) {
					et_password.setGravity(Gravity.RIGHT);
				} else {
					et_password.setGravity(Gravity.LEFT);
				}
				et_password.setError(null);
				et_username.setError(null);
				mUser = et_username.getText().toString();
				mPass = et_password.getText().toString();
				boolean cancel = false;
				View focusview = null;
				if (TextUtils.isEmpty(mUser)) {
					et_username.setError(getString(R.string.pleaseEnterUsername));
					focusview = et_username;
					cancel = true;
				}
				
				if (cancel) {
					focusview.requestFocus();
				} 
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}
		});
		et_username.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				et_password.setError(null);
				et_username.setError(null);
				mUser = et_username.getText().toString();
				mPass = et_password.getText().toString();
				boolean cancel = false;
				View focusview = null;
				if (TextUtils.isEmpty(mUser)) {
					et_username.setError(getString(R.string.pleaseEnterUsername));
					focusview = et_username;
					cancel = true;
				}
				
				if (cancel) {
					focusview.requestFocus();
				} 
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		if (getIntent().getBooleanExtra("EXIT", false)) {
			finish();
		}
	}

	public static void hideSoftKeyboard(Activity activity) {

	}

	public void autenticateUser() {

		loadinglayer.setVisibility(View.VISIBLE);
		authenticate = new Authentication();
		AuthenticationInterface auth = ServiceGenerator.createService(
				AuthenticationInterface.class, MainActivity.baseURL);
		auth.authenticate(et_username.getText().toString(), et_password
				.getText().toString(), new Callback<Authentication>() {

			@Override
			public void success(Authentication auth, Response response) {
				String title = "";
				String body = "";
				boolean showAlert = false;

				authenticate = auth;
				loadinglayer.setVisibility(View.INVISIBLE);
				if (authenticate.getResult().getStatus() != null) {

					if (authenticate.getResult().getStatus().getCode() == 1) {
						showAlert = false;
						startActivity(new Intent(MainActivity.this,
								SelectDomainActivity.class));
					} else {
						body = authenticate.getResult().getStatus()
								.getMessageDetails();
						showAlert = true;
					}
				} else {
					// TODO
					body = getString(R.string.dataRxErrorMsg);
					showAlert = true;
				}

				if (showAlert == true) {
					showDialog(title, body);
				}
			}

			@Override
			public void failure(RetrofitError retrofitError) {

				String title = getString(R.string.errorTitle);
				loadinglayer.setVisibility(View.INVISIBLE);
				String body = netutil.handleRetrofitError(retrofitError);
				showDialog(title, body);
			}
		});
	}

	@Override
	public void onBackPressed() {

		showDialogForExit();
		
	}

	public void showDialogForExit() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage(getString(R.string.wouldYouLikeToExit));
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		alertDialogBuilder.setTitle(getString(R.string.warningTitle));
		alertDialogBuilder.setCancelable(false);
		alertDialogBuilder.setPositiveButton(getString(R.string.ok),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
						Intent intent = new Intent(getApplicationContext(),
								MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						intent.putExtra("EXIT", true);
						startActivity(intent);
					}
				});
		alertDialogBuilder.setNegativeButton(getString(R.string.cancel), 
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
			
				});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}
	public void showDialog(String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
				.setTitle(title).setMessage(message);
		builder.setPositiveButton(R.string.ok, null);
		builder.show();
	}
}
