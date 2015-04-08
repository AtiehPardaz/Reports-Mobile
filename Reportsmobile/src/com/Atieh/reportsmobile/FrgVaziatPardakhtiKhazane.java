package com.Atieh.reportsmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class FrgVaziatPardakhtiKhazane extends Fragment {

	ImageButton datefromcustomer;
	EditText fromdate;
	ImageButton btnshow;
int a=0;
	
@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_khazane_vaziatpardakhti, container,
				false);
		datefromcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_fromdatecustomer_frosh_);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh_vaziatasnadpardakhti_khazane);
//
//		fromdate=(EditText) view.findViewById(R.id.et_fromdate_forosh);
//		datefromcustomer.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				startActivity(new Intent(getActivity(),
//						DatepickerActivity.class));
//				a=1;
//				// do something
//
//			}
//		});

		
		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
			    imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);
			
				Intent report=new Intent();
				report.putExtra("gozaresh", "vaziatpardakhti");
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
		
//		
//		if(a==1){
//			fromdate.setText(DatepickerActivity.myDay+"/"+DatepickerActivity.myMonth+"/"+DatepickerActivity.myYear);
//		}
//		
		
//		Toast.makeText(getActivity(), "1", 1).show();
	}

}
