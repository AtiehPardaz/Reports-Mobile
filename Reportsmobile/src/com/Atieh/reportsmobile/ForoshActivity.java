package com.Atieh.reportsmobile;

import pageradapter.mypageadapter;
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

public class ForoshActivity extends FragmentActivity {

	ImageButton menu;
	ImageButton underlinecustomer;
	ImageButton underlinefaktor;
	ImageButton underlineforokhte;
	ImageButton forosh;
	ImageButton hesabdari;
	ImageButton khazane;
	ImageButton kalamenu;
	ImageButton domain;

	LinearLayout linearmenu;
	ViewPager pagerforosh;
	Button customer;
	Button faktor;
	Button kala;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_forosh);
		underlinecustomer = (ImageButton) findViewById(R.id.imgbtn_underline_customer_forosh);
		underlinefaktor = (ImageButton) findViewById(R.id.imgbtn_underline_faktor_forosh);
		underlineforokhte = (ImageButton) findViewById(R.id.imgbtn_underline_forokhte_forosh);
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu_forosh);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_forosh);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_forosh);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_forosh);
		kalamenu = (ImageButton) findViewById(R.id.imgbtn_kala_forosh);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_forosh);

		pagerforosh = (ViewPager) findViewById(R.id.pagerforosh);
		customer = (Button) findViewById(R.id.tabbtn_customer_forosh);
		faktor = (Button) findViewById(R.id.tabbtn_faktor_forosh);
		kala = (Button) findViewById(R.id.tabbtn_kala_forosh);

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
		setContentView(R.layout.activity_forosh);
		initview();

		forosh.setVisibility(View.GONE);
		final mypageadapter pageadapter = new mypageadapter(
				getSupportFragmentManager());
		pagerforosh.setAdapter(pageadapter);
		pagerforosh.setCurrentItem(2);
		underlinefaktor.setVisibility(View.INVISIBLE);
		underlineforokhte.setVisibility(View.INVISIBLE);

		linearmenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);

			}
		});
		pagerforosh.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (pagerforosh.getCurrentItem() == 2) {
					underlinecustomer.setVisibility(View.VISIBLE);
					underlinefaktor.setVisibility(View.INVISIBLE);
					underlineforokhte.setVisibility(View.INVISIBLE);
				} else if (pagerforosh.getCurrentItem() == 1) {
					underlinefaktor.setVisibility(View.VISIBLE);
					underlinecustomer.setVisibility(View.INVISIBLE);
					underlineforokhte.setVisibility(View.INVISIBLE);
				} else if (pagerforosh.getCurrentItem() == 0) {
					underlineforokhte.setVisibility(View.VISIBLE);
					underlinefaktor.setVisibility(View.INVISIBLE);
					underlinecustomer.setVisibility(View.INVISIBLE);
				}

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		customer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerforosh.setCurrentItem(2);

			}
		});

		faktor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerforosh.setCurrentItem(1);

			}
		});

		hesabdari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(ForoshActivity.this,
						HesabdariActivity.class));
			}
		});
		khazane.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(ForoshActivity.this,
						KhazaneActivity.class));
			}
		});
		kalamenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(ForoshActivity.this,
						KalaActivity.class));
			}
		});
		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(ForoshActivity.this,
						SelectDomainActivity.class));
			}
		});
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerforosh.setCurrentItem(0);

			}
		});

		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);
				// Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
	}

}