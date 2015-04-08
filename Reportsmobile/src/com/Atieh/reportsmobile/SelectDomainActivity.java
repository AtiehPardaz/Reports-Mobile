package com.Atieh.reportsmobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

public class SelectDomainActivity extends Activity {

	
	ImageButton sabt;

	public void initview() {
		sabt = (ImageButton) findViewById(R.id.imgbtn_sabt);

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectdomain);
		initview();
		
		
		sabt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
			    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			
				startActivity(new Intent(SelectDomainActivity.this,
						HomeActivity.class));

			}
		});
		
	}

}
