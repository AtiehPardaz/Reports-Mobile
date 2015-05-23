package com.Atieh.reportsmobile;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;


public class Utils {
    private static Utils myInstance;


    
   
    private Typeface typeface;

    public Utils() {
    }

    public static Utils getInstance() {
        if (myInstance == null) {
            myInstance = new Utils();
        }
        return myInstance;
    }

  

    public String programVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            Log.e(context.getPackageName(),
                    "Name not found on PersianCalendarUtils.programVersion");
        }
        return "";
    }

    

    public void prepareTextView(TextView textView) {
        if (typeface == null) {
            typeface = Typeface.createFromAsset(textView.getContext()
                    .getAssets(), "fonts/diplomat.ttf");
        }
        textView.setTypeface(typeface);
        textView.setLineSpacing(0f, 0.8f);
    }

   
    public void setkodakfont(TextView textView) {
        if (typeface == null) {
            typeface = Typeface.createFromAsset(textView.getContext()
                    .getAssets(), "fonts/kodak.ttf");
        }
        textView.setTypeface(typeface);
        textView.setLineSpacing(0f, 0.8f);
    }
   
}
