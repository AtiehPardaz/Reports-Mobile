package com.Atieh.reportsmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class FrgGardeshHesabdari extends Fragment {
	ImageButton btnshow;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_hesabdari_gardesh, container,
				false);
		
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_gardesh_hesabdari);
		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent report=new Intent();
				report.putExtra("gozaresh", "gardeshhesabdari");
				report.setClass(getActivity(), ShowreportsActivity.class);
				startActivity(report);
			}
		});
		return view;
		
	}

}
