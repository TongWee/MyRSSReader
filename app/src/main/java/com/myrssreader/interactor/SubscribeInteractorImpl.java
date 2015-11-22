package com.myrssreader.interactor;

import android.util.Log;

import com.myrssreader.bean.FeedRespose;
import com.myrssreader.util.RSSHandler;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribeInteractorImpl implements SubscribeInteractor {

    @Override
    public FeedRespose getFeedResponse(String urlString) {
        try{
            URL url = new URL(urlString);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();

            RSSHandler rssHandler = new RSSHandler();
            xmlReader.setContentHandler(rssHandler);

            InputSource inputSource = new InputSource(url.openStream());
            xmlReader.parse(inputSource);

            return rssHandler.getRespose();
        }
        catch (Exception ex){
            Log.e("FEED", ex.getStackTrace().toString());
            return null;
        }
    }

    @Override
    public void getFeedListPage(final String urlString, final OnGetFeedListCallBack onGetFeedListCallBack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                FeedRespose feedRespose = getFeedResponse(urlString);
                if(feedRespose != null)
                    onGetFeedListCallBack.onSuccess(feedRespose);
                else
                    onGetFeedListCallBack.onFailure("Failed to get response.");
            }
        };
    }
}
