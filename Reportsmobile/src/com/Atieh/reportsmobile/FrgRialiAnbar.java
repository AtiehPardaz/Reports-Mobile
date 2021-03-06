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
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

public class FrgRialiAnbar extends Fragment {
	public Utils utils = Utils.getInstance();
	ImageButton date, selKala, selanbar, btnshow;
	TextView et_date, et_kala, et_anbar;
	CheckBox chktajmiiy;
	int flgbackforResume = 0;
	int intfromdate, inttodate;
	public static int sel = 0;
	String[] St_titleArray, St_idArray, St_personcodeArray;
	public static String warehouseId, productId;
	checkdate chkdate;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_kala_riali, container, false);
		// hideSoftKeyboard(getActivity());

		chktajmiiy = (CheckBox) view.findViewById(R.id.chk_tajmiiy_rialianbar);
		// =====================ImageButton
		date = (ImageButton) view.findViewById(R.id.imgbtn_datee_riali_kala);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_riali_kalaanbar);
		selanbar = (ImageButton) view
				.findViewById(R.id.imgbtn_anbarha_riali_kala);
		selKala = (ImageButton) view.findViewById(R.id.imgbtn_kala_riali_kala);
		// =========================textview
		et_date = (TextView) view.findViewById(R.id.et_date_riali_kala);
		et_kala = (TextView) view.findViewById(R.id.et_kala_riali_kala);
		et_anbar = (TextView) view.findViewById(R.id.et_anbarha_riali_kala);

		// ============================init font
				utils.setyekanfont(et_date);
				utils.setyekanfont(et_kala);
				utils.setyekanfont(et_anbar);
				utils.setyekanfont(chktajmiiy);
				 chkdate=new checkdate();
				 
				// ====================callOnClick
				et_date.setOnClickListener(new OnClickListener() {
					@SuppressLint("NewApi")
					@Override
					public void onClick(View arg0) {
						date.callOnClick();
					}
				});
				et_anbar.setOnClickListener(new OnClickListener() {
					@SuppressLint("NewApi")
					@Override
					public void onClick(View arg0) {
						selanbar.callOnClick();
					}
				});
				et_kala.setOnClickListener(new OnClickListener() {
					@SuppressLint("NewApi")
					@Override
					public void onClick(View arg0) {
						selKala.callOnClick();
					}
				});

		date.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent report = new Intent();
				if (et_date.getText().equals("")) {
					report.putExtra("flg_resamedate", 0);
				} else {
					report.putExtra("flg_resamedate", 1);
					CharSequence charyear=et_date.getText().subSequence(0, 4);
					CharSequence charmonth=et_date.getText().subSequence(5, 7);
					CharSequence charday=et_date.getText().subSequence(8, 10);
					String newday=charday.toString();
					String newmonth=charmonth.toString();
					String newyear=charyear.toString();
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
		selKala.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// sel = 4;

				St_titleArray = (String[]) HomeActivity.producttitleArray
						.toArray(new String[HomeActivity.producttitleArray
								.size()]);
				St_idArray = (String[]) HomeActivity.productidArray
						.toArray(new String[HomeActivity.productidArray.size()]);
				St_personcodeArray = (String[]) HomeActivity.productcodeArray
						.toArray(new String[HomeActivity.productcodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_titleArray);
				intent.putExtra("arrayidfromjson", St_idArray);
				intent.putExtra("side", true);
				intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 3;

			}
		});
		selanbar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// sel = 4;

				St_titleArray = (String[]) HomeActivity.warehousetitleArray
						.toArray(new String[HomeActivity.warehousetitleArray
								.size()]);
				St_idArray = (String[]) HomeActivity.warehouseidArray
						.toArray(new String[HomeActivity.warehouseidArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_titleArray);
				intent.putExtra("arrayidfromjson", St_idArray);
				intent.putExtra("side", true);
				intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 2;

			}
		});

		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);
				if (et_date.getText().equals("")) {
					showMessage("لطفا تاریخ  را وارد نمایید");
				} else if (et_kala.getText().equals("")) {
					showMessage("لطفا  کالا را وارد نمایید");
				} else if (et_anbar.getText().equals("")) {
					showMessage("لطفا  انبار را وارد نمایید");
				} else {

					Intent report = new Intent();
					String ReportsUrl = null;
					if (chktajmiiy.isChecked()) {
						ReportsUrl = "WareHouse/WareHouseAgreagateRials.aspx?"
								+ "productIds=" + productId.toString()
								+ "&warehouseIds=" + warehouseId.toString()
								+ "&FromDate=" + et_date.getText() + "&ToDate="
								+ et_date.getText();

//						+"&Token="+ HomeActivity.token.toString()+"&FinancialYearId="+
//						SelectDomainActivity.finalreturneyearid.toString();

					} else {
						ReportsUrl = "WareHouse/WareHouseRials.aspx?"
								+ "productIds=" + productId.toString()
								+ "&warehouseIds=" + warehouseId.toString()
								+ "&FromDate=" + et_date.getText() + "&ToDate="
								+ et_date.getText();

//						+"&Token="+ HomeActivity.token.toString()+"&FinancialYearId="+
//						SelectDomainActivity.finalreturneyearid.toString();
					}

					report.putExtra("gozaresh", ReportsUrl);
					report.putExtra("activityname", "kalaactivity");
					report.setClass(getActivity(), ShowreportsActivity.class);
					startActivity(report);
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
		super.onResume();

		if (flgbackforResume == 1) {
			intfromdate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);
			et_date.setText(DatepickerActivity.myYear + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myDay);
		} else if (flgbackforResume == 3) {
			productId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			et_kala.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 2) {
			warehouseId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			et_anbar.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		}

	}

	public static void hideSoftKeyboard(Activity activity) {
		InputMethodManager inputMethodManager = (InputMethodManager) activity
				.getSystemService(Activity.INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus()
				.getWindowToken(), 0);
	}
}
