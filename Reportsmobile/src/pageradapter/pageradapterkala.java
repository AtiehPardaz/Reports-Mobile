package pageradapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.Atieh.reportsmobile.FrgMojodikala;
import com.Atieh.reportsmobile.FrgRialiAnbar;

public class pageradapterkala extends FragmentPagerAdapter {
	private List<Fragment> frgmnts;

	public pageradapterkala(FragmentManager fm) {
		super(fm);
		this.frgmnts=new ArrayList<Fragment>();
		
		
		frgmnts.add(new  FrgRialiAnbar());
		frgmnts.add(new  FrgMojodikala());
		
		
		
		


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
