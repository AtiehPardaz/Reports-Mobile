package com.Atieh.reportsmobile;

import java.util.ArrayList;
import java.util.List;

import com.Atieh.reportsmobile.R.integer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import dataBase.database;

public class ListAlphebeticaladapter extends BaseAdapter {
	public Utils utils = Utils.getInstance();
	Context context;
	private Activity activity;
	String[] ids;
	String[] titles;
	String[] rownum;
	public ArrayList<ListTO> objects;
	database db;
	TextView id;

	List<List<String[]>> list1;

	private static LayoutInflater inflater = null;

	public ListAlphebeticaladapter(Activity a, String[] arrayid,
			String[] arraytitle, String[] rownumber, Context c) {

		activity = a;
		context = c;

		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.ids = arrayid;
		this.titles = arraytitle;
		this.rownum = rownumber;

	}

	public View getView(final int position, View convertView, ViewGroup parent) {

		// View vi = inflater.inflate(android.R.layout.simple_list_item_1,
		// null);
		View vi = inflater.inflate(R.layout.rowalphebetical, null);

		id = (TextView) vi.findViewById(R.id.tv_id_alohebetic); // id
		TextView title = (TextView) vi.findViewById(R.id.tv_title_alphebetic); // title
		TextView rownuber = (TextView) vi
				.findViewById(R.id.tv_rownumber_alphebetical); // rownumber
		utils.setkodakfont(title);
		id.setText(ids[position]);
		// id.setVisibility(View.VISIBLE);
		title.setText(titles[position]);
		rownuber.setText(rownum[position]);

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