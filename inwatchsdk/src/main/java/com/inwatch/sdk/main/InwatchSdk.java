package com.inwatch.sdk.main;

import android.content.Context;
import android.util.LruCache;

import com.inwatch.sdk.util.InfoUtil;

public class InwatchSdk {

    private static Context mContext;

    public static void init(Context context) {
        InfoUtil.init(context);
        mContext = context;
    }
}