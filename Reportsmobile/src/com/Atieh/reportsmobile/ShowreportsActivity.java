package com.Atieh.reportsmobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ShowreportsActivity extends Activity {
	private WebView webview;
	private static final String TAG = "Main";
	private ProgressDialog progressBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_showreports);
		

		this.webview = (WebView) findViewById(R.id.wv_showresult);

		WebSettings settings = webview.getSettings();
		settings.setJavaScriptEnabled(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

		webview.getSettings().setBuiltInZoomControls(true);
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

		progressBar = ProgressDialog.show(ShowreportsActivity.this,
				".گزارش در حال بارگزاری می باشد", "لطفا منتظر باشید...");

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
			}

			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Log.e(TAG, "Error: " + description);
				Toast.makeText(getApplicationContext(),
						"Oh no! " + description, Toast.LENGTH_SHORT).show();
				alertDialog.setTitle("خطا");
				alertDialog.setMessage(description);
				alertDialog.setButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								return;
							}
						});
				alertDialog.show();
			}
		});
		// forosh tabs
		if (getIntent().getStringExtra("gozaresh").equals("faktoreforosh")) {

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			webview.loadUrl("http://demo.atiehpardaz.com/reports/CustomerByInvoice.aspx");
		} else if (getIntent().getStringExtra("gozaresh").equals("customer")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/Report.aspx");
		} else if (getIntent().getStringExtra("gozaresh")
				.equals("kalaforokhte")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/SaleInvoice/SaleInvoice.aspx");
		}// hesabdari tabs
		else if (getIntent().getStringExtra("gozaresh").equals(
				"gardeshhesabdari")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/Accounting/AccountingTafsil.aspx");
		} else if (getIntent().getStringExtra("gozaresh").equals(
				"tarkibihesabdari")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/Accounting/AccountingTwoTafsil.aspx");
		}// khazane tabs
		else if (getIntent().getStringExtra("gozaresh").equals(
				"daryaftikhazane")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/GetDocument.aspx");
		} else if (getIntent().getStringExtra("gozaresh").equals(
				"pardakhtikhazane")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/PayDocument.aspx");
		} else if (getIntent().getStringExtra("gozaresh").equals(
				"vaziatdaryafti")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/GetDocumentStatus.aspx");
		} else if (getIntent().getStringExtra("gozaresh").equals(
				"vaziatpardakhti")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/PayDocumentStatus.aspx");
		}// kala va anbar tabs
		else if (getIntent().getStringExtra("gozaresh").equals("rialianbar")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouseRials.aspx");
		}else if (getIntent().getStringExtra("gozaresh").equals("rialianbartajmiiy")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouseRials.aspx");
		}else if (getIntent().getStringExtra("gozaresh").equals("mojodikala")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouse.aspx");
		} else if (getIntent().getStringExtra("gozaresh").equals("mojodikalatajmiiy")) {
			webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouseAgreagate.aspx");
		}

	}
}