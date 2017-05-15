package com.example.suny.simplenotes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.suny.simplenotes.utils.Constant;

/**
 * Created by suny on 2017/5/15.
 */

public class DatabaseManager {

    private DatabaseHelper mDatabaseHelper;

    public DatabaseManager(Context context) {
        mDatabaseHelper = new DatabaseHelper(context);

    }

    public void add(String body, String weather, String loc, String time) {


        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constant.BODY, body);
        values.put(Constant.WEATHER, weather);
        values.put(Constant.LOCATION, loc);
        values.put(Constant.TIME,time);
        db.insert(Constant.TABLE_NAME, null, values);
        db.close();

    }

    public void modify(String _id,String body,String weather,String loc) {

        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Constant.BODY, body);
        value.put(Constant.WEATHER, weather);
        value.put(Constant.LOCATION, loc);
        String where = "_id=?";
        String[] wherevalue={_id};
        db.update(Constant.TABLE_NAME, value, where, wherevalue);
        db.close();

    }






}
