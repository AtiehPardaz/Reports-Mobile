package com.Atieh.reportsmobile;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import authenticationPack.Domain;

public class SelectDomainActivity extends Activity {
	public Utils utils = Utils.getInstance();
	String mdomain;
	String myear;
	ImageButton sabt;
	public static String domain, years, StartDate, EndDate;
	public static CharSequence Startdate_charyear, Startdate_charmonth,Enddate_charyear,
	Enddate_charmonth, Enddate_charday,
			Startdate_charday;
	public static String returnedDomainID;
	public static String returnedYearID;

	public static String returnedDomainTitle;
	public static String returnedYearTitle;

	int c;
	private boolean _doubleBackToExitPressedOnce = false;

	public static String finalreturneddomainid;
	public static String finalreturneyearid;

	ImageButton seldomain, selyear;

	String[] domaintitle, domainid;
	String[] yeartitle, yearid;

	TextView et_domain, et_salmali;
	int flgforresume = 0;
	Domain dmn;
	String[] msg = null;
	public static ArrayList<String> domainidArray;
	public static ArrayList<String> domaintitleArray;
	// ==============================
	public static ArrayList<String> yeartitleArray;
	public static ArrayList<String> StartDateArray;
	public static ArrayList<String> EndDateArray;
	public static ArrayList<String> yearidArray;

	AlertDialog alertDialog;

	public void initview() {
		sabt = (ImageButton) findViewById(R.id.imgbtn_sabt);
		seldomain = (ImageButton) findViewById(R.id.imgbtn_selectdomain);
		selyear = (ImageButton) findViewById(R.id.imgbtn_selectyearmali);
		et_salmali = (TextView) findViewById(R.id.et_salemali);
		et_domain = (TextView) findViewById(R.id.et_domain);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectdomain);
		initview();
		utils.setyekanfont(et_domain);
		utils.setyekanfont(et_salmali);

		alertDialog = new AlertDialog.Builder(this).create();
		flgforresume = 0;

		domaintitleArray = new ArrayList<>();
		yeartitleArray = new ArrayList<>();
		StartDateArray = new ArrayList<>();
		EndDateArray = new ArrayList<>();
		yearidArray = new ArrayList<>();
		domainidArray = new ArrayList<>();

