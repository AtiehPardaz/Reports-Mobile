package com.Atieh.reportsmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FrgGardeshHesabdari extends Fragment {
	ImageButton btnshow;
	Spinner spinertafsil;
	EditText selecttafsil;
	ImageButton opennspiner;

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
		spinertafsil = (Spinner) view.findViewById(R.id.spinner1);
		selecttafsil = (EditText) view
				.findViewById(R.id.et_shakhsgardesh_hesabdarii);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_gardesh_hesabdari);
		opennspiner = (ImageButton) view
				.findViewById(R.id.imgbtn_selectshakhsgardesh_hesabdari);

		ArrayAdapter<CharSequence> drinkAd = ArrayAdapter.createFromResource(
				getActivity(), R.array.tafsiltitle,
				android.R.layout.simple_spinner_item);
		drinkAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinertafsil.setAdapter(drinkAd);

		spinertafsil
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {

						Object item = parent.getItemAtPosition(pos);
						String text = spinertafsil.getSelectedItem().toString();
						// Toast.makeText(getActivity(), text, 1).show();

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
		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);

				Intent report = new Intent();
				report.putExtra("gozaresh", "gardeshhesabdari");
				report.setClass(getActivity(), ShowreportsActivity.class);
				startActivity(report);
			}
		});
		return view;

	}

}
