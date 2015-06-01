package com.Atieh.reportsmobile;

import java.util.ArrayList;
import java.util.List;

import adapters.NothingSelectedSpinnerAdapter;
import android.R.string;
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
import android.widget.Toast;

public class FrgGardeshHesabdari extends Fragment {
	public Utils utils = Utils.getInstance();

	ImageButton todateustomer, datefromcustomer, selsathtafsil,
			OpenspnrOnvanTafsil, openseltafsil, btnshow;

	TextView et_fromdate, et_todate, selecttafsil, et_sathtafsil;
	Spinner spinertafsil, spnr_sathtafsil;
	List<String> stats, sathtafsil;
	String[] tafsillevel;
	int flgbackforResume = 0;
	int intfromdate, inttodate;
	public static int sel = 0;
	String[] St_titleArray, St_idArray;
	int flg_selecttafsil = 0, type = 0;
	String pId;

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
		spnr_sathtafsil = (Spinner) view
				.findViewById(R.id.spnr_sathtafsil_hesabdari);
		selecttafsil = (TextView) view
				.findViewById(R.id.et_sathtafsil_hesabdari);
		datefromcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_fromdate_gardesh_hesabdari);
		todateustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_todategardesh_hesabdari);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_gardesh_hesabdari);
		selsathtafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_sathtafsil_hesabdari);
		spinertafsil = (Spinner) view.findViewById(R.id.spinner1);
		OpenspnrOnvanTafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_onvantafsil_hesabdari);
		openseltafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_tafsil_hesabdari);
		et_fromdate = (TextView) view
				.findViewById(R.id.et_fromdate_gardesh_hesabdari);
		et_todate = (TextView) view
				.findViewById(R.id.et_todate_gardesh_hesabdari);
		// =============init font
		utils.setyekanfont(et_fromdate);
		utils.setyekanfont(et_todate);
		utils.setyekanfont(selecttafsil);
		// utils.setyekanfont(et_sathtafsil);

		ArrayAdapter<String> arraytafsiltitle = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_dropdown_item);

		// ArrayAdapter<CharSequence> arraytafsiltitle =
		// ArrayAdapter.createFromResource(
		// getActivity(), R.array.tafsiltitle,
		// android.R.layout.simple_spinner_item);

		/**
		 * arraytafsiltitle .setDropDownViewResource(android.R.layout.
		 * simple_spinner_dropdown_item); arraytafsiltitle.add("hint");
		 * arraytafsiltitle.add("1"); arraytafsiltitle.add("2");
		 * arraytafsiltitle.add("3"); arraytafsiltitle.add("4");
		 * 
		 * spinertafsil.setAdapter(arraytafsiltitle);
		 * 
		 * spinertafsil.setSelection(-1);
		 */
		stats = new ArrayList<String>();
		stats.add("شخص");
		stats.add("ارز");
		stats.add("مرکز هزینه");
		stats.add("پروژه");

		ArrayAdapter<String> statsAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, stats);

		statsAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinertafsil.setAdapter(new NothingSelectedSpinnerAdapter(statsAdapter,
				R.layout.activity_stats_nothing_selected, getActivity()));

		spinertafsil
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						/**
						 * TextView textView = (TextView) spinertafsil
						 * .getSelectedView(); String result =
						 * textView.getText().toString();
						 */
						switch (pos) {

						case 1:
							selecttafsil.setHint("شخص");
							selecttafsil.setText("");
							flg_selecttafsil = 1;
							type = 0;

							break;
						case 2:
							selecttafsil.setHint("ارز");
							selecttafsil.setText("");
							flg_selecttafsil = 2;
							type = 3;
							break;
						case 3:
							selecttafsil.setHint("مرکز هزینه");
							selecttafsil.setText("");
							flg_selecttafsil = 3;
							type = 2;
							break;
						case 4:
							selecttafsil.setHint("پروژه");
							selecttafsil.setText("");
							flg_selecttafsil = 4;
							type = 1;
							break;

						default:
							selecttafsil.setHint("عنوان");
						}

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});
		// =======================================
		int sath = Integer.parseInt(HomeActivity.level.getResult().getLevel());
		sathtafsil = new ArrayList<String>();
		// tafsillevel = new String[sath + 1];
		for (int i = 1; i <= sath; i++) {
			// tafsillevel[i] = "سطح"+i;
			sathtafsil.add(String.valueOf(i));
			// Toast.makeText(getActivity(), tafsillevel[i] + "", 1).show();
		}
		ArrayAdapter<String> statsAdaptersath = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, sathtafsil);

		statsAdaptersath
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spnr_sathtafsil.setAdapter(new NothingSelectedSpinnerAdapter(
				statsAdaptersath,
				R.layout.activity_status_nothing_selected_sath, getActivity()));

		spnr_sathtafsil
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
					}

				});

		OpenspnrOnvanTafsil.setOnClickListener(new OnClickListener() {

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

		selsathtafsil.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		openseltafsil.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (flg_selecttafsil == 0) {
					showDialog("توجه",
							"لطفا ابتدا عنوان تفصیل را انتخاب نمایید");

				} else if (flg_selecttafsil == 1) {// for shakhs
					flgbackforResume = 3;
					St_titleArray = (String[]) HomeActivity.shakhstitleArray
							.toArray(new String[HomeActivity.shakhstitleArray
									.size()]);
					St_idArray = (String[]) HomeActivity.shakhsidArray
							.toArray(new String[HomeActivity.shakhsidArray
									.size()]);

					Intent intent = new Intent();
					intent.setClass(getActivity(),
							ListViewAlphebeticalActivity.class);
					intent.putExtra("arrayttitlefromjson", St_titleArray);
					intent.putExtra("arrayidfromjson", St_idArray);
					intent.putExtra("side", true);
					intent.putExtra("search", true);
					startActivity(intent);
				} else if (flg_selecttafsil == 2) {// for arz
					flgbackforResume = 4;
					St_titleArray = (String[]) HomeActivity.currenciestitleArray
							.toArray(new String[HomeActivity.currenciestitleArray
									.size()]);
					St_idArray = (String[]) HomeActivity.currenciesidArray
							.toArray(new String[HomeActivity.currenciesidArray
									.size()]);

					Intent intent = new Intent();
					intent.setClass(getActivity(),
							ListViewAlphebeticalActivity.class);
					intent.putExtra("arrayttitlefromjson", St_titleArray);
					intent.putExtra("arrayidfromjson", St_idArray);
					intent.putExtra("side", true);
					intent.putExtra("search", true);
					startActivity(intent);
				} else if (flg_selecttafsil == 3) {// for costcenter
					flgbackforResume = 5;
					St_titleArray = (String[]) HomeActivity.costcenterstitleArray
							.toArray(new String[HomeActivity.costcenterstitleArray
									.size()]);
					St_idArray = (String[]) HomeActivity.costcentersidArray
							.toArray(new String[HomeActivity.costcentersidArray
									.size()]);

					Intent intent = new Intent();
					intent.setClass(getActivity(),
							ListViewAlphebeticalActivity.class);
					intent.putExtra("arrayttitlefromjson", St_titleArray);
					intent.putExtra("arrayidfromjson", St_idArray);
					intent.putExtra("side", true);
					intent.putExtra("search", true);
					startActivity(intent);
				} else if (flg_selecttafsil == 4) {// for project
					flgbackforResume = 6;
					St_titleArray = (String[]) HomeActivity.projectstitleArray
							.toArray(new String[HomeActivity.projectstitleArray
									.size()]);
					St_idArray = (String[]) HomeActivity.projectsidArray
							.toArray(new String[HomeActivity.projectsidArray
									.size()]);

					Intent intent = new Intent();
					intent.setClass(getActivity(),
							ListViewAlphebeticalActivity.class);
					intent.putExtra("arrayttitlefromjson", St_titleArray);
					intent.putExtra("arrayidfromjson", St_idArray);
					intent.putExtra("side", true);
					intent.putExtra("search", true);
					startActivity(intent);
				}
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
				} else if (selecttafsil.getText().equals("")) {
					showMessage("لطفا تفصیل را وارد نمایید");
				}

				
				// else if (et_foroshande.getText().equals("")) {
				// showMessage("لطفا  فروشنده را وارد نمایید");
				// }
				else {
					if (checkdate(intfromdate, inttodate) == 0) {
						String ReportsUrl;
						ReportsUrl = "Accounting/AccountingTafsil.aspx?"
								+ "PersonIds=" + pId.toString() + "&startDate="
								+ et_fromdate.getText() + "&endDate="
								+ et_todate.getText() + "&Type=" + type
								+ "&Level="
								+ spnr_sathtafsil.getSelectedItem().toString();

						Intent report = new Intent();
						report.putExtra("gozaresh", ReportsUrl);

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

			et_fromdate.setText(DatepickerActivity.myYear + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myDay);

		} else if (flgbackforResume == 2) {
			inttodate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);
			et_todate.setText(DatepickerActivity.myYear + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myDay);
		} else if (flgbackforResume == 3) {
			pId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			selecttafsil
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 4) {
			pId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			selecttafsil
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 5) {
			pId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			selecttafsil
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 6) {
			pId = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			selecttafsil
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

	public void showDialog(String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
				.setTitle(title).setMessage(message);
		builder.setPositiveButton(R.string.ok, null);
		builder.show();
	}
}
