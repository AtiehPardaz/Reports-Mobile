package com.Atieh.reportsmobile;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import webservices.NetworkUtils;
import webservices.ServiceGenerator;
import GetAllCostCentersPack.GetAllCostCenters;
import GetAllCostCentersPack.GetAllCostCentersInterface;
import GetAllCurrenciesPack.GetAllCurrencies;
import GetAllCurrenciesPack.GetAllCurrenciesInterface;
import GetAllCustomersPack.GetAllCustomer;
import GetAllCustomersPack.GetAllCustomerInterface;
import GetAllMarketersPack.GetAllMarketers;
import GetAllMarketersPack.GetAllMarketersInterface;
import GetAllPersonsPack.GetAllPerson;
import GetAllPersonsPack.GetAllPersonsInterface;
import GetAllProductPack.GetAllProduct;
import GetAllProductPack.GetAllProductInterface;
import GetAllProjectsPack.GetAllProjects;
import GetAllProjectsPack.GetAllProjectsInterface;
import GetAllSellersPack.GetAllSeller;
import GetAllSellersPack.GetAllSellerInterface;
import GetAllServicesPack.GetAllService;
import GetAllServicesPack.GetAllServiceInterface;
import GetAllWarehousesPack.GetAllWarehouses;
import GetAllWarehousesPack.GetAllWarehousesInterface;
import GetDetailLevelNumberPack.GetDetailLevelNumber;
import GetDetailLevelNumberPack.GetDetailLevelNumberInterface;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends Activity {

	GetAllSeller seler;
	GetAllCustomer moshtari;
	GetAllPerson shakhs;
	GetAllMarketers bazaryab;
	GetAllProduct product;
	GetAllService services;
	GetAllWarehouses warehouse;
	GetAllCurrencies currencies;
	GetAllProjects projects;
	GetAllCostCenters costcenters;
	public static GetDetailLevelNumber level;
	private boolean _doubleBackToExitPressedOnce = false;

	String levels = "";
	ImageButton menu;
	ImageButton forosh;
	ImageButton hesabdari;
	ImageButton khazane;
	ImageButton kala;
	ImageButton domain;
	ImageButton logout;
	LinearLayout linearmenu;
	LinearLayout linear_loadinghome;
	boolean flgclickmenu;
	int contofpermission = 0;
	public static int[] mypermission = new int[5];
	NetworkUtils netutil = new NetworkUtils(this);

	public static ArrayList<String> sellertitleArray;
	public static ArrayList<String> sellerpersoncodeArray;
	public static ArrayList<String> selleridArray;

	public static ArrayList<String> moshtariidArray;
	public static ArrayList<String> mostarititleArray;
	public static ArrayList<String> mostaripersoncodeArray;

	public static ArrayList<String> shakhsidArray;
	public static ArrayList<String> shakhstitleArray;
	public static ArrayList<String> shakhspersoncodeArray;

	public static ArrayList<String> bazaryabidArray;
	public static ArrayList<String> bazaryabtitleArray;
	public static ArrayList<String> bazaryabpersoncodeArray;

	public static ArrayList<String> productidArray;
	public static ArrayList<String> producttitleArray;
	public static ArrayList<String> productcodeArray;

	public static ArrayList<String> servicesidArray;
	public static ArrayList<String> servicestitleArray;
	public static ArrayList<String> servicescodeArray;

	public static ArrayList<String> warehouseidArray;
	public static ArrayList<String> warehousetitleArray;

	public static ArrayList<String> currenciesidArray;
	public static ArrayList<String> currenciestitleArray;

	public static ArrayList<String> projectsidArray;
	public static ArrayList<String> projectstitleArray;

	public static ArrayList<String> costcentersidArray;
	public static ArrayList<String> costcenterstitleArray;

	public static String token;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_home);
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_home);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_home);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_home);
		kala = (ImageButton) findViewById(R.id.imgbtn_kala_home);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_home);
		logout = (ImageButton) findViewById(R.id.imgbtn_logout_home);
		linear_loadinghome = (LinearLayout) findViewById(R.id.linear_loadinghome);
	}

	// =================================oncreate==============
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initview();
		token = MainActivity.authenticate.getResult().getToken();

		// if(netutil.isNetworkAvailable())
		// {
		getSellers();
		// }
		// else
		// {
		// String message =
		// "لطفا از روشن بودن دیتای موبایل و یا وایرلس خود و اتصال به اینترنت اطمینان حاصل نمایید.";
		// AlertDialog.Builder builder =
		// new
		// AlertDialog.Builder(HomeActivity.this).setTitle("title").setMessage(message);
		// builder.setPositiveButton(R.string.ok, null);
		// builder.show();
		//
		// }

		forosh.setImageResource(R.drawable.backmenutransparent);
		khazane.setImageResource(R.drawable.backmenutransparent);
		hesabdari.setImageResource(R.drawable.backmenutransparent);
		kala.setImageResource(R.drawable.backmenutransparent);
		forosh.setEnabled(false);
		khazane.setEnabled(false);
		hesabdari.setEnabled(false);
		kala.setEnabled(false);
		// Toast.makeText(getApplicationContext(),
		// SelectDomainActivity.StartDateArray.get(0)+"", 1).show();
		// Toast.makeText(getApplicationContext(),
		// SelectDomainActivity.StartDate+" and "+SelectDomainActivity.EndDate,
		// 1).show();

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

		khazane.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(HomeActivity.this,
						KhazaneActivity.class));
			}
		});
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(HomeActivity.this, KalaActivity.class));
			}
		});
		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(HomeActivity.this,
						SelectDomainActivity.class));
			}
		});

		logout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showDialogForExit();
			}
		});
	}// ======End onCreate

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

	public void getSellers() {
		// 1==================== GetAllSeller
		linear_loadinghome.setVisibility(View.VISIBLE);
		seler = new GetAllSeller();
		GetAllSellerInterface sellers = ServiceGenerator.createService(
				GetAllSellerInterface.class, MainActivity.baseURL);
		sellers.getAllSellers(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllSeller>() {

					@Override
					public void success(GetAllSeller theSeller,
							Response response) {

						seler = theSeller;
						selleridArray = new ArrayList<>();
						sellertitleArray = new ArrayList<>();
						sellerpersoncodeArray = new ArrayList<>();
						for (int i = 0; i < seler.getResult().size(); i++) {
							sellertitleArray.add(seler.getResult().get(i)
									.getTitle());
							selleridArray.add((seler.getResult().get(i).getId()));
							sellerpersoncodeArray.add((seler.getResult().get(i)
									.getPersonCode()));
						}

						getCustomers();
					}

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);

					}
				});
	}

	public void getCustomers() {
		// 2===========================GetAllCustomer
		moshtari = new GetAllCustomer();
		GetAllCustomerInterface customer = ServiceGenerator.createService(
				GetAllCustomerInterface.class, MainActivity.baseURL);

		customer.getAllCustomer(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllCustomer>() {

					@Override
					public void success(GetAllCustomer theCustomer,
							Response response) {

						moshtari = theCustomer;
						moshtariidArray = new ArrayList<>();
						mostarititleArray = new ArrayList<>();
						mostaripersoncodeArray = new ArrayList<>();
						for (int i = 0; i < moshtari.getResult().size(); i++) {
							mostarititleArray.add(moshtari.getResult().get(i)
									.getTitle());
							moshtariidArray.add((moshtari.getResult().get(i)
									.getId()));
							mostaripersoncodeArray.add((moshtari.getResult()
									.get(i).getPersonCode()));
						}

						getPersons();
					}

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

				});
	}

	public void getPersons() {
		// 3========================GetAllPersons
		shakhs = new GetAllPerson();
		GetAllPersonsInterface person = ServiceGenerator.createService(
				GetAllPersonsInterface.class, MainActivity.baseURL);

		person.getAllPersons(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllPerson>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllPerson thePerson,
							Response response) {

						shakhs = thePerson;
						shakhsidArray = new ArrayList<>();
						shakhstitleArray = new ArrayList<>();
						shakhspersoncodeArray = new ArrayList<>();

						for (int i = 0; i < shakhs.getResult().size(); i++) {
							shakhstitleArray.add(shakhs.getResult().get(i)
									.getTitle());
							shakhsidArray.add((shakhs.getResult().get(i)
									.getId()));
							shakhspersoncodeArray.add((shakhs.getResult()
									.get(i).getPersonCode()));
						}

						getMarketers();
					}

				});
	}

	public void getMarketers() {
		// 4========================GetAllMarketers
		bazaryab = new GetAllMarketers();
		GetAllMarketersInterface marketer = ServiceGenerator.createService(
				GetAllMarketersInterface.class, MainActivity.baseURL);

		marketer.getAllMarketers(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllMarketers>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllMarketers theMarketer,
							Response arg1) {
						bazaryab = theMarketer;
						bazaryabidArray = new ArrayList<>();
						bazaryabtitleArray = new ArrayList<>();
						bazaryabpersoncodeArray = new ArrayList<>();

						for (int i = 0; i < bazaryab.getResult().size(); i++) {
							bazaryabtitleArray.add(bazaryab.getResult().get(i)
									.getTitle());
							bazaryabidArray.add((bazaryab.getResult().get(i)
									.getId()));
							bazaryabpersoncodeArray.add((bazaryab.getResult()
									.get(i).getPersonCode()));
						}

						getProducts();

					}//

				});
	}

	public void getProducts() {
		// 5==========================GetAllProduct

		product = new GetAllProduct();
		GetAllProductInterface mahsolat = ServiceGenerator.createService(
				GetAllProductInterface.class, MainActivity.baseURL);

		mahsolat.getAllProduct(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllProduct>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllProduct theProduct, Response arg1) {
						product = theProduct;
						productidArray = new ArrayList<>();
						producttitleArray = new ArrayList<>();
						productcodeArray = new ArrayList<>();

						for (int i = 0; i < product.getResult().size(); i++) {
							producttitleArray.add(product.getResult().get(i)
									.getTitle());
							productidArray.add((product.getResult().get(i)
									.getId()));
							productcodeArray.add((product.getResult().get(i)
									.getCode()));
						}

						getServices();
					}

				});
	}

	public void getServices() {
		// 6==========================GetAllService
		services = new GetAllService();
		GetAllServiceInterface khadamat = ServiceGenerator.createService(
				GetAllServiceInterface.class, MainActivity.baseURL);

		khadamat.getAllService(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllService>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllService theService, Response arg1) {
						services = theService;
						servicesidArray = new ArrayList<>();
						servicestitleArray = new ArrayList<>();
						servicescodeArray = new ArrayList<>();

						for (int i = 0; i < services.getResult().size(); i++) {
							servicestitleArray.add(services.getResult().get(i)
									.getTitle());
							servicesidArray.add((services.getResult().get(i)
									.getId()));
							servicescodeArray.add((services.getResult().get(i)
									.getCode()));
						}

						getWarehouses();

					}
				});
	}

	public void getWarehouses() {
		// 7==========================GetAllWarehouses
		warehouse = new GetAllWarehouses();
		GetAllWarehousesInterface anbarha = ServiceGenerator.createService(
				GetAllWarehousesInterface.class, MainActivity.baseURL);

		anbarha.getAllWarehouses(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllWarehouses>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllWarehouses theWarehouse,
							Response arg1) {
						warehouse = theWarehouse;
						warehouseidArray = new ArrayList<>();
						warehousetitleArray = new ArrayList<>();

						for (int i = 0; i < warehouse.getResult().size(); i++) {
							warehousetitleArray.add(warehouse.getResult()
									.get(i).getTitle());
							warehouseidArray.add((warehouse.getResult().get(i)
									.getId()));

						}

						getCurrencies();
					}

				});
	}

	public void getCurrencies() {
		// 8=========================GetAllCurrencies
		currencies = new GetAllCurrencies();
		GetAllCurrenciesInterface pol = ServiceGenerator.createService(
				GetAllCurrenciesInterface.class, MainActivity.baseURL);

		pol.getAllCurrencies(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllCurrencies>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllCurrencies theCurrency,
							Response arg1) {
						currencies = theCurrency;
						currenciesidArray = new ArrayList<>();
						currenciestitleArray = new ArrayList<>();

						for (int i = 0; i < currencies.getResult().size(); i++) {
							currenciestitleArray.add(currencies.getResult()
									.get(i).getTitle());
							currenciesidArray.add((currencies.getResult()
									.get(i).getId()));
						}

						getProjects();
					}

				});
	}

	public void getProjects() {
		// 9==========================GetAllProjects
		projects = new GetAllProjects();
		GetAllProjectsInterface prj = ServiceGenerator.createService(
				GetAllProjectsInterface.class, MainActivity.baseURL);

		prj.getAllProjects(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllProjects>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllProjects theProject, Response arg1) {
						projects = theProject;
						projectsidArray = new ArrayList<>();
						projectstitleArray = new ArrayList<>();

						for (int i = 0; i < projects.getResult().size(); i++) {
							projectstitleArray.add(projects.getResult().get(i)
									.getTitle());
							projectsidArray.add((projects.getResult().get(i)
									.getId()));
						}

						getCostCenters();
					}

				});
	}

	public void getCostCenters() {
		// 10 ==========================GetAllCostCenters
		costcenters = new GetAllCostCenters();
		GetAllCostCentersInterface hazine = ServiceGenerator.createService(
				GetAllCostCentersInterface.class, MainActivity.baseURL);

		hazine.getAllCostCenters(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetAllCostCenters>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetAllCostCenters theCostCenter,
							Response arg1) {
						costcenters = theCostCenter;
						costcentersidArray = new ArrayList<>();
						costcenterstitleArray = new ArrayList<>();

						for (int i = 0; i < costcenters.getResult().size(); i++) {
							costcenterstitleArray.add(costcenters.getResult()
									.get(i).getTitle());
							costcentersidArray.add((costcenters.getResult()
									.get(i).getId()));
						}

						getLevelNumbers();
					}
				});
	}

	public void getLevelNumbers() {
		// 11 ==========================GetDetailLevelNumber
		level = new GetDetailLevelNumber();
		GetDetailLevelNumberInterface sath1 = ServiceGenerator.createService(
				GetDetailLevelNumberInterface.class, MainActivity.baseURL);

		sath1.getDetailLevelNumber(SelectDomainActivity.returnedDomainID,
				SelectDomainActivity.returnedYearID, token,
				new Callback<GetDetailLevelNumber>() {

					@Override
					public void failure(RetrofitError retrofitError) {
						String title = getString(R.string.errorTitle);
						String body = netutil
								.handleRetrofitError(retrofitError);
						showDialog(title, body);
					}

					@Override
					public void success(GetDetailLevelNumber theLevelNumber,
							Response arg1) {
						level = theLevelNumber;
						levels = level.getResult().getLevel();
						linear_loadinghome.setVisibility(View.INVISIBLE);
						// Toast.makeText(getApplicationContext(), levels, 1)
						// .show();
					}
				});
	}

	@Override
	public void onBackPressed() {

		if (_doubleBackToExitPressedOnce) {
			return;
		}
		this._doubleBackToExitPressedOnce = true;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// /================ for permission
		mypermission = new int[5];
		for (int i = 0; i < MainActivity.authenticate.getResult().getDomains()
				.size(); i++) {

			for (int j = 0; j < MainActivity.authenticate.getResult()
					.getDomains().get(i).getPermissions().size(); j++) {
				if (MainActivity.authenticate.getResult().getDomains().get(i)
						.getId()
						.equals(SelectDomainActivity.finalreturneddomainid)) {

					contofpermission++;
					for (int k = 1; k <= 4; k++) {
						if (k == MainActivity.authenticate.getResult()
								.getDomains().get(i).getPermissions().get(j)
								.getKey()) {
							mypermission[k] = k;
						}
					}
				}
			}
		}

		if (contofpermission == 1) {
			for (int k = 1; k <= 4; k++) {

				if (mypermission[k] == 1) {
					startActivity(new Intent(HomeActivity.this,
							ForoshActivity.class));
				} else if (mypermission[k] == 2) {
					startActivity(new Intent(HomeActivity.this,
							KhazaneActivity.class));
				} else if (mypermission[k] == 3) {
					startActivity(new Intent(HomeActivity.this,
							HesabdariActivity.class));
				} else if (mypermission[k] == 4) {
					startActivity(new Intent(HomeActivity.this,
							KalaActivity.class));
				}
			}
		} else if (contofpermission > 1) {
			for (int k = 1; k <= 4; k++) {
				if (mypermission[k] == 1) {
					forosh.setImageResource(R.drawable.btn_click);
					forosh.setEnabled(true);
				} else if (mypermission[k] == 2) {
					khazane.setImageResource(R.drawable.btn_click);
					khazane.setEnabled(true);
				} else if (mypermission[k] == 3) {
					hesabdari.setImageResource(R.drawable.btn_click);
					hesabdari.setEnabled(true);
				} else if (mypermission[k] == 4) {
					kala.setImageResource(R.drawable.btn_click);
					kala.setEnabled(true);
				}
			}
		} else if (contofpermission == 0) {
			Toast.makeText(getApplicationContext(), "بدون دسترسی",
					Toast.LENGTH_LONG).show();
		}
	}// End onResume

	public void showDialog(String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this)
				.setTitle(title).setMessage(message);
		builder.setPositiveButton(R.string.ok, null);
		builder.show();
	}

}
