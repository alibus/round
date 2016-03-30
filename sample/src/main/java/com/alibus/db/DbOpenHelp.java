package com.alibus.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-24 上午10:25
 * 修改人：alibus
 * 修改时间：16-3-24 上午10:25
 * 修改备注：
 */
public class DbOpenHelp extends SQLiteOpenHelper {

    static DbOpenHelp dbHelper;
    private static String DB_NAME = "alibus";
    private static int DB_VERSION = 1;

    static Context mContext;



    private DbOpenHelp(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    public synchronized static DbOpenHelp getInstance(Context context) {
        mContext = context;
        if (dbHelper == null) {
            dbHelper = new DbOpenHelp(context);
        }
        return dbHelper;

    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("");


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
