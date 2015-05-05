package com.Atieh.reportsmobile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import webservices.ServiceGenerator;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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

//	public static final String baseURL = "http://webservice.atiehpardaz.com/reportService/ReportService.svc";
	public static final String baseURL = "http://demo.atiehpardaz.com/ReportService/ReportService.svc";
	ImageButton login;
	public static Authentication authenticate;
	public static List domainss;
	static Domain dmn;
	public static String[] msg;
	
	public static int msg2;
	EditText et_username, et_password;
	AuthenticationInterface auth;
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

			asyncTask as = new asyncTask(); // checking network
			// status
			as.execute("P");

			// startActivity(new Intent(MainActivity.this,
			// SelectDomainActivity.class));

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

	public void autenticateUser() {

		authnticationThread auth = new authnticationThread();
		auth.execute("");

		//
		// for (int i = 0; i < authenticate.getDomains().size(); i++) {
		// // msg[i] ="aa";// authenticate.getDomains().get(i).getTitle();
		// Toast.makeText(getApplicationContext(), i+"", 1).show();
		//
		// }
	}

	public int netStatus(String url) throws URISyntaxException,
			ClientProtocolException, IOException {

		int resCode = 0;
		if (isNetworkAvailable()) {

			try {

				HttpGet httpRequest = null;
				HttpParams httpParameters = new BasicHttpParams();
				httpRequest = new HttpGet(new URI(url));
				HttpConnectionParams
						.setConnectionTimeout(httpParameters, 20000);
				HttpConnectionParams.setSoTimeout(httpParameters, 20000);

				HttpClient httpclient = new DefaultHttpClient(httpParameters);
				HttpResponse response = httpclient.execute(httpRequest);
				resCode = response.getStatusLine().getStatusCode();

			}

			catch (ConnectTimeoutException e) {

				Toast.makeText(MainActivity.this, "timeout error",
						Toast.LENGTH_SHORT).show();

				resCode = 10000;

			}

		}

		else {
			resCode = 1000; // our code for no network connected or connecting
		}

		return resCode;
	}

	public String httpRequestMessage(int responseCode) {
		String message = "";
		switch (responseCode) {
		case 200:
			message = "";
			break;
		case 401:
			message = "عدم دسترسی لازم جهت اتصال به سرور";
			break;
		case 400:
			message = "خطا در برقرای ارتباط. لطفا مجددا تلاش نمایید";
			break;

		case 404:
			message = "وب سایت پذیرنده در دسترس نمی باشد. لطفا در زمانی دیگر تلاش نمایید.";
			break;

		case 1000: // our code for no network connected or connecting
			message = "لطفا از روشن بودن دیتای موبایل و یا وایرلس خود و اتصال به اینترنت اطمینان حاصل نمایید.";
			break;

		default:
			message = "خطای ناشناخته شماره :" + Integer.toString(responseCode);
		}

		return message;
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

	public class asyncTask extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {

			// progbar_progress.setVisibility(View.VISIBLE);
			// linear1.setVisibility(View.VISIBLE);
			loadinglayer.setVisibility(View.VISIBLE);
		}

		@Override
		protected String doInBackground(String... arg0) {

			try {
				return httpRequestMessage(netStatus("http://atiehpardaz.com/default.aspx?lng=fa"));
			} catch (URISyntaxException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				loadinglayer.setVisibility(View.INVISIBLE);

				return "timeout error";
			}
		}

		@Override
		protected void onPostExecute(String result) {

			if (result != "") {
				Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT)
						.show();
			} else {

				autenticateUser();

			}
		}
	}

	public class authnticationThread extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... arg0) {

			authenticate = new Authentication();

			auth = ServiceGenerator.createService(
					AuthenticationInterface.class, MainActivity.baseURL);

			authenticate = auth.authenticate(et_username.getText().toString(),
					et_password.getText().toString());

			// msg = authenticate.getDomains().get(0).getTitle();
			// msg = authenticate.getDomains().get(0).getTitle();
			msg2 = authenticate.getResult().getDomains().size();
			// Toast.makeText(getApplicationContext(),
			// authenticate.getDomains().get(i).getTitle(), 1).show();
			// Toast.makeText(getApplicationContext(), msg2+"", 1).show();

			// for (int i = 0; i < authenticate.getDomains().size(); i++) {
			// myaray.add(authenticate.getDomains().get(i).getTitle());
			// // Toast.makeText(getApplicationContext(),
			// // authenticate.getDomains().get(i).getTitle(), 1).show();
			//
			// }
			//

			// ===========
			// do {
			//
			// try {
			//
			// msg[i] = authenticate.getDomains().get(i).getTitle();
			// i++;
			//
			// } catch (Exception e) {
			//
			// e.printStackTrace();
			// }
			//
			// } while (i < authenticate.getDomains().size());
			// myaray.toArray();

			if (authenticate.getResult().getStatus() != null) {

				if (authenticate.getResult().getStatus().getCode() == 1) {

					startActivity(new Intent(MainActivity.this,
							SelectDomainActivity.class));

					return "";
				}

				else {

					return authenticate.getResult().getStatus().getMessage();
				}

			} else {
				return "خطا در دریافت اطلاعات از سرور. لطفا مجددا تلاش نمایید.";
			}

		}

		@Override
		protected void onPostExecute(String result) {

			loadinglayer.setVisibility(View.INVISIBLE);

			if (result != "") {
				Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT)
						.show();

			}
			
//			domaintitleArray = new ArrayList<>();
//			yeartitleArray = new ArrayList<>();
//			yearidArray = new ArrayList<>();
//			domainidArray = new ArrayList<>();
//			for (int i = 0; i < authenticate.getDomains().size(); i++) {
//				domaintitleArray.add(authenticate.getDomains().get(i)
//						.getTitle());
//
//				domainidArray.add(authenticate.getDomains().get(i).getId());
//				for (int j = 0; j < authenticate.getDomains().get(i)
//						.getFinancialYears().size(); j++) {
//
//					yeartitleArray.add(authenticate.getDomains().get(i)
//							.getFinancialYears().get(j).getTitle());
//					yearidArray.add(authenticate.getDomains().get(i)
//							.getFinancialYears().get(j).getId());
//				}
//			
//
//			}
//			
//			Toast.makeText(
//					getApplicationContext(),
//					authenticate.getDomains().get(0).getFinancialYears()
//							.get(0).getTitle()
//							+ "", 1).show();

		}
	}

}
