package com.Atieh.reportsmobile;

import webservices.ServiceGenerator;
import GetAllSellersPack.GetAllSeller;
import GetAllSellersPack.GetAllSellerInterface;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends Activity {

	ImageButton menu;
	ImageButton forosh;
	ImageButton hesabdari;
	ImageButton khazane;
	ImageButton kala;
	ImageButton domain;
	ImageButton logout;
	LinearLayout linearmenu;
	boolean flgclickmenu;
	private boolean _doubleBackToExitPressedOnce = false;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_home);
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_home);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_home);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_home);
		kala = (ImageButton) findViewById(R.id.imgbtn_kala_home);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_home);
		logout = (ImageButton) findViewById(R.id.imgbtn_logout_home);
	}

	// public void showmenu() {
	// if (linearmenu.getVisibility() == View.GONE) {
	// linearmenu.setVisibility(View.VISIBLE);
	//
	// } else {
	// linearmenu.setVisibility(View.GONE);
	// }
	// }

	// =================================oncreate==============
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initview();
		// linearmenu.setVisibility(View.VISIBLE);

		Toast.makeText(
				getApplicationContext(),
				MainActivity.authenticate.getResult().getDomains().get(0)
						.getPermissions().get(0).getKey()+"", 1).show();
		forosh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HomeActivity.this,
						ForoshActivity.class));
			}
		});

		hesabdari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HomeActivity.this,
						HesabdariActivity.class));

			}
		});

		khazane.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HomeActivity.this,
						KhazaneActivity.class));

			}
		});
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HomeActivity.this, KalaActivity.class));

			}
		});
		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HomeActivity.this,
						SelectDomainActivity.class));
			}
		});
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);

			}
		});
		// linearmenu.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// showmenu();
		// }
		// });
		// menu.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// showmenu();
		//
		// // startActivity(new Intent(SelectDomainActivity.this,
		// // HomeActivity.class));
		//
		// }
		// });

		// GetCustomers
		// GetCustomersInterface CustomersAdapter = ServiceGenerator
		// .createService(GetCustomersInterface.class, baseURL);
		// GetCustomers customers = new GetCustomers();
		// try {
		// customers = CustomersAdapter.getCustomers(token);
		// GetCustomers
		// GetAllSellerInterface CustomersAdapter = ServiceGenerator
		// .createService(GetAllSellerInterface.class, MainActivity.baseURL);
		// GetAllSeller customers = new GetAllSeller();
		//
		// customers =
		// CustomersAdapter.getAllSellers("ED5351A4-94DD-4A5F-BDD5-5259CD965385",
		// "ED5351A4-94DD-4A5F-BDD5-5259CD965385", "12345");

		// GetAllSellerInterface getSellers =
		// ServiceGenerator.createService(GetAllSellerInterface.class,
		// "http://webservice.atiehpardaz.com/reportService/ReportService.svc");

		// GetAllSeller getsellers =
		// getSellers.getAllSellers("ED5351A4-94DD-4A5F-BDD5-5259CD965385",
		// "ED5351A4-94DD-4A5F-BDD5-5259CD965385", "12345");

	}

	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	// if ((keyCode == KeyEvent.KEYCODE_BACK)) {
	// backPressedToExitOnce ++;
	// }
	// return super.onKeyDown(keyCode, event);
	// }
	//
	// @Override
	// public void onBackPressed() {
	// // TODO Auto-generated method stub
	// super.onBackPressed();
	// backPressedToExitOnce ++;
	// Toast.makeText(getApplicationContext(), "1"+backPressedToExitOnce,
	// 1).show();
	// if (backPressedToExitOnce == 3) {
	//
	// finish();
	// }else {
	// Toast.makeText(getApplicationContext(), "again", 1).show();
	// }
	// }

	@Override
	public void onBackPressed() {

		// Log.i(TAG, "onBackPressed--");
		if (_doubleBackToExitPressedOnce) {
			super.onBackPressed();

			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("EXIT", true);
			startActivity(intent);

			return;
		}

		this._doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "برای خروج کلید بازگشت را دوباره فشار دهید",
				Toast.LENGTH_SHORT).show();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				_doubleBackToExitPressedOnce = false;
			}
		}, 2000);
	}

}
