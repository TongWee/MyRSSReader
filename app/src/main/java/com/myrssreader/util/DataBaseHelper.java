package com.myrssreader.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.myrssreader.bean.FeedItem;
import com.myrssreader.bean.FeedRespose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tong on 2015/11/23.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_SUBSCRIBE =
            "create table Subscribe(" +
                    "id Integer primary key autoincrement," +
                    "title text," +
                    "link text," +
                    "description text)";
    public static final String CREATE_STARED =
            "create table Stared(" +
                    "id Integer primary key autoincrement," +
                    "title text," +
                    "fromChannel text," +
                    "link text," +
                    "description text)";
    private Context mContext;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_SUBSCRIBE);
            sqLiteDatabase.execSQL(CREATE_STARED);
//            Toast.makeText(RSSReaderApp.getContext(),"Create table.",Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Log.e("ERROR", ex.getStackTrace().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Subscribe");
        sqLiteDatabase.execSQL("drop table if exists Stared");
        onCreate(sqLiteDatabase);
    }

    public boolean isEmpty(String tableString) {
        String DATA_COUNT = "select * from " + tableString;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(DATA_COUNT, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            return false;

        } else {
            cursor.close();
            return true;
        }
    }

    public boolean hasItem(String table, String title) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(table, null, "title = ?", new String[]{title}, null, null, null);
        if (cursor.getCount() == 0) {
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }
    }

    public void insertSubscribe(FeedRespose feedRespose) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", feedRespose.getTitle());
        contentValues.put("link", feedRespose.getLink());
        contentValues.put("description", feedRespose.getDescription());
        sqLiteDatabase.insert("Subscribe", null, contentValues);
    }

    public void insertStared(FeedItem feedItem) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", feedItem.getTitle());
        contentValues.put("link", feedItem.getLink());
        contentValues.put("description", feedItem.getDescription());
        sqLiteDatabase.insert("Stared", null, contentValues);
    }

    public void delete(String table, String title) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(table, "title = ?", new String[]{title});
    }

    public List<FeedRespose> getAllSubscribe() {
        String DATA_COUNT = "select * from Subscribe";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<FeedRespose> feedResposeList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(DATA_COUNT, null);
        if (cursor.moveToFirst()) {
            do {
                FeedRespose feedRespose = new FeedRespose();
                feedRespose.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                feedRespose.setLink(cursor.getString(cursor.getColumnIndex("link")));
                feedRespose.setDescription(cursor.getString(cursor.getColumnIndex("description")));
                feedResposeList.add(feedRespose);
            } while (cursor.moveToNext());
        }
        return feedResposeList;
    }

    public List<FeedItem> getAllStared() {
        List<FeedItem> feedItemList = new ArrayList<>();
        String DATA_COUNT = "select * from Stared";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(DATA_COUNT, null);
        if (cursor.moveToFirst()) {
            do {
                FeedItem feedItem = new FeedItem();
                feedItem.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                feedItem.setLink(cursor.getString(cursor.getColumnIndex("link")));
                feedItem.setDescription(cursor.getString(cursor.getColumnIndex("description")));
                feedItemList.add(feedItem);
            } while (cursor.moveToNext());
        }
        return feedItemList;
    }
}
