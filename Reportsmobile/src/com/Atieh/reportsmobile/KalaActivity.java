package com.Atieh.reportsmobile;

import pageradapter.pageradapterkala;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
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

public class KalaActivity extends FragmentActivity {
	public Utils utils = Utils.getInstance();
	ImageButton menu;
	ImageButton underlinemojodi;
	ImageButton underlineroali;
	ImageButton underlineforokhte;
	ImageButton forosh;
	ImageButton hesabdari;
	ImageButton khazane;
	ImageButton kala;
	ImageButton domain;
	ImageButton logout;
	LinearLayout linearmenu;
	LinearLayout lmenu;
	ViewPager pagerkala;
	Button mojodi;
	Button riali;
	public static Animation animbounce;
	public static Boolean flgGotobackground = false;

	TextView title;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_kala);
		underlinemojodi = (ImageButton) findViewById(R.id.imgbtn_underline_mojodi_kala);
		underlineroali = (ImageButton) findViewById(R.id.imgbtn_underline_riali_kala);

		linearmenu = (LinearLayout) findViewById(R.id.linearmenu_kala);
		lmenu = (LinearLayout) findViewById(R.id.submenu_kala);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_kala);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_kala);
		kala = (ImageButton) findViewById(R.id.imgbtn_kala_kala);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_kala);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_kala);
		logout = (ImageButton) findViewById(R.id.imgbtn_logout_kala);
		pagerkala = (ViewPager) findViewById(R.id.pagerkala);
		mojodi = (Button) findViewById(R.id.tabbtn_mojodi_kala);
		riali = (Button) findViewById(R.id.tabbtn_riali_kala);

		title = (TextView) findViewById(R.id.title_kala);

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
		setContentView(R.layout.activity_kala);
		initview();
		animbounce = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.bounce);
		permissiontoreport();
		title.setTypeface(MainActivity.titr);
		kala.setVisibility(View.GONE);
		final pageradapterkala pageadapter = new pageradapterkala(
				getSupportFragmentManager());
		pagerkala.setAdapter(pageadapter);
		pagerkala.setCurrentItem(1);
		underlineroali.setVisibility(View.INVISIBLE);
		underlinemojodi.setVisibility(View.VISIBLE);

		flgGotobackground = false;
		utils.setyekanfont(mojodi);
		utils.setyekanfont(riali);
		
		linearmenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);

			}
		});
		pagerkala.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (pagerkala.getCurrentItem() == 1) {
					underlineroali.setVisibility(View.INVISIBLE);
					underlinemojodi.setVisibility(View.VISIBLE);

				} else if (pagerkala.getCurrentItem() == 0) {

					underlineroali.setVisibility(View.VISIBLE);
					underlinemojodi.setVisibility(View.INVISIBLE);
				}

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		mojodi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkala.setCurrentItem(1);

			}
		});

		hesabdari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KalaActivity.this,
						HesabdariActivity.class));
			}
		});
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KalaActivity.this, KalaActivity.class));
			}
		});
		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KalaActivity.this,
						SelectDomainActivity.class));
			}
		});
		khazane.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KalaActivity.this,
						KhazaneActivity.class));
			}
		});
		forosh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KalaActivity.this,
						ForoshActivity.class));
			}
		});
		riali.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkala.setCurrentItem(0);

			}
		});
	logout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				Intent intent = new Intent(getApplicationContext(),
//						MainActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				intent.putExtra("EXIT", true);
//				startActivity(intent);
				showDialogForExit();
				
			}
		});
		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				lmenu.startAnimation(animbounce);
				showmenu(v);
				// Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
	}//======End onCreate
	public void showDialogForExit() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage(getString(R.string.wouldYouLikeToExit));
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		alertDialogBuilder.setTitle(getString(R.string.warningTitle));
		alertDialogBuilder.setCancelable(false);
		alertDialogBuilder.setPositiveButton(getString(R.string.ok),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {

						Intent intent = new Intent(getApplicationContext(),
								MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						intent.putExtra("EXIT", true);
						startActivity(intent);
					}
				});
		alertDialogBuilder.setNegativeButton(getString(R.string.cancel),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}

				});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

//	public static class MyApplication extends Application {
//
//		public boolean isActivityVisible() {
//			return activityVisible;
//		}
//
//		public static void activityResumed() {
//			activityVisible = true;
//		}
//
//		public static void activityPaused() {
//			activityVisible = false;
//		}
//
//		private static boolean activityVisible;
//	}

	@Override
	protected void onResume() {
		super.onResume();
//		MyApplication.activityResumed();
		if (flgGotobackground) {
			Toast.makeText(getApplicationContext(),
					"برای ادامه کار لطفا دوباره وارد شوید", 1).show();
			Intent gotologin = new Intent(KalaActivity.this,
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
	public void onBackPressed() {
		// TODO Auto-generated method stub
//		super.onBackPressed();

//		Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		startActivity(intent);
	}

}
