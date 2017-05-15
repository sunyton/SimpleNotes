package com.example.suny.simplenotes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.suny.simplenotes.utils.Constant;

/**
 * Created by suny on 2017/5/15.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, Constant.DATABASE_NAME, null, Constant.VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table "
                + Constant.TABLE_NAME
                + "(" + Constant._ID + " integer primary key,"
                + Constant.BODY + " varchar,"
                + Constant.WEATHER + " varchar,"
                + Constant.TIME + " varchar,"
                + Constant.LOCATION + " varchar)";

        db.execSQL(sql);
        Log.i("创建:", sql);
        db.execSQL("insert into note(body,weather,time,loc) values('hehe','sunny','sWeds Jun 11 00:00:00 CST 2017','no')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