		selyear.setOnClickListener(null);
		et_domain.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				seldomain.callOnClick();
			}
		});
		et_salmali.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				selyear.callOnClick();
			}
		});
		try {

			for (int i = 0; i < MainActivity.authenticate.getResult()
					.getDomains().size(); i++) {
				domaintitleArray.add(MainActivity.authenticate.getResult()
						.getDomains().get(i).getTitle());

				domainidArray.add(MainActivity.authenticate.getResult()
						.getDomains().get(i).getId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		domaintitle = (String[]) domaintitleArray
				.toArray(new String[domaintitleArray.size()]);
		domainid = (String[]) domainidArray.toArray(new String[domainidArray
				.size()]);
		sabt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final InputMethodManager imm = (InputMethodManager) getApplicationContext()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

				attemplogin();
				if (c == 0) {

				} else if (c == 1) {
					Intent domainintnent = new Intent();
					domainintnent.putExtra("side", false);
					domainintnent.putExtra("search", false);

					domainintnent.setClass(SelectDomainActivity.this,
							HomeActivity.class);
					startActivity(domainintnent);
				}
			}
		});

		seldomain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				et_domain.setText("");
				et_salmali.setText("");
				if (yearidArray.size() > 0) {// in if baraye in ast ke har bar
												// ke domain avaz shod list sal
												// mali az ebteda meghdardehi
												// shavad va be listsalmali
												// ghabli ezafe nashavad

					// for (int i = 0; i < domainidArray.size(); i++) {
					// yearidArray.remove(i);
					// yeartitleArray.remove(i);
					// }

					yearidArray.clear();
					yeartitleArray.clear();
				}

				flgforresume = 1;
				Intent intent = new Intent();
				intent.setClass(SelectDomainActivity.this,
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", domaintitle);
				intent.putExtra("alphebetic_title", "انتخاب دامنه");
			
				intent.putExtra("arrayidfromjson", domainid);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (flgforresume == 1) {// flg 1 for et_domain
			returnedDomainTitle = ListViewAlphebeticalActivity.txttitle;
			returnedDomainID = ListViewAlphebeticalActivity.txtid;

			et_domain.setText(returnedDomainTitle);
			finalreturneddomainid = returnedDomainID;

			// in for baraye meghdardehi array marbot be sal mali ast
			for (int i = 0; i < MainActivity.authenticate.getResult()
					.getDomains().size(); i++) {

				domainidArray.add(MainActivity.authenticate.getResult()
						.getDomains().get(i).getId());
				for (int j = 0; j < MainActivity.authenticate.getResult()
						.getDomains().get(i).getFinancialYears().size(); j++) {
					if (MainActivity.authenticate.getResult().getDomains()
							.get(i).getId().equals(returnedDomainID)) {
						yeartitleArray.add(MainActivity.authenticate
								.getResult().getDomains().get(i)
								.getFinancialYears().get(j).getTitle());
						StartDateArray.add(MainActivity.authenticate
								.getResult().getDomains().get(i)
								.getFinancialYears().get(j).getStartDate());
						EndDateArray.add(MainActivity.authenticate.getResult()
								.getDomains().get(i).getFinancialYears().get(j)
								.getEndDate());
						yearidArray.add(MainActivity.authenticate.getResult()
								.getDomains().get(i).getFinancialYears().get(j)
								.getId());
					}
				}

			}
			yeartitle = (String[]) yeartitleArray
					.toArray(new String[yeartitleArray.size()]);
			yearid = (String[]) yearidArray.toArray(new String[yearidArray
					.size()]);
			// attemplogin();
		}

		if (flgforresume == 2) {// flg 2 for et_salmali
			returnedYearTitle = ListViewAlphebeticalActivity.txttitle;
			returnedYearID = ListViewAlphebeticalActivity.txtid;
			et_salmali.setText(returnedYearTitle);
			finalreturneyearid = returnedYearID;
			// =======================in for baraye daryafte "Startdate salmali"
			// and "Enddate salmali"
			for (int i = 0; i < MainActivity.authenticate.getResult()
					.getDomains().size(); i++) {
				for (int j = 0; j < MainActivity.authenticate.getResult()
						.getDomains().get(i).getFinancialYears().size(); j++) {
					if (MainActivity.authenticate.getResult().getDomains()
							.get(i).getFinancialYears().get(j).getId()
							.equals(returnedYearID)) {
						StartDate = MainActivity.authenticate.getResult()
								.getDomains().get(i).getFinancialYears().get(j)
								.getStartDate();
						EndDate = MainActivity.authenticate.getResult()
								.getDomains().get(i).getFinancialYears().get(j)
								.getEndDate();
					}

				}
			}

			Startdate_charyear = StartDate.subSequence(0, 4);
			Startdate_charmonth = StartDate.subSequence(5, 7);
			Startdate_charday = StartDate.subSequence(8, 10);

			Enddate_charyear = EndDate.subSequence(0, 4);
			Enddate_charmonth = EndDate.subSequence(5, 7);
			Enddate_charday = EndDate.subSequence(8, 10);

			attemplogin();
		}

		if (flgforresume == 1) {

			selyear.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					if (flgforresume == 0) {
						showdialog(getString(R.string.pleaseEnterDomainFirst));
					}
					flgforresume = 2;
					Intent intent = new Intent();
					intent.setClass(SelectDomainActivity.this,
							ListViewAlphebeticalActivity.class);
					intent.putExtra("arrayttitlefromjson", yeartitle);
					intent.putExtra("arrayidfromjson", yearid);
					intent.putExtra("alphebetic_title", "انتخاب سال مالی");
					startActivity(intent);

				}
			});
		} else if (flgforresume == 0) {
			// Toast.makeText(getApplicationContext(),
			// "ابتدا دامنه را وارد نمایید", 1).show();
		}
	}

	public void showdialog(String message) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		alertDialogBuilder.setTitle(getString(R.string.errorTitle));
		alertDialogBuilder.setPositiveButton(getString(R.string.ok),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					}
				});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
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

	@Override
	public void onBackPressed() {
		// super.onBackPressed();

		if (_doubleBackToExitPressedOnce) {
			// super.onBackPressed();
			showDialogForExit();
			return;
		}

		this._doubleBackToExitPressedOnce = true;

		showDialog("توجه",
				"برای ورود به صفحه بعد سال مالی و دامنه را وارد کنید");
		// Toast.makeText(this, "Please click BACK again to exit",
		// Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				_doubleBackToExitPressedOnce = false;
			}
		}, 2000);

	}

	public void showDialog(String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				SelectDomainActivity.this).setTitle(title).setMessage(message);
		builder.setPositiveButton(R.string.ok, null);
		builder.show();
	}

	public void attemplogin() {
		et_domain.setError(null);
		et_salmali.setError(null);
		mdomain = et_domain.getText().toString();
		myear = et_salmali.getText().toString();
		boolean cancel = false;
		View focusview = null;
		if (TextUtils.isEmpty(mdomain)) {
			et_domain.setError(getString(R.string.pleaseSelectDomain));
			focusview = et_domain;
			cancel = true;
		}
		if (TextUtils.isEmpty(myear)) {
			et_salmali.setError(getString(R.string.pleaseselectDomainFirst));
			focusview = et_salmali;
			cancel = true;
		}
		if (cancel) {
			c = 0;
			focusview.requestFocus();
		} else {
			c = 1;
		}

	}

}
