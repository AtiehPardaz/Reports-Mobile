package com.Atieh.reportsmobile;

import android.widget.TextView;

public class checkdate {

	

	public int checkdate(TextView et_fromdate, TextView et_todate) {
		int flgcheck = 0, todate, fromdate;

		CharSequence from_charyear = et_fromdate.getText().subSequence(0, 4);
		CharSequence from_charmonth = et_fromdate.getText().subSequence(5, 7);
		CharSequence from_charday = et_fromdate.getText().subSequence(8, 10);
		String from_newday = from_charday.toString();
		String from_newmonth = from_charmonth.toString();
		String from_newyear = from_charyear.toString();
		// ============================
		CharSequence to_charyear = et_todate.getText().subSequence(0, 4);
		CharSequence to_charmonth = et_todate.getText().subSequence(5, 7);
		CharSequence to_charday = et_todate.getText().subSequence(8, 10);
		String to_newday = to_charday.toString();
		String to_newmonth = to_charmonth.toString();
		String to_newyear = to_charyear.toString();

		fromdate = Integer.parseInt(from_newyear + from_newmonth + from_newday);
		todate = Integer.parseInt(to_newyear + to_newmonth + to_newday);
		
		if (todate - fromdate > 0) {
			flgcheck = 0;
			// Toast.makeText(getActivity(), todate -
			// fromdate+"f"+fromdate+"t"+todate, 1).show();
			// "halate dorost hamine
		} else if (todate - fromdate < 0) {

			flgcheck = 1;
			// "tarikhe dovom kochaktarast"

		} else if (todate - fromdate == 0) {
			flgcheck = 2;
			// "tarikhe aval va dovom barabar"

		}
		return flgcheck;
		
	}
	
}
