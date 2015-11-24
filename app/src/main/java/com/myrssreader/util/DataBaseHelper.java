package com.myrssreader.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.myrssreader.RSSReaderApp;

/**
 * Created by Tong on 2015/11/23.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private Context mContext;

    public static final String CREATE_SUBSCRIBE =
            "create table Subscribe("+
                    "id Integar primary key autoincrement,"+
                    "title text,"+
                    "link text,"+
                    "description text)";

    public static final String CREATE_STARED =
            "create table Stared("+
            "id Integar primary key autoincrement,"+
            "title text,"+
            "fromChannel text,"+
            "link text,"+
            "description text)";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_SUBSCRIBE);
            sqLiteDatabase.execSQL(CREATE_STARED);
            Toast.makeText(RSSReaderApp.getContext(),"Create table.",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("ERROR",ex.getStackTrace().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Subscribe");
        sqLiteDatabase.execSQL("drop table if exists Stared");
        onCreate(sqLiteDatabase);
    }
}
