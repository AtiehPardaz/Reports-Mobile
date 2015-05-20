package com.Atieh.reportsmobile;

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

public class FrgDaryaftiKhazane extends Fragment {
	public Utils utils = Utils.getInstance();
	ImageButton btnshow, pardakhtebteda, pardakhtenteha, sarresidebteda,
			sarresidenteha, shakhs;

	TextView et_pardakhtebteda, et_pardakhtenteha, et_sarresidebteda,
			et_sarresidenteha, et_shakhs;

	int flgbackforResume = 0;
	int intfromdatepardakht, inttodatepardakht, intfromdatesarresid,
			inttodatesarresid;
	public static int sel = 0;
	String[] St_titleArray, St_tidArray, St_personcodeArray;

	String customerId, marketerId, sellerId;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_khazane_asnaddaryafti,
				container, false);
		// hideSoftKeyboard(getActivity());
		pardakhtebteda = (ImageButton) view
				.findViewById(R.id.imgbtn_date_pardakhtebteda_daryaftikhazane);
		pardakhtenteha = (ImageButton) view
				.findViewById(R.id.imgbtn_date_pardakhtenteha_daryaftikhazane);
		sarresidebteda = (ImageButton) view
				.findViewById(R.id.imgbtn_date_sarresidebteda_daryaftikhazane);
		sarresidenteha = (ImageButton) view
				.findViewById(R.id.imgbtn_date_sarresidenteha_daryaftikhazane);
		shakhs = (ImageButton) view
				.findViewById(R.id.imgbtn_shakhs_daryaftikhazane);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_daryafti_khazane);
		// ============================
		et_pardakhtebteda = (TextView) view
				.findViewById(R.id.et_date_pardakhtebtedaa_daryaftikhazane);
		et_pardakhtenteha = (TextView) view
				.findViewById(R.id.et_date_pardakhtenteha_daryaftikhazane);
		et_sarresidebteda = (TextView) view
				.findViewById(R.id.et_date_sarresidebteda_daryaftikhazane);
		et_sarresidenteha = (TextView) view
				.findViewById(R.id.et_date_sarresidenteha_daryaftikhazanee);
		et_shakhs = (TextView) view
				.findViewById(R.id.et_skhakhs_daryaftikhazane);

		pardakhtebteda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				flgbackforResume = 1;
				// do something

				// final InputMethodManager imm = (InputMethodManager)
				// getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
				// imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);

			}
		});
		pardakhtenteha.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				flgbackforResume = 2;

			}
		});
		sarresidebteda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 1;
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				flgbackforResume = 3;

			}
		});
		sarresidenteha.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 2;
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				flgbackforResume = 4;

			}
		});
		shakhs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// sel = 4;

				St_titleArray = (String[]) HomeActivity.shakhstitleArray
						.toArray(new String[HomeActivity.shakhstitleArray
								.size()]);
				St_tidArray = (String[]) HomeActivity.shakhsidArray
						.toArray(new String[HomeActivity.shakhsidArray.size()]);
				St_personcodeArray = (String[]) HomeActivity.shakhspersoncodeArray
						.toArray(new String[HomeActivity.shakhspersoncodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_titleArray);
				intent.putExtra("arrayidfromjson", St_tidArray);
			intent.putExtra("side", true);intent.putExtra("search", true);
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
				boolean flgpardakht = false, flgsarresid = false;

				if (et_pardakhtebteda.getText().equals("")) {
					showMessage("لطفا تاریخ پرداخت ابتدا را وارد نمایید");
				} else if (et_pardakhtenteha.getText().equals("")) {
					showMessage("لطفا تاریخ پرداخت انتها را وارد نمایید");
				} else if (et_sarresidebteda.getText().equals("")) {
					showMessage("لطفا تاریخ سررسید ابتدا را وارد نمایید");
				} else if (et_sarresidenteha.getText().equals("")) {
					showMessage("لطفا تاریخ سررسید انتها را وارد نمایید");
				} else if (et_shakhs.getText().equals("")) {
					showMessage("لطفا  نام شخص گیرنده را وارد نمایید");
				} else {

					if (flgpardakht == false && flgsarresid == false) {

						if (checkdate(intfromdatepardakht, inttodatepardakht) == 0) {
							flgpardakht = true;
						} else if (checkdate(intfromdatepardakht,
								inttodatepardakht) == 1) {
							showMessage("تاریخ پرداخت انتها کوچکتر از تاریخ پرداخت ابتدا می باشد");
						} else if (checkdate(intfromdatepardakht,
								inttodatepardakht) == 2) {
							showMessage("تاریخ پرداخت ابتدا و  پرداخت انتها برابر است");
						}
					}
					// ========================

					if (checkdate(intfromdatesarresid, inttodatesarresid) == 0) {
						flgsarresid = true;

					} else if (checkdate(intfromdatesarresid, inttodatesarresid) == 1) {
						showMessage("تاریخ سررسید انتها کوچکتر از تاریخ سررسید ابتدا می باشد");
					} else if (checkdate(intfromdatesarresid, inttodatesarresid) == 2) {
						showMessage("تاریخ سررسید ابتدا و سررسید انتها برابر است");
					}
					// =====================

					if (flgpardakht == true && flgsarresid == true) {
						Intent report = new Intent();
						report.putExtra("gozaresh", "daryaftikhazane");
						report.setClass(getActivity(),
								ShowreportsActivity.class);
						startActivity(report);
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

	public int checkdate(int fromdate, int todate) {
		int flgcheck = 0;
		if (todate - fromdate > 0) {
			flgcheck = 0;
			// "halate dorost hamine
		} else if (todate - fromdate < 0) {
			flgcheck = 1;
			// "tarikhe dovom kochaktarast"

		} else if (todate - fromdate == 0) {
			flgcheck = 2;
			// "tarikhe aval va dovom barabar"

		}
		return flgcheck;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		if (flgbackforResume == 1) {
			intfromdatepardakht = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);

			et_pardakhtebteda.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);

		} else if (flgbackforResume == 2) {
			inttodatepardakht = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);
			et_pardakhtenteha.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
		}

		else if (flgbackforResume == 3) {
			intfromdatesarresid = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);

			et_sarresidebteda.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
		} else if (flgbackforResume == 4) {
			inttodatesarresid = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);

			et_sarresidenteha.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
		} else if (flgbackforResume == 5) {

			et_shakhs
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
