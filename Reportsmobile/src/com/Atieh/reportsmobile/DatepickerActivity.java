package com.Atieh.reportsmobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pageradapter.Utilities;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DatepickerActivity extends Activity {
	public Utils utils = Utils.getInstance();
	int i;
	Date date2;
	List<String> weekDayNames = new ArrayList<String>();
	List<String> monthNames = new ArrayList<String>();
	Utilities util;
	ImageButton sabt;
	ImageView top_image_year, down_image_year, top_image_month,
			down_image_month, top_image_day, down_image_day;
	TextView txt_date, txt_name_year, txt_name_month, txt_name_day;
	String date, dateNow = "", getYear = "", getMonth, getDay;
	public static String myYear = "", myMonth, myDay;
	AlertDialog alertDialog;
	private boolean _doubleBackToExitPressedOnce = false;
	String resume_day, resume_month, resume_year;
	public static int flg_resamedate = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datepicker);
		alertDialog = new AlertDialog.Builder(this).create();

		top_image_year = (ImageView) findViewById(R.id.top_image_year);
		down_image_year = (ImageView) findViewById(R.id.down_image_year);
		top_image_month = (ImageView) findViewById(R.id.top_image_month);

		down_image_month = (ImageView) findViewById(R.id.down_image_month);
		top_image_day = (ImageView) findViewById(R.id.top_image_day);
		down_image_day = (ImageView) findViewById(R.id.down_image_day);

		sabt = (ImageButton) findViewById(R.id.imgbtn_sabtdate);

		txt_name_year = (TextView) findViewById(R.id.txt_name_year);
		txt_name_month = (TextView) findViewById(R.id.txt_name_month);
		txt_name_day = (TextView) findViewById(R.id.txt_name_day);

		util = new Utilities();
		date2 = new Date();
		flg_resamedate = getIntent().getExtras().getInt("flg_resamedate");

		if (getIntent().getExtras().getInt("flg_resamedate") == 0) {
			txt_name_year.setText(Integer.toString(util.getYear(date2)));
			txt_name_month.setText(util.getMonthStr(date2));
			int a = util.getDay(date2);
//			Toast.makeText(getApplicationContext(),
//					myYear + myMonth + myDay + "==" + flg_resamedate + "", 1)
//					.show();
			if (a < 10) {
				txt_name_day.setText("0" + a);
			} else {
				txt_name_day.setText(Integer.toString(util.getDay(date2)));
			}
		} else {
			txt_name_month.setText(getIntent().getExtras().getString("newmonth"));
			txt_name_year.setText(getIntent().getExtras().getString("newyear"));
			txt_name_day.setText(getIntent().getExtras().getString("newday"));
		}

		this.setFinishOnTouchOutside(false);

		top_image_year.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				getYear = txt_name_year.getText().toString();
				i = Integer.parseInt(getYear);
				i = i + 1;
				txt_name_year.setText(Integer.toString(i));

			}
		});
		init_Cal();
		down_image_year.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				getYear = txt_name_year.getText().toString();
				i = Integer.parseInt(getYear);
				i = i - 1;
				txt_name_year.setText(Integer.toString(i));

			}
		});

		top_image_month.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				getMonth = txt_name_month.getText().toString();
				txt_name_month.setText(getNext_Month(getMonth));

			}
		});

		down_image_month.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				getMonth = txt_name_month.getText().toString();
				txt_name_month.setText(getPrevious_Month(getMonth));

			}
		});

		top_image_day.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				getDay = txt_name_day.getText().toString();
				getMonth = txt_name_month.getText().toString();
				if (Integer.parseInt(getMonth) < 7) {
					txt_name_day.setText(getNext_Day(getDay));
				} else {
					txt_name_day.setText(getNext_Daynimedovom(getDay));
				}
				// if(Integer.parseInt((String) txt_name_day.getText())<10){
				// if(txt_name_day.length()<2){
				// txt_name_day.setText("0"+txt_name_day.getText());
				// }

			}
		});

		down_image_day.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				getDay = txt_name_day.getText().toString();
				getMonth = txt_name_month.getText().toString();

				if (Integer.parseInt(getMonth) < 7) {
					txt_name_day.setText(getPrevious_Day(getDay));
				} else {
					txt_name_day.setText(getPrevious_Daynimedovom(getDay));
				}

				txt_name_day.setText(getPrevious_Day(getDay));

			}
		});

		sabt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				myDay = txt_name_day.getText().toString();
				myMonth = txt_name_month.getText().toString();
				myYear = txt_name_year.getText().toString();

				finish();
			}
		});

	}

	// @Override
	// protected void onResume() {
	// super.onResume();
	//
	// Toast.makeText(getApplicationContext(),
	// getIntent().getExtras().getBoolean("flg_resamedate") + "2", 1)
	// .show();
	//
	// }

	private void init_Cal() {
		weekDayNames.add("01");
		weekDayNames.add("02");
		weekDayNames.add("03");
		weekDayNames.add("04");
		weekDayNames.add("05");
		weekDayNames.add("06");
		weekDayNames.add("07");
		weekDayNames.add("08");
		weekDayNames.add("09");
		weekDayNames.add("10");
		weekDayNames.add("11");
		weekDayNames.add("12");
		weekDayNames.add("13");
		weekDayNames.add("14");
		weekDayNames.add("15");
		weekDayNames.add("16");
		weekDayNames.add("17");
		weekDayNames.add("18");
		weekDayNames.add("19");
		weekDayNames.add("20");
		weekDayNames.add("21");
		weekDayNames.add("22");
		weekDayNames.add("23");
		weekDayNames.add("24");
		weekDayNames.add("25");
		weekDayNames.add("26");
		weekDayNames.add("27");
		weekDayNames.add("28");
		weekDayNames.add("29");
		weekDayNames.add("30");
		weekDayNames.add("31");

		// array for Month
		monthNames.add("01");
		monthNames.add("02");
		monthNames.add("03");
		monthNames.add("04");
		monthNames.add("05");
		monthNames.add("06");
		monthNames.add("07");
		monthNames.add("08");
		monthNames.add("09");
		monthNames.add("10");
		monthNames.add("11");
		monthNames.add("12");
	}

	public String getNext_Month(String uid) {
		int idx = monthNames.indexOf(uid);
		if (idx >= 11) {
			idx = 0;
			return monthNames.get(idx);
		} else if (idx < 0 || idx + 1 == monthNames.size())
			// return"";
			return monthNames.get(idx + 1);

		return monthNames.get(idx + 1);
	}

	public String getPrevious_Month(String uid) {
		int idx = monthNames.indexOf(uid);

		if (idx <= 0) {
			idx = 11;
			return monthNames.get(idx);
		}
		return monthNames.get(idx - 1);
	}

	public String getNext_Day(String uid) {
		int idx = weekDayNames.indexOf(uid);
		if (idx >= 30) {
			idx = 0;
			return weekDayNames.get(idx);
		} else if (idx < 0 || idx + 1 == weekDayNames.size())
			// return "";
			return weekDayNames.get(idx + 1);
		return weekDayNames.get(idx + 1);
	}

	public String getNext_Daynimedovom(String uid) {
		int idx = weekDayNames.indexOf(uid);
		if (idx >= 29) {
			idx = 0;
			return weekDayNames.get(idx);
		} else if (idx < 0 || idx + 1 == weekDayNames.size())
			// return "";
			return weekDayNames.get(idx + 1);
		return weekDayNames.get(idx + 1);
	}

	public String getPrevious_Day(String uid) {
		int idx = weekDayNames.indexOf(uid);

		if (idx <= 0) {
			idx = 30;
			return weekDayNames.get(idx);
		}
		return weekDayNames.get(idx - 1);
	}

	public String getPrevious_Daynimedovom(String uid) {
		int idx = weekDayNames.indexOf(uid);

		if (idx <= 1) {
			idx = 29;
			return weekDayNames.get(idx);

		}

		return weekDayNames.get(idx - 1);

	}

	@Override
	public void onBackPressed() {

		if (_doubleBackToExitPressedOnce) {
			super.onBackPressed();

			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("EXIT", true);
			startActivity(intent);

			return;
		}

		showdialog("لطفا تاریخ را انتخاب نمایید");
//		new Handler().postDelayed(new Runnable() {
//			@Override
//			public void run() {
//
//				_doubleBackToExitPressedOnce = false;
//			}
//		}, 2000);
	}

	public void showdialog(String message) {
		this._doubleBackToExitPressedOnce = true;
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
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

}
