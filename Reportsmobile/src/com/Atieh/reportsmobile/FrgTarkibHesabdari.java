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
import android.widget.ImageButton;

public class FrgTarkibHesabdari extends Fragment {
	public Utils utils = Utils.getInstance();
	ImageButton btnshow;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
	    imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_tarkibi, container, false);
		
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_tarkibi_hesabdari);
		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
			    imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);
			
				Intent report=new Intent();
				report.putExtra("gozaresh", "tarkibihesabdari");
				report.setClass(getActivity(), ShowreportsActivity.class);
				startActivity(report);
			}
		});
		return view;
	}

}
