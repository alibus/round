package com.alibus.db;

import android.content.Context;

/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-24 上午11:01
 * 修改人：alibus
 * 修改时间：16-3-24 上午11:01
 * 修改备注：
 */
public class DbFactory {

    DbOpenHelp dbHelper;
    private static Context mContext;
    private static DbFactory factory;

    private  DbFactory(Context context){
        dbHelper = DbOpenHelp.getInstance(context);
        this.mContext = context;
    }

    public static void init(Context context){
        if(null == factory){
            factory = new DbFactory(context);
        }

    }





}
