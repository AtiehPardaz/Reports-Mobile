package com.Atieh.reportsmobile;

import java.util.ArrayList;

import com.Atieh.reportsmobile.ShowreportsActivity.asyncTask;

import webservices.ServiceGenerator;
import GetAllSellersPack.GetAllSeller;
import GetAllSellersPack.GetAllSellerInterface;
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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import authenticationPack.Authentication;
import authenticationPack.AuthenticationInterface;
import authenticationPack.Domain;

public class SelectDomainActivity extends Activity {

	String mdomain;
	String myear;
	ImageButton sabt;
	public static String domain, years;
	String returnedID;
	String returnedTitle;
	int c;

	public static String finalreturneddomainid;
	public static String finalreturneyearid;

	ImageButton seldomain, selyear;
	public ListView list_costomer;
	String[] domaintitle, domainid;
	String[] yeartitle, yearid;
	EditText et_username, et_password;
	AuthenticationInterface auth;
	EditText et_domain, et_salmali;
	int flgforresume = 0;
	Domain dmn;
	String[] msg = null;
	public static ArrayList<String> domaintitleArray;
	public static ArrayList<String> yeartitleArray;
	public static ArrayList<String> yearidArray;
	public static ArrayList<String> domainidArray;
	private boolean _doubleBackToExitPressedOnce = false;
	AlertDialog alertDialog;

	public void initview() {
		list_costomer = (ListView) findViewById(R.id.lv_customers);
		sabt = (ImageButton) findViewById(R.id.imgbtn_sabt);
		seldomain = (ImageButton) findViewById(R.id.imgbtn_selectdomain);
		selyear = (ImageButton) findViewById(R.id.imgbtn_selectyearmali);
		et_salmali = (EditText) findViewById(R.id.et_salemali);
		et_domain = (EditText) findViewById(R.id.et_domain);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectdomain);
		initview();
		alertDialog = new AlertDialog.Builder(this).create();
		flgforresume = 0;
		// Toast.makeText(getApplicationContext(),
		// MainActivity.msg+"+"+MainActivity.msg2 + "", 1).show();

		// Toast.makeText(getApplicationContext(),
		// MainActivity.authenticate.getDomains().get(0).getTitle(), 1)
		// .show();

		// ArrayAdapter<String> adapter = new ArrayAdapter(this,
		// android.R.layout.simple_list_item_1, MainActivity.myaray);
		// list_costomer.setAdapter(adapter);

		domaintitleArray = new ArrayList<>();
		yeartitleArray = new ArrayList<>();
		yearidArray = new ArrayList<>();
		domainidArray = new ArrayList<>();

		selyear.setOnClickListener(null);

		for (int i = 0; i < MainActivity.authenticate.getResult().getDomains()
				.size(); i++) {
			domaintitleArray.add(MainActivity.authenticate.getResult()
					.getDomains().get(i).getTitle());

			domainidArray.add(MainActivity.authenticate.getResult()
					.getDomains().get(i).getId());
			// for (int j = 0; j < MainActivity.authenticate.getDomains().get(i)
			// .getFinancialYears().size(); j++) {
			//
			// yeartitleArray.add(MainActivity.authenticate.getDomains()
			// .get(i).getFinancialYears().get(j).getTitle());
			// yearidArray.add(MainActivity.authenticate.getDomains().get(i)
			// .getFinancialYears().get(j).getId());
			// }

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
				if(c==0){
					attemplogin();
				}else if(c==1){
					startActivity(new Intent(SelectDomainActivity.this,HomeActivity.class));
				}
				
				
			}
		});

		seldomain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				et_domain.setText("");
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
				intent.putExtra("arrayidfromjson", domainid);

				startActivity(intent);
				

			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();

		returnedTitle = ListViewAlphebeticalActivity.txttitle;
		returnedID = ListViewAlphebeticalActivity.txtid;

		if (flgforresume == 1) {// flg 1 for et_domain
			et_domain.setText(returnedTitle);
			finalreturneddomainid = returnedID;

			// in for baraye meghdardehi array marbot be sal mali ast
			for (int i = 0; i < MainActivity.authenticate.getResult()
					.getDomains().size(); i++) {

				domainidArray.add(MainActivity.authenticate.getResult()
						.getDomains().get(i).getId());
				for (int j = 0; j < MainActivity.authenticate.getResult()
						.getDomains().get(i).getFinancialYears().size(); j++) {
					if (MainActivity.authenticate.getResult().getDomains()
							.get(i).getId().equals(returnedID)) {
						yeartitleArray.add(MainActivity.authenticate
								.getResult().getDomains().get(i)
								.getFinancialYears().get(j).getTitle());
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
//			attemplogin();
		}

		if (flgforresume == 2) {// flg 2 for et_salmali
			et_salmali.setText(returnedTitle);
			finalreturneyearid = returnedID;
			attemplogin();
		}

		if (flgforresume == 1) {
			
			
			
			selyear.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					
					
					if (flgforresume == 0) {
						Toast.makeText(getApplicationContext(),
								"ابتدا دامنه را وارد نمایید", 1).show();
					}
					flgforresume = 2;
					Intent intent = new Intent();
					intent.setClass(SelectDomainActivity.this,
							ListViewAlphebeticalActivity.class);
					intent.putExtra("arrayttitlefromjson", yeartitle);
					intent.putExtra("arrayidfromjson", yearid);
					startActivity(intent);
					

				}
			});
		} else if (flgforresume == 0) {
			// Toast.makeText(getApplicationContext(),
			// "ابتدا دامنه را وارد نمایید", 1).show();
		}
	}

	public void showdialog(String messege) {
		this._doubleBackToExitPressedOnce = true;
		alertDialog.setIcon(R.drawable.ic_launcher);
		alertDialog.setTitle("خطا");
		alertDialog.setMessage(messege);
		alertDialog.setButton("تایید", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
				return;
			}
		});
		alertDialog.show();
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

		showdialog("برای ورود به صفحه بعد سال مالی و دامنه را وارد کنید\nو یا برای خروج کلید بازگشت را دوبار فشار دهید ");
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				_doubleBackToExitPressedOnce = false;
			}
		}, 2000);
	}

	public void attemplogin() {
		et_domain.setError(null);
		et_salmali.setError(null);
		mdomain = et_domain.getText().toString();
		myear = et_salmali.getText().toString();
		boolean cancel = false;
		View focusview = null;
		if (TextUtils.isEmpty(mdomain)) {
			et_domain.setError("لطفا دامنه را انتخال نمایید ");
			focusview = et_domain;
			cancel = true;
		}
		if (TextUtils.isEmpty(myear)) {
			et_salmali.setError("لطفا ابتدا  دامنه  و سپس سال مالی را  انتخاب نمایید");
			focusview = et_salmali;
			cancel = true;
		}
		if (cancel) {
			c=0;
			focusview.requestFocus();
		} else {
			c=1;
		}

	}

}
