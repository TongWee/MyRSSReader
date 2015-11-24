package com.myrssreader.interactor;

import android.database.Cursor;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.myrssreader.RSSReaderApp;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.util.DataBaseHelper;
import com.myrssreader.util.RSSHandler;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomeInteractorImpl implements HomeInteractor {
    private DataBaseHelper dataBaseHelper;
    public HomeInteractorImpl(){
        dataBaseHelper = RSSReaderApp.getDataBaseHelper();
    }
    @Override
    public void loadSubscribeList(OnGetSubscribeListCallBack onGetSubscribeListCallBack) {
        List<FeedRespose> feedResposeList = dataBaseHelper.getAllSubscribe();
        if (feedResposeList == null)
            onGetSubscribeListCallBack.onFailure("获取订阅信息失败");
        else
            onGetSubscribeListCallBack.onSuccess(feedResposeList);
    }

    @Override
    public void addSubscribe(String urlString, final OnGetSubscribeListCallBack onGetSubscribeListCallBack) {
        RequestQueue requestQueue = Volley.newRequestQueue(RSSReaderApp.getContext());
        StringRequest stringRequest = new StringRequest(urlString, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                FeedRespose feedRespose = parseXMLWithSAX(response);
                if(feedRespose == null)
                    onGetSubscribeListCallBack.onFailure("添加订阅失败");
                else
                    onGetSubscribeListCallBack.onSuccessAdd(feedRespose);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onGetSubscribeListCallBack.onFailure("添加订阅失败");
            }
        }
        );
        requestQueue.add(stringRequest);
    }

    private FeedRespose parseXMLWithSAX(String xmlData){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            RSSHandler rssHandler = new RSSHandler();
            xmlReader.setContentHandler(rssHandler);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
            FeedRespose feedRespose = rssHandler.getRespose();
            return feedRespose;
        }catch (Exception ex){
            Log.d("XML", ex.getStackTrace().toString());
            return null;
        }
    }

}
