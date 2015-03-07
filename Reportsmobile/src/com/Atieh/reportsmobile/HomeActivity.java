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
	LinearLayout linearmenu;
	boolean flgclickmenu;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_home);
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu);

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

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initview();
		linearmenu.setVisibility(View.GONE);

		
		
		
		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);
			
				// startActivity(new Intent(SelectDomainActivity.this,
				// HomeActivity.class));

			}
		});

	}

}
