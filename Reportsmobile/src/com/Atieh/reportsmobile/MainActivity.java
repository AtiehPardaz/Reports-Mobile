package com.Atieh.reportsmobile;

import java.util.List;

import org.apache.http.HttpStatus;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import webservices.ServiceGenerator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

	public static int msg2;
	EditText et_username, et_password;
	int i = 0;
	String mUser;
	String mPass;

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
			et_username.setError("لطفا نام کاربری را وارد نمایید");
			focusview = et_username;
			cancel = true;
		}
		if (TextUtils.isEmpty(mPass)) {
			et_password.setError("لطفا رمز عبور را وارد نمایید");
			focusview = et_password;
			cancel = true;
		}
		if (cancel) {
			focusview.requestFocus();
		} else {
//			if(isNetworkAvailable())
//			{
				autenticateUser();
//			}
//			else
//			{
//				String message = "لطفا از روشن بودن دیتای موبایل و یا وایرلس خود و اتصال به اینترنت اطمینان حاصل نمایید.";
//				AlertDialog.Builder builder =
//				        new AlertDialog.Builder(MainActivity.this).setTitle("title").setMessage(message);
//			    builder.setPositiveButton(R.string.ok, null);
//				builder.show();
//			}
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initview();

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

		if (getIntent().getBooleanExtra("EXIT", false)) {
			finish();
		}

	}

	public static void hideSoftKeyboard(Activity activity) {

	}

	private boolean isNetworkAvailable() {

		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public void autenticateUser() {
		
		loadinglayer.setVisibility(View.VISIBLE);
		authenticate = new Authentication();

		AuthenticationInterface auth = ServiceGenerator.createService(
				AuthenticationInterface.class, MainActivity.baseURL);

		auth.authenticate(et_username.getText().toString(),
				et_password.getText().toString(), new Callback<Authentication>(){

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
					}

					else {

						//TODO
						//Our server code results must be processed here
						
						body = authenticate.getResult().getStatus()
								.getMessageDetails();
						showAlert = true;
					}

				} else {
					//TODO
					body = "خطا در دریافت اطلاعات از سرور. لطفا مجددا تلاش نمایید.";
					showAlert = true;
				}
				
				if(showAlert == true)
				{
					AlertDialog.Builder builder =
					        new AlertDialog.Builder(MainActivity.this).setTitle(title).setMessage(body);
				    builder.setPositiveButton(R.string.ok, null);
					builder.show();
				}
			}

			@Override
			public void failure(RetrofitError retrofitError) {
				
				String title = getString(R.string.LoginErrorTitle);
				String body = getString(R.string.LoginErrorMessageGeneric);
				
				loadinglayer.setVisibility(View.INVISIBLE);	
				Response response = retrofitError.getResponse();
				int statusCode = response.getStatus();
								
				//An IOException occurred while communicating to the server, e.g. Timeout, No connection, etc...
				if (retrofitError.getKind().equals(RetrofitError.Kind.NETWORK))
				{
					switch (statusCode) {
					
					case HttpStatus.SC_BAD_REQUEST:	//400: Bad Request
						body = getString(R.string.HttpStatusMessageBadRequest);
						break;
					case HttpStatus.SC_UNAUTHORIZED:	//401
						body = getString(R.string.HttpStatusMessageUnauthorized);
						break;
					case HttpStatus.SC_FORBIDDEN:	//403
						body = getString(R.string.HttpStatusMessageForbidden);
						break;
					case HttpStatus.SC_NOT_FOUND:	//404
						body = getString(R.string.HttpStatusMessageNotFound);
						break;
					case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED:	//407
						body = getString(R.string.HttpStatusMessageProxyAuthenticationRequired);
						break;
					case HttpStatus.SC_REQUEST_TIMEOUT:	//408
						body = getString(R.string.HttpStatusMessageRequestTimeout);
						break;
					case HttpStatus.SC_INTERNAL_SERVER_ERROR:	//500
						body = getString(R.string.HttpStatusMessageInternalServerError);
						break;
					case HttpStatus.SC_NOT_IMPLEMENTED:	//501
						body = getString(R.string.HttpStatusMessageNotImplemented);
						break;
					case HttpStatus.SC_BAD_GATEWAY:	//502
						body = getString(R.string.HttpStatusMessageBadGateway);
						break;
					case HttpStatus.SC_SERVICE_UNAVAILABLE:	//503: Server Unavailable
						body = getString(R.string.HttpStatusMessageServiceUnavailable);
						break;
					case HttpStatus.SC_GATEWAY_TIMEOUT:	//504
						body = getString(R.string.HttpStatusMessageGatewayTimeout);
						break;						  
					default:
						break;
					}
				}

				//A non-200 HTTP status code was received from the server
				if (retrofitError.getKind().equals(RetrofitError.Kind.HTTP))
				{
					body = response.getReason();
				}
								
				//An exception was thrown while (de)serializing a body
				if (retrofitError.getKind().equals(RetrofitError.Kind.CONVERSION))
				{
					body = response.getReason();
				}
				
				//An internal error occurred while attempting to execute a request
				if (retrofitError.getKind().equals(RetrofitError.Kind.UNEXPECTED))
				{
					body = response.getReason();
				}
				
				AlertDialog.Builder builder =
				        new AlertDialog.Builder(MainActivity.this).setTitle(title).setMessage(body);
			    builder.setPositiveButton(R.string.ok, null);
				builder.show();
			}
		});
	}

}
