package com.Atieh.reportsmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

public class FrgfaktorForosh extends Fragment {

	ImageButton datefrom;
	ImageButton btnshow;
	EditText et_fromdate;
	int a = 0;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_forosh_faktor, container,
				false);
		datefrom = (ImageButton) view
				.findViewById(R.id.imgbtn_fromdatefaktor_frosh);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh__faktor_forosh);
		et_fromdate = (EditText) view.findViewById(R.id.et_fromdate_faktor);

		datefrom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				a = 1;
				// do something

			}
		});

		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent report=new Intent();
				report.putExtra("gozaresh", "faktoreforosh");
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

		if (a == 1) {
			et_fromdate.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
		}

		// Toast.makeText(getActivity(), "1", 1).show();
	}

}
