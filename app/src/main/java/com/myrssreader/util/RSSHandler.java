package com.myrssreader.util;

import com.myrssreader.bean.FeedItem;
import com.myrssreader.bean.FeedRespose;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Tong on 2015/11/22.
 */
public class RSSHandler extends DefaultHandler {

    private FeedItem feedItem;

    private FeedRespose feedRespose;

    private String lastElementName = "";


    private final int RSS_FEED_TITLE = 1;
    private final int RSS_FEED_DESCRIPTION = 4;
    private final int RSS_FEED_LINK = 5;

    private final int RSS_TITLE = 6;
    private final int RSS_CATEGORY = 7;
    private final int RSS_PUBDATE = 8;
    private final int RSS_DESCRIPTION = 9;
    private final int RSS_LINK = 10;

    private boolean isFeedTitle = true;
    private boolean isFeedDescription = true;
    private boolean isFeedLink = true;

    int currentState = 0;

    public FeedRespose getRespose(){
        return feedRespose;
    }

    @Override
    public void startDocument() throws SAXException {
        feedItem = new FeedItem();
        feedRespose = new FeedRespose();
//        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        if(localName.equals("channel")){
            currentState = 0;
            return;
        }

        if(localName.equals("item")){
            feedItem = new FeedItem();
            return;
        }

        if(localName.equals("title")){
            if(isFeedTitle){
                isFeedTitle = false;
                currentState = RSS_FEED_TITLE;
            }
            else
                currentState = RSS_TITLE;
            return;
        }

        if(localName.equals("category")){
            currentState = RSS_CATEGORY;
            return;
        }

        if(localName.equals("link")){
            if(isFeedLink){
                isFeedLink = false;
                currentState = RSS_FEED_LINK;
            }
            else
                currentState = RSS_LINK;
            return;
        }

        if(localName.equals("description")){
            if(isFeedDescription){
                isFeedDescription = false;
                currentState = RSS_FEED_DESCRIPTION;
            }
            else
                currentState = RSS_DESCRIPTION;
            return;
        }

        if(localName.equals("pubDate")) {
            currentState = RSS_PUBDATE;
            return;
        }
        currentState = 0;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contentString = new String(ch, start, length);
        switch (currentState){
            case RSS_FEED_TITLE:
                feedRespose.setTitle(contentString);
                currentState = 0;
                break;
            case RSS_FEED_LINK:
                currentState = 0;
                feedRespose.setLink(contentString);
                break;
            case RSS_FEED_DESCRIPTION:
                currentState = 0;
                feedRespose.setLink(contentString);
                break;
            case RSS_TITLE:
                currentState = 0;
                feedItem.setTitle(contentString);
                break;
            case RSS_CATEGORY:
                currentState = 0;
                feedItem.setCategory(contentString);
                break;
            case RSS_PUBDATE:
                currentState = 0;
                feedItem.setPubDate(contentString);
                break;
            case RSS_LINK:
                currentState = 0;
                feedItem.setLink(contentString);
                break;
            case RSS_DESCRIPTION:
                currentState = 0;
                feedItem.setDescription(contentString);
                break;
            default:
                currentState = 0;
                return;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        if(localName.equals("item"))
        {
            feedRespose.addFeed(feedItem);
            return;
        }
    }

    @Override
    public void endDocument() throws SAXException {
//        super.endDocument();
    }
}
