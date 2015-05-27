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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class FrgVaziatDaryaftiKhazane extends Fragment {
	public Utils utils = Utils.getInstance();
	ImageButton selpardakhtkonande;

	ImageButton btnshow;

	TextView et_pardakhtkonande;
	EditText et_shomarehesab, et_shomarecheck;

	int flgbackforResume = 0;
	int intfromdate, inttodate;
	public static int sel = 0;
	String[] St_titleArray, St_idArray, St_personcodeArray;

	String CheckNumber, AccountNumberId, PersonNameId;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_khazane_vaziatdaryafti,
				container, false);
		// hideSoftKeyboard(getActivity());
		selpardakhtkonande = (ImageButton) view
				.findViewById(R.id.imgbtn_pardakhtkonande_vaziatasnaddaryafti_khazane);

		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_vaziatasnaddaryaftii_khazane);

		et_pardakhtkonande = (TextView) view
				.findViewById(R.id.et_pardakhtkonande_vaziatdaryaftikhazane);
		et_shomarehesab = (EditText) view
				.findViewById(R.id.et_shomarehesab_vaziatdaryaftikhazane);
		et_shomarecheck = (EditText) view
				.findViewById(R.id.et_shomarecheck_vaziatdaryaftikhazane);
		// =============init font
		utils.setyekanfont(et_pardakhtkonande);
		utils.setyekanfont(et_shomarehesab);
		utils.setyekanfont(et_shomarecheck);
		// ================callOnClick
		et_pardakhtkonande.setOnClickListener(new OnClickListener() {
			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				selpardakhtkonande.callOnClick();
			}
		});
		
		selpardakhtkonande.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				St_titleArray = (String[]) HomeActivity.shakhstitleArray
						.toArray(new String[HomeActivity.shakhstitleArray
								.size()]);
				St_idArray = (String[]) HomeActivity.shakhsidArray
						.toArray(new String[HomeActivity.shakhsidArray.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_titleArray);
				intent.putExtra("arrayidfromjson", St_idArray);
				intent.putExtra("side", true);
				intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 1;
			}
		});

		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);
				if (et_pardakhtkonande.getText().equals("")) {
					showMessage("لطفا نام پرداخت کننده را وارد نمایید");
				} else if (et_shomarecheck.getText().toString().matches("")) {
					showMessage("لطفا شماره چک را وارد نمایید");
				} else if (et_shomarehesab.getText().toString().matches("")) {
					showMessage("لطفا شماره حساب را وارد نمایید");
				} else {
					Intent report = new Intent();
					String ReportsUrl;
					ReportsUrl = "Document/GetDocumentStatus.aspx?"
							+ "CheckNumber=" + et_shomarecheck.getText()
							+ "&AccountNumber=" + et_shomarehesab.getText();
					report.putExtra("gozaresh", ReportsUrl);
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
		// TODO Auto-generated method stub
		super.onResume();

		if (flgbackforResume == 1) {
			PersonNameId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			et_pardakhtkonande
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
