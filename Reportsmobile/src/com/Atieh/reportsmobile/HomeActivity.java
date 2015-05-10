package com.Atieh.reportsmobile;

import java.util.ArrayList;

import webservices.ServiceGenerator;
import GetAllCustomersPack.GetAllCustomer;
import GetAllCustomersPack.GetAllCustomerInterface;
import GetAllMarketersPack.GetAllMarketers;
import GetAllMarketersPack.GetAllMarketersInterface;
import GetAllProductPack.GetAllProduct;
import GetAllProductPack.GetAllProductInterface;
import GetAllSellersPack.GetAllSeller;
import GetAllSellersPack.GetAllSellerInterface;
import GetAllServicesPack.GetAllService;
import GetAllServicesPack.GetAllServiceInterface;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends Activity {

	GetAllSeller seler;
	GetAllCustomer moshtari;
	GetAllMarketers bazaryab;
	GetAllProduct product;
	GetAllService services;

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
	public static int[] mypermission = new int[5];

	public static ArrayList<String> sellertitleArray;
	public static ArrayList<String> sellerpersoncodeArray;
	public static ArrayList<String> selleridArray;

	public static ArrayList<String> moshtariidArray;
	public static ArrayList<String> mostarititleArray;
	public static ArrayList<String> mostaripersoncodeArray;

	public static ArrayList<String> bazaryabidArray;
	public static ArrayList<String> bazaryabtitleArray;
	public static ArrayList<String> bazaryabpersoncodeArray;

	public static ArrayList<String> productidArray;
	public static ArrayList<String> producttitleArray;
	public static ArrayList<String> productcodeArray;

	public static ArrayList<String> servicesidArray;
	public static ArrayList<String> servicestitleArray;
	public static ArrayList<String> servicescodeArray;

	public static String token;

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
		token = MainActivity.authenticate.getResult().getToken();

		sellerThread auth = new sellerThread();
		auth.execute("");

		forosh.setImageResource(R.drawable.backmenutransparent);
		khazane.setImageResource(R.drawable.backmenutransparent);
		hesabdari.setImageResource(R.drawable.backmenutransparent);
		kala.setImageResource(R.drawable.backmenutransparent);
		forosh.setEnabled(false);
		khazane.setEnabled(false);
		hesabdari.setEnabled(false);
		kala.setEnabled(false);
		// linearmenu.setVisibility(View.VISIBLE);

		// Toast.makeText(
		// getApplicationContext(),
		// MainActivity.authenticate.getResult().getDomains().get(0)
		// .getPermissions().get(0).getKey()
		// + "", 1).show();

		// Toast.makeText(getApplicationContext(), mypermission[3], 1).show();

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

	public class sellerThread extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... arg0) {

			// ==================== GetAllSeller
			seler = new GetAllSeller();
			GetAllSellerInterface sellers = ServiceGenerator.createService(
					GetAllSellerInterface.class, MainActivity.baseURL);
			seler = sellers.getAllSellers(
					SelectDomainActivity.returnedDomainID,
					SelectDomainActivity.returnedYearID, token);
			selleridArray = new ArrayList<>();
			sellertitleArray = new ArrayList<>();
			sellerpersoncodeArray = new ArrayList<>();
			for (int i = 0; i < seler.getResult().size(); i++) {
				sellertitleArray.add(seler.getResult().get(i).getTitle());
				selleridArray.add((seler.getResult().get(i).getId()));
				sellerpersoncodeArray.add((seler.getResult().get(i)
						.getPersonCode()));
			}
			// ===========================GetAllCustomer
			moshtari = new GetAllCustomer();
			GetAllCustomerInterface customer = ServiceGenerator.createService(
					GetAllCustomerInterface.class, MainActivity.baseURL);

			moshtari = customer.getAllCustomer(
					SelectDomainActivity.returnedDomainID,
					SelectDomainActivity.returnedYearID, token);

			moshtariidArray = new ArrayList<>();
			mostarititleArray = new ArrayList<>();
			mostaripersoncodeArray = new ArrayList<>();
			for (int i = 0; i < moshtari.getResult().size(); i++) {
				mostarititleArray.add(moshtari.getResult().get(i).getTitle());
				moshtariidArray.add((moshtari.getResult().get(i).getId()));
				mostaripersoncodeArray.add((moshtari.getResult().get(i)
						.getPersonCode()));
			}
			// ========================GetAllMarketers
			bazaryab = new GetAllMarketers();
			GetAllMarketersInterface marketer = ServiceGenerator.createService(
					GetAllMarketersInterface.class, MainActivity.baseURL);

			bazaryab = marketer.getAllMarketers(
					SelectDomainActivity.returnedDomainID,
					SelectDomainActivity.returnedYearID, token);

			bazaryabidArray = new ArrayList<>();
			bazaryabtitleArray = new ArrayList<>();
			bazaryabpersoncodeArray = new ArrayList<>();

			for (int i = 0; i < bazaryab.getResult().size(); i++) {
				bazaryabtitleArray.add(bazaryab.getResult().get(i).getTitle());
				bazaryabidArray.add((bazaryab.getResult().get(i).getId()));
				bazaryabpersoncodeArray.add((bazaryab.getResult().get(i)
						.getPersonCode()));
			}

			// ==========================GetAllProduct

			product = new GetAllProduct();
			GetAllProductInterface mahsolat = ServiceGenerator.createService(
					GetAllProductInterface.class, MainActivity.baseURL);

			product = mahsolat.getAllProduct(
					SelectDomainActivity.returnedDomainID,
					SelectDomainActivity.returnedYearID, token);

			productidArray = new ArrayList<>();
			producttitleArray = new ArrayList<>();
			productcodeArray = new ArrayList<>();

			for (int i = 0; i < product.getResult().size(); i++) {
				producttitleArray.add(product.getResult().get(i).getTitle());
				productidArray.add((product.getResult().get(i).getId()));
				productcodeArray.add((product.getResult().get(i).getCode()));
			}

			// ==========================GetAllService

			services = new GetAllService();
			GetAllServiceInterface khadamat = ServiceGenerator.createService(
					GetAllServiceInterface.class, MainActivity.baseURL);

			services = khadamat.getAllService(
					SelectDomainActivity.returnedDomainID,
					SelectDomainActivity.returnedYearID, token);

			servicesidArray = new ArrayList<>();
			servicestitleArray = new ArrayList<>();
			servicescodeArray = new ArrayList<>();

			for (int i = 0; i < services.getResult().size(); i++) {
				servicestitleArray.add(services.getResult().get(i).getTitle());
				servicesidArray.add((services.getResult().get(i).getId()));
				servicescodeArray.add((services.getResult().get(i).getCode()));
			}

			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub

			// for loading
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub

			// Toast.makeText(getApplicationContext(),
			// seler.getResult().get(1).getTitle() + "", 1).show();

			super.onPostExecute(result);
		}

	}

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

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// /================ for permission
		mypermission = new int[5];
		for (int i = 0; i < MainActivity.authenticate.getResult().getDomains()
				.size(); i++) {

			// domainidArray.add(MainActivity.authenticate.getResult()
			// .getDomains().get(i).getId());

			for (int j = 0; j < MainActivity.authenticate.getResult()
					.getDomains().get(i).getPermissions().size(); j++) {
				if (MainActivity.authenticate.getResult().getDomains().get(i)
						.getId()
						.equals(SelectDomainActivity.finalreturneddomainid)) {

					// MainActivity.authenticate.getResult().getDomains().get(i)
					// .getPermissions().get(0).getKey();
					// Toast.makeText(
					// getApplicationContext(),
					// MainActivity.authenticate.getResult().getDomains()
					// .get(i).getPermissions().get(j).getKey()
					// + "", 1).show();
					for (int k = 1; k <= 4; k++) {
						if (k == MainActivity.authenticate.getResult()
								.getDomains().get(i).getPermissions().get(j)
								.getKey()) {
							mypermission[k] = k;
							// Toast.makeText(getApplicationContext(),k+
							// mypermission[k], 1).show();
						}
					}
				}
			}
		}

		for (int k = 1; k <= 4; k++) {

			// in toast baraye namayesh dastresi ha va chek anha ba khoroji ast
			// Toast.makeText(
			// getApplicationContext(),
			// "permisson oF the domain id=  "
			// + SelectDomainActivity.finalreturneddomainid
			// + " For report num of= " + k + "  IS = "
			// + mypermission[k] + "", 1).show();
			if (mypermission[k] == 1) {

				forosh.setImageResource(R.drawable.btn_click);
				forosh.setEnabled(true);
			} else if (mypermission[k] == 2) {

				khazane.setImageResource(R.drawable.btn_click);
				khazane.setEnabled(true);
			} else if (mypermission[k] == 3) {

				hesabdari.setImageResource(R.drawable.btn_click);
				hesabdari.setEnabled(true);
			} else if (mypermission[k] == 4) {

				kala.setImageResource(R.drawable.btn_click);
				kala.setEnabled(true);
			}

		}
	}
	// ===================================
}
