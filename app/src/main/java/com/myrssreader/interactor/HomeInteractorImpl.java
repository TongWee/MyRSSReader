package com.myrssreader.interactor;

import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

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
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomeInteractorImpl implements HomeInteractor {
    private DataBaseHelper dataBaseHelper;

    /**
     * 初始化数据库及数据
     */
    public HomeInteractorImpl() {
        dataBaseHelper = RSSReaderApp.getDataBaseHelper();
    }

    /**
     * 加载已订阅订阅频道列表
     * @param onGetSubscribeListCallBack 回调函数 返回feedResponse对象
     */
    @Override
    public void loadSubscribeList(OnGetSubscribeListCallBack onGetSubscribeListCallBack) {
        List<FeedRespose> feedResposeList = dataBaseHelper.getAllSubscribe();
        if (feedResposeList == null)
            onGetSubscribeListCallBack.onFailure("获取订阅信息失败");
        else
            onGetSubscribeListCallBack.onSuccess(feedResposeList);
    }

    /**
     *
     * @param urlString RSS源的URL地址
     * @param onGetSubscribeListCallBack 回调函数 返回feedResponse对象
     */
    @Override
    public void addSubscribe(final String urlString, final OnGetSubscribeListCallBack onGetSubscribeListCallBack) {
        RequestQueue requestQueue = Volley.newRequestQueue(RSSReaderApp.getContext());
        final String strLink;
        if (!urlString.contains("http://"))
            strLink = "http://" + urlString;
        else
            strLink = urlString;
        StringRequest stringRequest = new StringRequest(strLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                FeedRespose feedRespose = parseXMLWithSAX(response);
                if (feedRespose == null)
                    onGetSubscribeListCallBack.onFailure("添加订阅失败");
                else {
                    feedRespose.setLink(strLink);
                    dataBaseHelper.insertSubscribe(feedRespose);
                    onGetSubscribeListCallBack.onSuccessAdd(feedRespose);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onGetSubscribeListCallBack.onFailure(error.toString());
            }
        }
        );
        requestQueue.add(stringRequest);
    }

    /**
     *
     * @param xmlData String流形式的xml数据
     * @return 解析出的feedResponse对象
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
