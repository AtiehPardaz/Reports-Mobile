package com.Atieh.reportsmobile;

import com.Atieh.reportsmobile.MainActivity.asyncTask;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

public class Utils extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	
	
	
	
//	public void attemplogin() {
//		et_password.setError(null);
//		et_username.setError(null);
//		mUser = et_username.getText().toString();
//		mPass = et_password.getText().toString();
//		boolean cancel = false;
//		View focusview = null;
//		if (TextUtils.isEmpty(mUser)) {
//			et_username.setError("لطفا نام کاربری را وارد نمایید");
//			focusview = et_username;
//			cancel = true;
//		}
//		if (TextUtils.isEmpty(mPass)) {
//			et_password.setError("لطفا رمز عبور را وارد نمایید");
//			focusview = et_password;
//			cancel = true;
//		}
//		if (cancel) {
//			focusview.requestFocus();
//		} else {
//
//			asyncTask as = new asyncTask(); // checking network
//			// status
//			as.execute("P");
//
//			// startActivity(new Intent(MainActivity.this,
//			// SelectDomainActivity.class));
//
//		}
//
//	}
}
