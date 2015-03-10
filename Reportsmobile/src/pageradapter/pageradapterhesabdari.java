package pageradapter;

import java.util.ArrayList;
import java.util.List;

import com.Atieh.reportsmobile.FrgGardeshHesabdari;
import com.Atieh.reportsmobile.FrgTarkibHesabdari;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class pageradapterhesabdari extends FragmentPagerAdapter {
	private List<Fragment> frgmnts;

	public pageradapterhesabdari(FragmentManager fm) {
		super(fm);
		this.frgmnts=new ArrayList<Fragment>();
		
		
		
		frgmnts.add(new  FrgTarkibHesabdari());
		frgmnts.add(new  FrgGardeshHesabdari());
		
		


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
