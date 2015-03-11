package pageradapter;

import java.util.ArrayList;
import java.util.List;

import com.Atieh.reportsmobile.FrgDaryaftiKhazane;
import com.Atieh.reportsmobile.FrgKalaForosh;
import com.Atieh.reportsmobile.FrgVaziatDaryaftiKhazane;
import com.Atieh.reportsmobile.FrgVaziatPardakhtiKhazane;
import com.Atieh.reportsmobile.FrgfaktorForosh;
import com.Atieh.reportsmobile.FrgpardakhtiKhazane;
import com.Atieh.reportsmobile.frg_customer_forosh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class pageradapterkhazane extends FragmentPagerAdapter {
	private List<Fragment> frgmnts;

	public pageradapterkhazane(FragmentManager fm) {
		super(fm);
		this.frgmnts=new ArrayList<Fragment>();
		
		
		
		frgmnts.add(new  FrgVaziatPardakhtiKhazane());
		frgmnts.add(new  FrgpardakhtiKhazane());
		frgmnts.add(new FrgVaziatDaryaftiKhazane());
		frgmnts.add(new  FrgDaryaftiKhazane());
		
		
		


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