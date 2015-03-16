package com.Atieh.reportsmobile;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import webservices.ServiceGenerator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import authenticationPack.Authentication;
import authenticationPack.AuthenticationInterface;

public class MainActivity extends Activity {

	public static final String baseURL = "http://webservice.atiehpardaz.com/reportService/ReportService.svc";
	ImageButton login;
	Authentication authenticate;
	EditText et_username,et_password;
	AuthenticationInterface auth;
public static Typeface titr;
	public void initview() {
		login = (ImageButton) findViewById(R.id.imgbtn_login);
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);

		
	}

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initview();
		 titr = Typeface.createFromAsset(MainActivity.this.getAssets(), "titr.TTF");
		 authenticate = new Authentication();
		 
		 auth  = ServiceGenerator.createService(AuthenticationInterface.class, MainActivity.baseURL);
		
		
		
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				
				auth.authenticate(et_username.getText().toString(), et_password.getText().toString(), new Callback<Authentication>() {
					
					@Override
					public void success(Authentication arg0, Response arg1) {

						authenticate = arg0;	
						}
					
					@Override
					public void failure(RetrofitError arg0) {

						Toast.makeText(MainActivity.this, arg0.toString(), 1).show();
						
					}
				});
				
				
				if (authenticate.getStatus()!= null) {
					
					if (authenticate.getStatus().getCode() == 1) {
					
					Toast.makeText(MainActivity.this,authenticate.getStatus().getMessage(), 1).show();

					startActivity(new Intent(MainActivity.this,
						SelectDomainActivity.class));
				}
				
				else {
					//Toast.makeText(MainActivity.this,authenticate.getStatus().getMessage(), 1).show();
				}
					
				}
				
				

			}
		});
		
		if (getIntent().getBooleanExtra("EXIT", false)) {
		    finish();  
		}

	}

}
