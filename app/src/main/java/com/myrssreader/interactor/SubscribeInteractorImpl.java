package com.myrssreader.interactor;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.myrssreader.RSSReaderApp;
import com.myrssreader.bean.FeedItem;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.util.RSSHandler;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribeInteractorImpl implements SubscribeInteractor {
    /**
     * 获取FeedItem列表
     * @param urlString URL地址
     * @param onGetFeedListCallBack 回调函数 获取得到的数据
     */
    @Override
    public void getFeedListPage(final String urlString,final OnGetFeedListCallBack onGetFeedListCallBack) {
        RequestQueue requestQueue = Volley.newRequestQueue(RSSReaderApp.getContext());
        String strLink = urlString;
        if (!urlString.contains("http://"))
            strLink = "http://" + urlString;
        StringRequest stringRequest = new StringRequest(strLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                FeedRespose feedRespose = parseXMLWithSAX(response);
                if(feedRespose == null)
                    onGetFeedListCallBack.onFailure("加载文章列表失败");
                else
                    onGetFeedListCallBack.onSuccess(feedRespose.getFeedList());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onGetFeedListCallBack.onFailure(error.toString());
            }
        }
        );
        requestQueue.add(stringRequest);
    }

    /**
     *
     * @param xmlData String流形式的xml数据
     * @return feedResponse对象
     */
    private FeedRespose parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            RSSHandler rssHandler = new RSSHandler();
            xmlReader.setContentHandler(rssHandler);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
            FeedRespose feedRespose = rssHandler.getRespose();
            return feedRespose;
        } catch (Exception ex) {
            Log.d("XML", ex.getStackTrace().toString());
            return null;
        }
    }
}
