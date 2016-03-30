package com.inwatch.sdk.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import com.inwatch.sdk.main.net.InwatchHttpClient;

/**
 * Created by alibus on 16-3-18.
 */
public class InfoUtil {

    private static String imei;

    private static String appid;

    private static String appkey;

    private static Context context;


    public static void init(Context mContext) {

        context = mContext;
        ApplicationInfo appInfo = null;
        ActivityInfo info = null;
        if (mContext instanceof Application) {
            try {
                appInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
                appid = appInfo.metaData.getString("app_id");
                appkey = appInfo.metaData.getString("app_key");

            } catch (PackageManager.NameNotFoundException e) {


            }

        } else if (mContext instanceof Activity) {
            try {
                info = mContext.getPackageManager().getActivityInfo(((Activity) mContext).getComponentName(), PackageManager.GET_META_DATA);
                appid = info.metaData.getString("app_id");
                appkey = info.metaData.getString("app_key");

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

        }

        getImei();

        InwatchHttpClient.init(imei,appid,appkey);

    }

    public static String getImei() {
        if (imei == null || "".equals(imei)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
        }
        return imei;

    }

    public static String getAppid() {

        return appid;
    }


    public static String getAppKey(){
        return appkey;
    }
}
