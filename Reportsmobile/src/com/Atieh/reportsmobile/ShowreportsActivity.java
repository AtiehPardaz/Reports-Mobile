package com.Atieh.reportsmobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowreportsActivity extends Activity {
	private WebView webview;
	private static final String TAG = "Main";
	private ProgressDialog progressBar;
	AlertDialog alertDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_showreports);

		this.webview = (WebView) findViewById(R.id.wv_showresult);

		WebSettings settings = webview.getSettings();
		settings.setJavaScriptEnabled(true);
		// webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setBuiltInZoomControls(true);
		alertDialog = new AlertDialog.Builder(this).create();

		progressBar = ProgressDialog.show(ShowreportsActivity.this,
				"گزارش در حال بارگزاری می باشد...", "لطفا منتظر باشید...");

		webview.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Log.i(TAG, "Processing webview url click...");
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {
				Log.i(TAG, "Finished loading URL: " + url);
				if (progressBar.isShowing()) {
					progressBar.dismiss();
				}
//				اگه تعداد سطرای جدول کمتر از سه تا باشه یعنی داده ای دریافت نکرده
				webview.loadUrl("javascript:(function() { "
						+ "if(document.getElementById('ctl00_ContentPlaceHolder1_MainStiMobileViewerReportPanel').getElementsByClassName('stiMobileViewerShadow')[0].getElementsByTagName('TABLE')[0].getElementsByTagName('TBODY')[0].getElementsByTagName('TR').length <= 3){ document.write(' داده های ورودی نا معتبر است و یا چیزی برای نمایش وجود ندارد.');} "

						+ "})()");
			}

		});

		webview.loadUrl("http://demo.atiehpardaz.com/reports/"
				+ getIntent().getStringExtra("gozaresh"));

	}// on create

	private boolean isNetworkAvailable() {

		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		} else {
			return false;
		}

	}

}