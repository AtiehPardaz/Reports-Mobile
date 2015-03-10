package com.Atieh.reportsmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class HomeActivity extends Activity {

	ImageButton menu;
	ImageButton forosh;
	ImageButton hesabdari;
	LinearLayout linearmenu;
	boolean flgclickmenu;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_home);
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_home);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_home);

	}

	public void showmenu() {
		if (linearmenu.getVisibility() == View.GONE) {
			linearmenu.setVisibility(View.VISIBLE);

		} else {
			linearmenu.setVisibility(View.GONE);
		}
	}

	// =================================oncreate==============
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initview();
		linearmenu.setVisibility(View.VISIBLE);

		forosh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HomeActivity.this,
						ForoshActivity.class));
			}
		});
		
		hesabdari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HomeActivity.this,
						HesabdariActivity.class));
				
			}
		});
		
		linearmenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				showmenu();
			}
		});
		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu();

				// startActivity(new Intent(SelectDomainActivity.this,
				// HomeActivity.class));

			}
		});

	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		showmenu();
	}

}
