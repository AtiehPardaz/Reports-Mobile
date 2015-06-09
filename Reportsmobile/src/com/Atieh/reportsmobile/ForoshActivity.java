package com.Atieh.reportsmobile;

import pageradapter.mypageadapter;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ForoshActivity extends FragmentActivity {
	public Utils utils = Utils.getInstance();
	ImageButton menu;
	ImageButton underlinecustomer;
	ImageButton underlinefaktor;
	ImageButton underlineforokhte;
	ImageButton forosh;
	ImageButton hesabdari;
	ImageButton khazane;
	ImageButton kalamenu;
	ImageButton domain;
	ImageButton logout;
	TextView title;
	LinearLayout linearmenu;
	LinearLayout lmneu;
	ViewPager pagerforosh;
	Button customer;
	Button faktor;
	Button kala;
	public static Animation animbounce;
	public static Boolean flgGotobackground = false;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_forosh);
		underlinecustomer = (ImageButton) findViewById(R.id.imgbtn_underline_customer_forosh);
		underlinefaktor = (ImageButton) findViewById(R.id.imgbtn_underline_faktor_forosh);
		underlineforokhte = (ImageButton) findViewById(R.id.imgbtn_underline_forokhte_forosh);
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu_forosh);
		lmneu = (LinearLayout) findViewById(R.id.linearmneuF);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_forosh);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_forosh);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_forosh);
		kalamenu = (ImageButton) findViewById(R.id.imgbtn_kala_forosh);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_forosh);
		logout = (ImageButton) findViewById(R.id.imgbtn_logout_forosh);
		pagerforosh = (ViewPager) findViewById(R.id.pagerforosh);
		customer = (Button) findViewById(R.id.tabbtn_customer_forosh);
		faktor = (Button) findViewById(R.id.tabbtn_faktor_forosh);
		kala = (Button) findViewById(R.id.tabbtn_kala_forosh);

		title = (TextView) findViewById(R.id.title_forosh);

		animbounce = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.bounce);

	}

	public void permissiontoreport() {

		forosh.setVisibility(View.GONE);
		khazane.setVisibility(View.GONE);
		hesabdari.setVisibility(View.GONE);
		kalamenu.setVisibility(View.GONE);
		for (int k = 1; k <= 4; k++) {
			if (HomeActivity.mypermission[k] == 1) {
				forosh.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 2) {
				khazane.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 3) {
				hesabdari.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 4) {
				kalamenu.setVisibility(View.VISIBLE);
			}
		}

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
		flgGotobackground = false;
		utils.setyekanfont(customer);
		utils.setyekanfont(faktor);
		utils.setyekanfont(kala);

		permissiontoreport();
		forosh.setVisibility(View.GONE);
		final mypageadapter pageadapter = new mypageadapter(
				getSupportFragmentManager());
		pagerforosh.setAdapter(pageadapter);
		pagerforosh.setCurrentItem(2);
		underlinefaktor.setVisibility(View.INVISIBLE);
		underlineforokhte.setVisibility(View.INVISIBLE);
		title.setTypeface(MainActivity.titr);
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
				lmneu.startAnimation(animbounce);
				showmenu(v);

				// Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);

			}
		});
	}// End onCreate

	
	@Override
	protected void onResume() {
		super.onResume();

		if (flgGotobackground) {
			Toast.makeText(getApplicationContext(),
					"برای ادامه کار لطفا دوباره وارد شوید", 1).show();
			Intent gotologin = new Intent(ForoshActivity.this,
					MainActivity.class);
			gotologin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(gotologin);
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		flgGotobackground = true;
	}
	
	 

	@Override
	protected void onPause() {
		super.onPause();

		// flgGotobackground = true;
	}

	@Override
	public void onBackPressed() {

	}
	// @Override
	// public void onBackPressed() {

	// super.onBackPressed();

	// Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
	// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	// startActivity(intent);
	// }

}
