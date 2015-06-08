package com.Atieh.reportsmobile;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class frg_customer_forosh extends Fragment {
	public Utils utils = Utils.getInstance();
	ImageButton datefromcustomer;
	ImageButton todateustomer;
	ImageButton selcustomer, selbazar, selForoshande;
	ImageButton btnshow;
	String resume_day, resume_month, resume_year;
	TextView et_fromdate, et_todate, et_customer, et_bazar, et_foroshande;
	checkdate chkdate;
	int flgbackforResume = 0;
	int intfromdate, inttodate;
	public static int sel = 0;
	String[] St_sellertitleArray, St_sellertidArray, St_sellerpersoncodeArray;

	public static String customerId, marketerId, sellerId;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_forosh_customer, container,
				false);
		// hideSoftKeyboard(getActivity());
		datefromcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_fromdatecustomer_frosh_);
		todateustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_todatecustomer_forosh);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh__customer_forosh);

		et_fromdate = (TextView) view.findViewById(R.id.et_fromdate_forosh);
		et_todate = (TextView) view.findViewById(R.id.et_todate_forosh);
		et_customer = (TextView) view.findViewById(R.id.et__customer_forosh);
		et_bazar = (TextView) view.findViewById(R.id.et__bazarya_forosh);
		et_foroshande = (TextView) view
				.findViewById(R.id.et__foroshande_forosh);

		selcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_customer_forosh);
		selbazar = (ImageButton) view.findViewById(R.id.imgbtn_bazaryab_forosh);
		selForoshande = (ImageButton) view
				.findViewById(R.id.imgbtn_foroshande_forosh);
		// ===========init font
		utils.setkodakfont(et_bazar);
		utils.setyekanfont(et_customer);
		utils.prepareTextView(et_fromdate);
		utils.prepareTextView(et_todate);
		utils.prepareTextView(et_foroshande);
		chkdate = new checkdate();
		// baraye inke et_fromdate va et_todate pishfarz roye tarikhe sal mali
		// iy ke az webservices migirim gharar begirad
		et_fromdate.setText(SelectDomainActivity.Startdate_charyear + "/"
				+ SelectDomainActivity.Startdate_charmonth + "/"
				+ SelectDomainActivity.Startdate_charday);
		et_todate.setText(SelectDomainActivity.Enddate_charyear + "/"
				+ SelectDomainActivity.Enddate_charmonth + "/"
				+ SelectDomainActivity.Enddate_charday);

		
		et_fromdate.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				datefromcustomer.callOnClick();
			}
		});
		et_todate.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				todateustomer.callOnClick();
			}
		});
		et_bazar.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				selbazar.callOnClick();
			}
		});
		et_customer.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				selcustomer.callOnClick();
			}
		});
		et_foroshande.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				selForoshande.callOnClick();
			}
		});

		datefromcustomer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent report = new Intent();
				if (et_fromdate.getText().equals("")) {
					report.putExtra("flg_resamedate", 0);
				} else {
					report.putExtra("flg_resamedate", 1);
					CharSequence charyear = et_fromdate.getText().subSequence(
							0, 4);
					CharSequence charmonth = et_fromdate.getText().subSequence(
							5, 7);
					CharSequence charday = et_fromdate.getText().subSequence(8,
							10);
					String newday = charday.toString();
					String newmonth = charmonth.toString();
					String newyear = charyear.toString();
					report.putExtra("newday", newday);
					report.putExtra("newmonth", newmonth);
					report.putExtra("newyear", newyear);

				}
				report.setClass(getActivity(), DatepickerActivity.class);
				startActivity(report);

				flgbackforResume = 1;

				// do something

				// final InputMethodManager imm = (InputMethodManager)
				// getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
				// imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);

			}
		});
		todateustomer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent report = new Intent();
				if (et_todate.getText().equals("")) {
					report.putExtra("flg_resamedate", 0);
				} else {
					report.putExtra("flg_resamedate", 1);
					CharSequence charyear = et_todate.getText().subSequence(0,
							4);
					CharSequence charmonth = et_todate.getText().subSequence(5,
							7);
					CharSequence charday = et_todate.getText().subSequence(8,
							10);
					String newday = charday.toString();
					String newmonth = charmonth.toString();
					String newyear = charyear.toString();
					report.putExtra("newday", newday);
					report.putExtra("newmonth", newmonth);
					report.putExtra("newyear", newyear);

				}
				report.setClass(getActivity(), DatepickerActivity.class);
				startActivity(report);
				flgbackforResume = 2;

			}
		});
		selcustomer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 1;
				// startActivity(new Intent(getActivity(),
				// ListViewAlphebeticalActivity.class));

				St_sellertitleArray = (String[]) HomeActivity.mostarititleArray
						.toArray(new String[HomeActivity.mostarititleArray
								.size()]);
				St_sellertidArray = (String[]) HomeActivity.moshtariidArray
						.toArray(new String[HomeActivity.moshtariidArray.size()]);
				St_sellerpersoncodeArray = (String[]) HomeActivity.mostaripersoncodeArray
						.toArray(new String[HomeActivity.mostaripersoncodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_sellertitleArray);
				intent.putExtra("arrayidfromjson", St_sellertidArray);
				intent.putExtra("side", true);
				intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 3;

			}
		});
		selbazar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 2;
				St_sellertitleArray = (String[]) HomeActivity.bazaryabtitleArray
						.toArray(new String[HomeActivity.bazaryabtitleArray
								.size()]);
				St_sellertidArray = (String[]) HomeActivity.bazaryabidArray
						.toArray(new String[HomeActivity.bazaryabidArray.size()]);
				St_sellerpersoncodeArray = (String[]) HomeActivity.bazaryabpersoncodeArray
						.toArray(new String[HomeActivity.bazaryabpersoncodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_sellertitleArray);
				intent.putExtra("arrayidfromjson", St_sellertidArray);
				intent.putExtra("side", true);
				intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 4;

			}
		});
		selForoshande.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// sel = 4;

				St_sellertitleArray = (String[]) HomeActivity.sellertitleArray
						.toArray(new String[HomeActivity.sellertitleArray
								.size()]);
				St_sellertidArray = (String[]) HomeActivity.selleridArray
						.toArray(new String[HomeActivity.selleridArray.size()]);
				St_sellerpersoncodeArray = (String[]) HomeActivity.sellerpersoncodeArray
						.toArray(new String[HomeActivity.sellerpersoncodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_sellertitleArray);
				intent.putExtra("arrayidfromjson", St_sellertidArray);

				intent.putExtra("side", true);
				intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 5;

			}
		});

		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);
				if (et_fromdate.getText().equals("")) {
					showMessage("لطفا تاریخ ابتدا را وارد نمایید");
				} else if (et_todate.getText().equals("")) {
					showMessage("لطفا تاریخ انتها را وارد نمایید");
				} else if (et_customer.getText().equals("")) {
					showMessage("لطفا مشتری  را وارد نمایید");
				} else if (et_bazar.getText().equals("")) {
					showMessage("لطفا  بازاریاب  را وارد نمایید");
				} else if (et_foroshande.getText().equals("")) {
					showMessage("لطفا  فروشنده را وارد نمایید");
				} else {
					if (chkdate.checkdate(et_fromdate, et_todate) == 0) {

						String ReportsUrl;
						ReportsUrl = "Report.aspx?" + "saleStaffIds="
								+ sellerId.toString() + "&customerPersonIds="
								+ customerId.toString() + "&marketerPersonIds="
								+ marketerId.toString() + "&FromDate="
								+ et_fromdate.getText() + "&ToDate="
								+ et_todate.getText();

						Intent report = new Intent();
						report.putExtra("gozaresh", ReportsUrl);

						report.putExtra("sellerId", sellerId);

						report.setClass(getActivity(),
								ShowreportsActivity.class);

						startActivity(report);
					} else if (chkdate.checkdate(et_fromdate, et_todate) == 1) {
						showMessage("تاریخ انتها کوچکتر از تاریخ ابتدا می باشد");
					} else if (chkdate.checkdate(et_fromdate, et_todate) == 2) {
						showMessage("تاریخ ابتدا و انتها برابر است");
					}

				}
			}
		});

		return view;
	}

	private void showMessage(String message) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());
		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		alertDialogBuilder.setTitle("خطا");
		alertDialogBuilder.setPositiveButton("تایید",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					}
				});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		if (flgbackforResume == 1) {
			intfromdate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);

			et_fromdate.setText(DatepickerActivity.myYear + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myDay);

		} else if (flgbackforResume == 2) {
			inttodate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);
			et_todate.setText(DatepickerActivity.myYear + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myDay);
		}

		else if (flgbackforResume == 3) {
			customerId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			et_customer
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 4) {
			marketerId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			et_bazar.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 5) {

			sellerId = ListViewAlphebeticalActivity.selidfromalphebeticlist;

			et_foroshande
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		}

		// Toast.makeText(getActivity(), "1", 1).show();
	}

	public static void hideSoftKeyboard(Activity activity) {
		InputMethodManager inputMethodManager = (InputMethodManager) activity
				.getSystemService(Activity.INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus()
				.getWindowToken(), 0);
	}
}
