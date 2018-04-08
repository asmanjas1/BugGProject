package com.resources;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.beans.ConsumerBean;
import com.beans.ShopkeeperBean;
import com.google.gson.Gson;


public class SaveSharedPreference {

    public static Gson gson = new Gson();

    //Make this to private mode
    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setConsumerObjectValue(Context ctx, String userType, ConsumerBean obj){

        Editor editor = getSharedPreferences(ctx).edit();
        String json = gson.toJson(obj);
        Log.e("Consumer ",json);
        editor.putString(BuyGConstants.CONSUMER_BEAN,json);
        editor.putString(BuyGConstants.USER_TYPE,userType);
        editor.apply();
    }

    public static void setShopkeeperObjectValue(Context ctx, String userType, ShopkeeperBean obj){
        Editor editor = getSharedPreferences(ctx).edit();
        String json = gson.toJson(obj);
        editor.putString(BuyGConstants.SHOPKEEPER_BEAN,json);
        editor.putString(BuyGConstants.USER_TYPE,userType);
        editor.apply();
    }

    public static ConsumerBean getConsumerObjectValue(Context ctx){
            ConsumerBean bean = new ConsumerBean();
            String json = getSharedPreferences(ctx).getString(BuyGConstants.CONSUMER_BEAN,"");
            bean = gson.fromJson(json,ConsumerBean.class);
            return bean;
    }

    public static ShopkeeperBean getShopkeeperObjectValue(Context ctx){
        ShopkeeperBean bean = new ShopkeeperBean(null,null,null,null,null,null);
        String json = getSharedPreferences(ctx).getString(BuyGConstants.SHOPKEEPER_BEAN,"");
        bean = gson.fromJson(json,ShopkeeperBean.class);
        return bean;
    }
    public static String getUserType(Context ctx)
    {
        return getSharedPreferences(ctx).getString(BuyGConstants.USER_TYPE, "");
    }

    public static void logOut(Context ctx){
        Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.apply();
    }
}
