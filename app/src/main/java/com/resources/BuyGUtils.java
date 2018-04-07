package com.resources;

import android.app.ProgressDialog;
import android.content.Context;

public class BuyGUtils {

    static ProgressDialog progressDoalog = null;

    public static ProgressDialog getProgressDialog(Context context){

        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading....");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        return progressDoalog;
    }


}
