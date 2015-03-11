package com.Atieh.reportsmobile;

import pageradapter.pageradapterhesabdari;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HesabdariActivity extends FragmentActivity {

	ImageButton menu;
	ImageButton underlinetarkibi;
	ImageButton underlinefgardesh;
	 
	ImageButton forosh;
	ImageButton hesabdari;
	ImageButton khazane;
	ImageButton kala;
	ImageButton domain;
	LinearLayout linearmenu;
	ViewPager pagehesabdari;
	Button gardesh;
	Button tarkibi;
	

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_hesabdari);
		underlinetarkibi = (ImageButton) findViewById(R.id.imgbtn_underline_tarkibi_hesabdari);
		underlinefgardesh = (ImageButton) findViewById(R.id.imgbtn_underline_gardesh_hesabdari);
		 linearmenu = (LinearLayout) findViewById(R.id.linearmenu_hesabdari);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_hesabdari);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_hesabdari);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_hesabdari);
		kala = (ImageButton) findViewById(R.id.imgbtn_kala_hesabdari);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_hesabdari);
		
		pagehesabdari = (ViewPager) findViewById(R.id.pagerhesabdari);
		gardesh = (Button) findViewById(R.id.tabbtn_gardesh_hesabdari);
		tarkibi = (Button) findViewById(R.id.tabbtn_tarkibi_hesabdari);
		 

	}

	public void showmenu(View v) {
		if (linearmenu.getVisibility() == View.GONE) {
			linearmenu.setVisibility(View.VISIBLE);

		} else {
			linearmenu.setVisibility(View.GONE);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hesabdari);
		initview();
		
		
		hesabdari.setVisibility(View.GONE);
		final pageradapterhesabdari pageadapter = new pageradapterhesabdari(
				getSupportFragmentManager());
		pagehesabdari.setAdapter(pageadapter);
		pagehesabdari.setCurrentItem(1);
		underlinetarkibi.setVisibility(View.INVISIBLE);
		

		
		linearmenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showmenu(v);
				
			}
		});
		pagehesabdari.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (pagehesabdari.getCurrentItem() == 1) {
					underlinefgardesh.setVisibility(View.VISIBLE);
					underlinetarkibi.setVisibility(View.INVISIBLE);
					
				} else if (pagehesabdari.getCurrentItem() == 0) {
					underlinetarkibi.setVisibility(View.VISIBLE);
					underlinefgardesh.setVisibility(View.INVISIBLE);
					 
				} 

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		gardesh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagehesabdari.setCurrentItem(1);

			}
		});

		tarkibi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagehesabdari.setCurrentItem(0);

			}
		});
		
		forosh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						ForoshActivity.class));
			}
		});
		khazane.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						KhazaneActivity.class));
			}
		});
		
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						KalaActivity.class));
			}
		});
		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						SelectDomainActivity.class));
			}
		});
		

		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);
//				Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
	}

}