package com.Atieh.reportsmobile;

import pageradapter.pageradapterkhazane;
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
import android.widget.TextView;

public class KhazaneActivity extends FragmentActivity {

	ImageButton menu;
	ImageButton underlinedaryafti;
	ImageButton underlinevaziatdaryafti;
	ImageButton underlinepardakhti;
	ImageButton underlinevaziatpardakhti;
	ImageButton forosh;
	ImageButton khazane;
	ImageButton hesabdari;
	ImageButton kala;
	ImageButton domain;
	ImageButton logout;
	LinearLayout lmenu;
	LinearLayout linearmenu;
	ViewPager pagerkhazane;
	Button daryafti;
	Button vaziatdaryafti;
	Button pardakhti;
	Button vaziatpardakhti;
	TextView title;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_khazane);
		underlinedaryafti = (ImageButton) findViewById(R.id.imgbtn_underline_asnaddaryafti_khazane);
		underlinevaziatdaryafti = (ImageButton) findViewById(R.id.imgbtn_underline_vaziatasnaddaryafti_khazane);
		underlinepardakhti = (ImageButton) findViewById(R.id.imgbtn_underline_asnadpardakhti_khazane);
		underlinevaziatpardakhti = (ImageButton) findViewById(R.id.imgbtn_underline_vaziatasnadpardakhti_khazane);

		linearmenu = (LinearLayout) findViewById(R.id.linearmenu_khazane);
		lmenu = (LinearLayout) findViewById(R.id.submenu_khazane);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_khazane);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_khazane);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_khazane);
		kala = (ImageButton) findViewById(R.id.imgbtn_kala_khazane);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_khazane);
		logout = (ImageButton) findViewById(R.id.imgbtn_logout_khazane);

		pagerkhazane = (ViewPager) findViewById(R.id.pagerkhazane);

		daryafti = (Button) findViewById(R.id.tabbtn_asnaddaryafti_khazane);
		vaziatdaryafti = (Button) findViewById(R.id.tabbtn_vaziatasnaddaryafti_khazane);
		pardakhti = (Button) findViewById(R.id.tabbtn_asnadpardakhti_khazane);
		vaziatpardakhti = (Button) findViewById(R.id.tabbtn_vaziatasnadpardakhti_khazane);

		title = (TextView) findViewById(R.id.title_khazane);

	}

	public void permissiontoreport() {

		forosh.setVisibility(View.GONE);
		khazane.setVisibility(View.GONE);
		hesabdari.setVisibility(View.GONE);
		kala.setVisibility(View.GONE);
		for (int k = 1; k <= 4; k++) {
			if (HomeActivity.mypermission[k] == 1) {
				forosh.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 2) {
				khazane.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 3) {
				hesabdari.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 4) {
				kala.setVisibility(View.VISIBLE);
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
		setContentView(R.layout.activity_khazane);
		initview();

		permissiontoreport();
		title.setTypeface(MainActivity.titr);
		khazane.setVisibility(View.GONE);

		final pageradapterkhazane pageadapter = new pageradapterkhazane(
				getSupportFragmentManager());
		pagerkhazane.setAdapter(pageadapter);

		pagerkhazane.setCurrentItem(3);

		underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
		underlinepardakhti.setVisibility(View.INVISIBLE);
		underlinevaziatpardakhti.setVisibility(View.INVISIBLE);

		linearmenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showmenu(v);

			}
		});
		pagerkhazane.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			// underlinedaryafti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_asnaddaryafti_khazane);
			// underlinevaziatdaryafti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_vaziatasnaddaryafti_khazane);
			// underlinepardakhti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_asnadpardakhti_khazane);
			// underlinevaziatpardakhti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_vaziatasnadpardakhti_khazane);

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (pagerkhazane.getCurrentItem() == 3) {
					underlinedaryafti.setVisibility(View.VISIBLE);
					underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
					underlinepardakhti.setVisibility(View.INVISIBLE);
					underlinevaziatpardakhti.setVisibility(View.INVISIBLE);
				} else if (pagerkhazane.getCurrentItem() == 2) {
					underlinedaryafti.setVisibility(View.INVISIBLE);
					underlinevaziatdaryafti.setVisibility(View.VISIBLE);
					underlinepardakhti.setVisibility(View.INVISIBLE);
					underlinevaziatpardakhti.setVisibility(View.INVISIBLE);

				} else if (pagerkhazane.getCurrentItem() == 1) {
					underlinedaryafti.setVisibility(View.INVISIBLE);
					underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
					underlinepardakhti.setVisibility(View.VISIBLE);
					underlinevaziatpardakhti.setVisibility(View.INVISIBLE);
				} else if (pagerkhazane.getCurrentItem() == 0) {
					underlinedaryafti.setVisibility(View.INVISIBLE);
					underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
					underlinepardakhti.setVisibility(View.INVISIBLE);
					underlinevaziatpardakhti.setVisibility(View.VISIBLE);
				}

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		daryafti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(3);

			}
		});

		vaziatdaryafti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(2);

			}
		});
		pardakhti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(1);

			}
		});

		vaziatpardakhti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(0);

			}
		});
		hesabdari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						HesabdariActivity.class));
			}
		});
		forosh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						ForoshActivity.class));
			}
		});
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						KalaActivity.class));
			}
		});

		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						SelectDomainActivity.class));
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
		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				lmenu.startAnimation(ForoshActivity.animbounce);
				showmenu(v);
				// Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();

		Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}

}
