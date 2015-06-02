package com.Atieh.reportsmobile;

import java.util.ArrayList;
import java.util.List;

import adapters.NothingSelectedSpinnerAdapter;
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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FrgTarkibHesabdari extends Fragment {
	public Utils utils = Utils.getInstance();

	ImageButton img_todate, img_datefrom, img_selsathtafsil,
			img2_selsathtafsil, img_OnvanTafsil, img2_OnvanTafsil, img_tafsil,
			img2_tafsil, btnshow;

	TextView et_fromdate, et_todate, selecttafsil, et_sathtafsil,selecttafsil2;
	Spinner spnr_onvantafsil, spnr_sathtafsil, spnr2_sathtafsil,
			spnr2_onvantafsil;
	List<String> stats, stats2, sathtafsil, sath2tafsil;
	String[] tafsillevel;
	int flgbackforResume = 0;
	int intfromdate, inttodate;
	public static int sel = 0;
	String[] St_titleArray, St_idArray;
	int flg_selecttafsil = 0,flg_selecttafsil2=0, type = 0;
	String pId,pId2;
	int sath;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_tarkibi, container, false);

		et_fromdate = (TextView) view
				.findViewById(R.id.et_fromdate_tarkibi_hesabdari);
		et_todate = (TextView) view
				.findViewById(R.id.et_todate_tarkibi_hesabdari);
		selecttafsil = (TextView) view
				.findViewById(R.id.et_sathtafsiltarkibi_hesabdari);
		selecttafsil2 = (TextView) view
				.findViewById(R.id.et_sathtafsil2tarkibi_hesabdari);
		// ==================================
		spnr_sathtafsil = (Spinner) view
				.findViewById(R.id.spnr_sathtafsiltarkibi_hesabdari);
		spnr2_sathtafsil = (Spinner) view
				.findViewById(R.id.spnr_sathtafsil2tarkibi_hesabdari);
		spnr_onvantafsil = (Spinner) view.findViewById(R.id.spnrOnvan2ta);
		spnr2_onvantafsil = (Spinner) view.findViewById(R.id.spnrOnvan2tae2);
		// ==========================================
		img_datefrom = (ImageButton) view
				.findViewById(R.id.imgbtn_fromdate_tarkibi_hesabdari);
		img_todate = (ImageButton) view
				.findViewById(R.id.imgbtn_todatetarkibi_hesabdari);

		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_tarkibi_hesabdari);
		img_selsathtafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_sathtafsiltarkibi_hesabdari);
		img2_selsathtafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_sathtafsil2tarkibi_hesabdari);

		img_OnvanTafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_onvantafsil_tarkibi_hesabdari);
		img2_OnvanTafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_onvantafsil2_tarkibi_hesabdari);
		img_tafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_tafsiltarkibi_hesabdari);
		img2_tafsil = (ImageButton) view
				.findViewById(R.id.imgbtn_tafsil2_tarkibi_hesabdari);

		// =============init font
		utils.setyekanfont(et_fromdate);
		utils.setyekanfont(et_todate);
		// utils.setyekanfont(selecttafsil);
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

		// ========================== baraye onvane tafsil 1
		stats = new ArrayList<String>();
		stats2 = new ArrayList<String>();
		stats.add("شخص");
		stats.add("ارز");
		stats.add("مرکز هزینه");
		stats.add("پروژه");

		ArrayAdapter<String> statsAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, stats);

		statsAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spnr_onvantafsil.setAdapter(new NothingSelectedSpinnerAdapter(
				statsAdapter, R.layout.activity_stats_nothing_selected,
				getActivity()));

		spnr_onvantafsil
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						/**
						 * TextView textView = (TextView) spinertafsil
						 * .getSelectedView(); String result =
						 * textView.getText().toString();
						 */
						stats2.clear();
						switch (pos) {

						case 1:
							selecttafsil.setHint("شخص");
							selecttafsil.setText("");
							flg_selecttafsil = 1;
							type = 0;
							stats2.add("ارز");
							stats2.add("مرکز هزینه");
							stats2.add("پروژه");
							break;
						case 2:
							selecttafsil.setHint("ارز");
							selecttafsil.setText("");
							flg_selecttafsil = 2;
							type = 3;
							stats2.add("شخص");
							stats2.add("مرکز هزینه");
							stats2.add("پروژه");
							break;
						case 3:
							selecttafsil.setHint("مرکز هزینه");
							selecttafsil.setText("");
							flg_selecttafsil = 3;
							type = 2;
							stats2.add("شخص");
							stats2.add("ارز");
							stats2.add("پروژه");
							break;
						case 4:
							selecttafsil.setHint("پروژه");
							selecttafsil.setText("");
							flg_selecttafsil = 4;
							type = 1;
							stats2.add("شخص");
							stats2.add("مرکز هزینه");
							stats2.add("ارز");
							break;

						default:
							selecttafsil.setHint("عنوان");
						}
						// =================baraye onvantafsil2----natije listi
						// havi anasor bejoj chizi ke dar sath tafsil aval
						// entekhab shode
						ArrayAdapter<String> statsAdapter2 = new ArrayAdapter<String>(
								getActivity(),
								android.R.layout.simple_spinner_item, stats2);

						statsAdapter2
								.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

						spnr2_onvantafsil
								.setAdapter(new NothingSelectedSpinnerAdapter(
										statsAdapter2,
										R.layout.activity_stats_nothing_selected,
										getActivity()));

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});
		spnr2_onvantafsil
		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					View view, int pos, long id) {
				
				  TextView textView = (TextView) spnr2_onvantafsil
				  .getSelectedView(); String result =
				  textView.getText().toString();
				 
				
				switch (result) {

				case "شخص":
					selecttafsil2.setHint("شخص");
					selecttafsil2.setText("");
					flg_selecttafsil2 = 1;
					 
					break;
				case "ارز":
					selecttafsil2.setHint("ارز");
					selecttafsil2.setText("");
					flg_selecttafsil2 = 2;
					 
					break;
				case "مرکز هزینه":
					selecttafsil2.setHint("مرکز هزینه");
					selecttafsil2.setText("");
					flg_selecttafsil2 = 3;
					 
					break;
				case "پروژه":
					selecttafsil2.setHint("پروژه");
					selecttafsil2.setText("");
					flg_selecttafsil2 = 4;
					 
					 
					break;

				default:
					selecttafsil2.setHint("عنوان");
				}
				

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
		// =======================================for sathtfsil1
		sath = Integer.parseInt(HomeActivity.level.getResult().getLevel());
		sathtafsil = new ArrayList<String>();

		sath2tafsil = new ArrayList<String>();

		for (int i = 1; i <= sath; i++) {

			sathtafsil.add(String.valueOf(i));

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
						sath2tafsil.clear();
						for (int i = 1; i <= sath; i++) {
							 if(i!=spnr_sathtafsil.getSelectedItemPosition()){
							sath2tafsil.add(String.valueOf(i));
							 }
						}
						ArrayAdapter<String> statsAdaptersath2 = new ArrayAdapter<String>(
								getActivity(),
								android.R.layout.simple_spinner_item,
								sath2tafsil);

						statsAdaptersath2
								.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

						spnr2_sathtafsil
								.setAdapter(new NothingSelectedSpinnerAdapter(
										statsAdaptersath2,
										R.layout.activity_status_nothing_selected_sath,
										getActivity()));

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
					}

				});

		img_OnvanTafsil.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				spnr_onvantafsil.performClick();
			}
		});

		img_datefrom.setOnClickListener(new OnClickListener() {
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
		img_todate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				flgbackforResume = 2;

			}
		});

		img_selsathtafsil.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		img_tafsil.setOnClickListener(new OnClickListener() {

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
					flgbackforResume = 3;
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
					flgbackforResume = 3;
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
					flgbackforResume = 3;
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
		
		img2_tafsil.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (flg_selecttafsil2 == 0) {
					showDialog("توجه",
							"لطفا ابتدا عنوان تفصیل را انتخاب نمایید");

				} else if (flg_selecttafsil2 == 1) {// for shakhs
					flgbackforResume = 4;
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
				} else if (flg_selecttafsil2 == 2) {// for arz
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
				} else if (flg_selecttafsil2 == 3) {// for costcenter
					flgbackforResume = 4;
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
				} else if (flg_selecttafsil2 == 4) {// for project
					flgbackforResume = 4;
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

				else if (spnr_sathtafsil.getSelectedItemId() == -1) {
					showMessage("لطفا  فروشنده را وارد نمایید");
				} else {
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
			pId2 = ListViewAlphebeticalActivity.selidfromalphebeticlist;
			selecttafsil2
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
