package com.Atieh.reportsmobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class frg_customer_forosh extends Fragment {

	ImageButton datefromcustomer;
	ImageButton todateustomer;
	ImageButton selcustomer, selbazar;
	ImageButton btnshow;
	EditText et_fromdate;
	EditText et_todate;
	EditText et_customer, et_bazar;
	int flgbackforResume = 0;
	public static int sel = 0;

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
		et_fromdate = (EditText) view.findViewById(R.id.et_fromdate_forosh);
		et_todate = (EditText) view.findViewById(R.id.et_todate_forosh);
		et_customer = (EditText) view.findViewById(R.id.et__customer_forosh);
		et_bazar = (EditText) view.findViewById(R.id.et__bazarya_forosh);
		selcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_customer_forosh);
		selbazar = (ImageButton) view.findViewById(R.id.imgbtn_bazaryab_forosh);
		datefromcustomer.setOnClickListener(new OnClickListener() {
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
		todateustomer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				flgbackforResume = 2;

			}
		});
		selcustomer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 1;
				startActivity(new Intent(getActivity(),
						ListViewAlphebeticalActivity.class));
				flgbackforResume = 3;

			}
		});
		selbazar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 2;
				startActivity(new Intent(getActivity(),
						ListViewAlphebeticalActivity.class));
				flgbackforResume = 4;

			}
		});

		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);

				Intent report = new Intent();
				report.putExtra("gozaresh", "customer");
				report.setClass(getActivity(), ShowreportsActivity.class);
				startActivity(report);
			}
		});

		return view;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		if (flgbackforResume == 1) {
			et_fromdate.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
		} else if (flgbackforResume == 2) {
			et_todate.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
		} else if (flgbackforResume == 3) {
			et_customer
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 4) {
			et_bazar.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
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
