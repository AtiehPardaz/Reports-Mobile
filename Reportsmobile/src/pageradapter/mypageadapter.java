package pageradapter;

import java.util.ArrayList;
import java.util.List;

import com.Atieh.reportsmobile.FrgKalaForosh;
import com.Atieh.reportsmobile.FrgfaktorForosh;
import com.Atieh.reportsmobile.frg_customer_forosh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class mypageadapter extends FragmentPagerAdapter {
	private List<Fragment> frgmnts;

	public mypageadapter(FragmentManager fm) {
		super(fm);
		this.frgmnts=new ArrayList<Fragment>();
		
		
		
		frgmnts.add(new  FrgfaktorForosh());
		frgmnts.add(new  FrgKalaForosh());
		frgmnts.add(new frg_customer_forosh());
		


	}

	@Override
	public Fragment getItem(int arg0) {

		return frgmnts.get(arg0);
	}

	@Override
	public int getCount() {

		return frgmnts.size();
	}

}
