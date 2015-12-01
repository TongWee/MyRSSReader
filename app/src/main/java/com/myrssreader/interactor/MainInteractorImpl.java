package com.myrssreader.interactor;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.myrssreader.RSSReaderApp;
import com.myrssreader.util.DataBaseHelper;

/**
 * Created by Tong on 2015/11/19.
 */
public class MainInteractorImpl implements MainInteractor {
    DataBaseHelper dataBaseHelper;

    public MainInteractorImpl() {
        this.dataBaseHelper = RSSReaderApp.getDataBaseHelper();
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        if (!dataBaseHelper.isEmpty("Subscribe"))
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

            contentValues.put("title", "科学公园");
            contentValues.put("link", "http://www.scipark.net/feed");
            contentValues.put("description", "科学就是力量");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "Matrix67");
            contentValues.put("link", "http://www.matrix67.com/blog/feed");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();


            contentValues.put("title", "Engadget");
            contentValues.put("link", "http://cn.engadget.com/rss.xml");
            contentValues.put("description", "Engadget 中国版");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();


            contentValues.put("title", "理想生活实验室");
            contentValues.put("link", "http://www.toodaylab.com/feed");
            contentValues.put("description", "关注创意设计与生活消费");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "A Day Magazine");
            contentValues.put("link", "http://www.adaymag.com/feed/");
            contentValues.put("description", "時尚生活雜誌");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "词穷先生美文网");
            contentValues.put("link", "http://www.ciqiong.cn/feed");
            contentValues.put("description", "词穷先生美文网，静心阅读的倡导者，纯粹阅读，让我们更具魅力");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "Cinephilia迷影");
            contentValues.put("link", "http://cinephilia.net/feed");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "锋客网");
            contentValues.put("link", "http://www.phonekr.com/feed/");
            contentValues.put("description", "techXtreme 科技锋芒");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "爱范儿");
            contentValues.put("link", "http://www.ifanr.com/feed");
            contentValues.put("description", "连接热爱");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "极客范");
            contentValues.put("link", "http://www.geekfan.net/feed/");
            contentValues.put("description", "GeekFan.net");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "壹读博文");
            contentValues.put("link", "http://yidu.im/rss");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();

            contentValues.put("title", "The Economist");
            contentValues.put("link", "http://blog.ecocn.org/feed");
            contentValues.put("description", "经济学人 经济学家 中文版");
            sqLiteDatabase.insert("Subscribe", null, contentValues);
            contentValues.clear();
        } catch (Exception ex) {
            Log.e("ERROR", ex.getStackTrace().toString());
        }
    }
}
