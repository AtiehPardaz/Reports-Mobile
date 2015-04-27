package customlistadapter;

import java.util.List;

import com.Atieh.reportsmobile.R;
import com.Atieh.reportsmobile.R.id;
import com.Atieh.reportsmobile.R.layout;

import dataBase.database;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class ListAlphebeticaladapter extends BaseAdapter {
	Context context;
	private Activity activity;
	String[] ids;
	String[] titles;
	
	database db;
	TextView id;

	List<List<String[]>> list1;

	private static LayoutInflater inflater = null;

	public ListAlphebeticaladapter(Activity a, String[] arrayid, String[] arraytitle,
			 Context c) {

		activity = a;
		context = c;

		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.ids = arrayid;
		this.titles = arraytitle;
		
	}

	public View getView(final int position, View convertView, ViewGroup parent) {

		View vi = inflater.inflate(R.layout.rowalphebetical, null);
		id = (TextView) vi.findViewById(R.id.tv_id_alohebetic); // id
		TextView title = (TextView) vi
				.findViewById(R.id.tv_title_alphebetic); // title
		

		id.setText(ids[position]);
//		id.setVisibility(View.VISIBLE);
		title.setText(titles[position]);
		


		return vi;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return ids.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
		// list1.get(position)[2];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	

}