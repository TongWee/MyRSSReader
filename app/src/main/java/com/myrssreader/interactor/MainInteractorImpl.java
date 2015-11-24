package com.myrssreader.interactor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.myrssreader.RSSReaderApp;
import com.myrssreader.util.DataBaseHelper;

/**
 * Created by Tong on 2015/11/19.
 */
public class MainInteractorImpl implements MainInteractor {
    DataBaseHelper dataBaseHelper;

    public MainInteractorImpl(){
        this.dataBaseHelper = RSSReaderApp.getDataBaseHelper();
    }
    public void createDatabase(Context context) {
//        dataBaseHelper = RSSReaderApp.getDataBaseHelper();
//        Log.d("SUCCESS", "create database success.");
        /**
         * create database in RSSReaderApp.class
         */
    }
    @Override
    public void initData() {
        if(!dataBaseHelper.isEmpty("Subscribe"))
            return;
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", "廖雪峰的博客");
            contentValues.put("link", "http://www.liaoxuefeng.com/feed");
            contentValues.put("description", "研究互联网产品和技术，提供原创中文精品教程");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "36氪");
            contentValues.put("link", "http://36kr.com/feed");
            contentValues.put("description", "为创业者提供最好的产品和服务");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "科学松鼠会");
            contentValues.put("link", "http://songshuhui.net/feed");
            contentValues.put("description", "让我们来剥开科学的坚果");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "科学公园");
            contentValues.put("link", "http://www.scipark.net/feed");
            contentValues.put("description", "科学就是力量");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "PanSci 泛科學");
            contentValues.put("link", "http://pansci.asia/feed");
            contentValues.put("description", "全台最大科學知識社群");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "Matrix67");
            contentValues.put("link", "http://www.matrix67.com/blog/feed");
            contentValues.put("description", " ");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "网易新闻");
            contentValues.put("link", "http://news.163.com/special/00011K6L/rss_newsattitude.xml");
            contentValues.put("description", "网易新闻·有态度专栏");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "Engadget");
            contentValues.put("link", "http://cn.engadget.com/rss.xml");
            contentValues.put("description", "Engadget 中国版");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "科学网博客RSS");
            contentValues.put("link", "http://fullrss.net/a/http/www.sciencenet.cn/xml/blog.aspx?di=20");
            contentValues.put("description", "科学网是由科学院、工程院和基金委主管，中国科学报社主办的公益性网站，提供新闻、博客、论坛、免费信息发布、资料互助等服务");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            Log.d("SUCCESS=====","Init data success.");
        }
        catch (Exception ex){
            Log.e("ERROR",ex.getStackTrace().toString());
        }
    }
}
