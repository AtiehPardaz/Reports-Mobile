package com.Atieh.reportsmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ForoshActivity extends Activity {
	
	ImageButton menu;
	ImageButton forosh;
	LinearLayout linearmenu;
	
	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_foroshactivity);
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu_forosh);
		forosh=(ImageButton) findViewById(R.id.imgbtn_forosh_home);

	}
	
	public void showmenu(View v) {
		if (linearmenu.getVisibility()==View.GONE) {
			linearmenu.setVisibility(View.VISIBLE);
			
		}else{
			linearmenu.setVisibility(View.GONE);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forosh);
		initview();
		
		menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showmenu(v);
				
			}
		});
	}

}
