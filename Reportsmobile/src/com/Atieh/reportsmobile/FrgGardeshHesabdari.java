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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class FrgGardeshHesabdari extends Fragment {
	public Utils utils = Utils.getInstance();
	ImageButton datefromcustomer;
	ImageButton todateustomer;
	ImageButton selcustomer, selbazar, selForoshande;
	ImageButton btnshow;
	ImageButton opennspiner;
	TextView et_fromdate, et_todate;
	EditText selecttafsil;
	Spinner spinertafsil;
	
	int flgbackforResume = 0;
	int intfromdate, inttodate;
	public static int sel = 0;
	String[] St_titleArray, St_idArray;

	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_hesabdari_gardesh, container,
				false);
		// hideSoftKeyboard(getActivity());
		
		selecttafsil = (EditText) view
				.findViewById(R.id.et_shakhsgardesh_hesabdarii);
		datefromcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_fromdate_gardesh_hesabdari);
		todateustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_todategardesh_hesabdari);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_gardesh_hesabdari);
		spinertafsil = (Spinner) view.findViewById(R.id.spinner1);
		opennspiner = (ImageButton) view
				.findViewById(R.id.imgbtn_selectshakhsgardesh_hesabdari);
		et_fromdate = (TextView) view
				.findViewById(R.id.et_fromdate_gardesh_hesabdari);
		et_todate = (TextView) view
				.findViewById(R.id.et_todate_gardesh_hesabdari);

		ArrayAdapter<CharSequence> arraytafsiltitle = ArrayAdapter.createFromResource(
				getActivity(), R.array.tafsiltitle,
				android.R.layout.simple_spinner_item);
		arraytafsiltitle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinertafsil.setAdapter(arraytafsiltitle);
		
		
		spinertafsil
		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					View view, int pos, long id) {

				String text = spinertafsil.getSelectedItem().toString();
				switch (text) {
				case "شخص":
					selecttafsil.setText("شخص");
					break;
				case "ارز":
					selecttafsil.setText("ارز");
					break;
				case "مرکز هزینه":
					selecttafsil.setText("مرکز هزینه");
					break;
				case "مرکز پروژه":
					selecttafsil.setText("مرکز پروژه");
					break;

				default:
					selecttafsil.setText("شخص");
				}

			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
opennspiner.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		spinertafsil.performClick();
	}
});
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
				}
				// else if (et_customer.getText().equals("")) {
				// showMessage("لطفا مشتری  را وارد نمایید");
				// } else if (et_bazar.getText().equals("")) {
				// showMessage("لطفا  بازاریاب  را وارد نمایید");
				// } else if (et_foroshande.getText().equals("")) {
				// showMessage("لطفا  فروشنده را وارد نمایید");
				// }
				else {
					if (checkdate(intfromdate, inttodate) == 0) {
						Intent report = new Intent();
						report.putExtra("gozaresh", "gardeshhesabdari");
						report.setClass(getActivity(),
								ShowreportsActivity.class);
						startActivity(report);
					} else if (checkdate(intfromdate, inttodate) == 1) {
						showMessage("تاریخ انتها کوچکتر از تاریخ ابتدا می باشد");
					} else if (checkdate(intfromdate, inttodate) == 2) {
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
			intfromdate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);

			et_fromdate.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);

		} else if (flgbackforResume == 2) {
			inttodate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);
			et_todate.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
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
