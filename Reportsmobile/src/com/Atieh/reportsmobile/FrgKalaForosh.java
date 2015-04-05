package com.Atieh.reportsmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class FrgKalaForosh extends Fragment {

	ImageButton btnshow;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_forosh_forokhte, container,
				false);

		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh__forokhte_forosh);
		
		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent report=new Intent();
				report.putExtra("gozaresh", "kalaforokhte");
				report.setClass(getActivity(), ShowreportsActivity.class);
				startActivity(report);
			}
		});

		return view;
	}

}
