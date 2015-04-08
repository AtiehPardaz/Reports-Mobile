package com.Atieh.reportsmobile;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import webservices.ServiceGenerator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
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

public class MainActivity extends Activity {
	LinearLayout loadinglayer;

	public static final String baseURL = "http://webservice.atiehpardaz.com/reportService/ReportService.svc";
	ImageButton login;
	Authentication authenticate;
	EditText et_username, et_password;
	AuthenticationInterface auth;
	public static Typeface titr;

	public void initview() {
		login = (ImageButton) findViewById(R.id.imgbtn_login);
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		loadinglayer = (LinearLayout) findViewById(R.id.linearpb_doamin);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initview();
		loadinglayer.setVisibility(View.INVISIBLE);

		titr = Typeface.createFromAsset(MainActivity.this.getAssets(),
				"titr.TTF");
		authenticate = new Authentication();

		auth = ServiceGenerator.createService(AuthenticationInterface.class,
				MainActivity.baseURL);

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
			    imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);
			
				if (et_username.getText().toString().matches("")
						&& et_password.getText().toString().matches("")) {
					Toast.makeText(MainActivity.this,
							"نام کاربری و رمز عبور را وارد نمایید",
							Toast.LENGTH_LONG).show();

				} else if (et_password.getText().toString().matches("")) {
					Toast.makeText(MainActivity.this,
							"رمز عبور را وارد نمایید", Toast.LENGTH_LONG)
							.show();
				} else if (et_username.getText().toString().matches("")) {
					Toast.makeText(MainActivity.this,
							"نام کاربری راوارد نمایید", Toast.LENGTH_LONG)
							.show();
				} else {
					if (et_username.getText().toString().matches("amir")
							&& et_password.getText().toString().matches("amir")) {
						startActivity(new Intent(MainActivity.this,
								SelectDomainActivity.class));
					}else{
						Toast.makeText(MainActivity.this,
								"نام کاربری یا رمز ورود اشتباه است", Toast.LENGTH_LONG)
								.show();
					}
					// for check user & pas

					// < for login ========================
					// loadinglayer.setVisibility(View.VISIBLE);
					// auth.authenticate(et_username.getText().toString(),
					// et_password
					// .getText().toString(), new Callback<Authentication>() {
					//
					// @Override
					// public void success(Authentication arg0, Response arg1) {
					// authenticate = arg0;
					// }
					//
					// @Override
					// public void failure(RetrofitError arg0) {
					//
					// Toast.makeText(MainActivity.this, arg0.toString(), 1)
					// .show();
					//
					// }
					// });
					//
					// if (authenticate.getStatus() != null) {
					//
					//
					// if (authenticate.getStatus().getCode() == 1) {
					//
					// Toast.makeText(MainActivity.this,
					// authenticate.getStatus().getMessage(), 1)
					// .show();
					//
					// startActivity(new Intent(MainActivity.this,
					// SelectDomainActivity.class));
					// }
					//
					// else {
					// //
					// Toast.makeText(MainActivity.this,authenticate.getStatus().getMessage(),
					// // 1).show();
					// }
					//
					// }
					// >>===========end login
				}
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

}
