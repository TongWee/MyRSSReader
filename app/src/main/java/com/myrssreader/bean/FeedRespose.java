package com.myrssreader.bean;

import android.util.Log;

import java.util.List;
import java.util.Vector;

/**
 * Created by Tong on 2015/11/18.
 */



public class FeedRespose {
    private int count;
    private int loadedCount;
    private String title;
    private String description;
    private String link;
    private List<FeedItem> feedList;

    public FeedRespose(){
        count = 0;
        loadedCount = 0;
//        title = " ";
//        description = " ";
//        link = " ";
        feedList = new Vector<>(0);
    }

    public List<FeedItem> getFeedList(){
        return feedList;
    }

    public void addFeed(FeedItem item){
        feedList.add(item);
        this.count++;
    }

    public void deleteFeed(FeedItem item){
        feedList.remove(item);
        if(this.count == 0)
            Log.e("DeleteFeed","FeedItem is Empty.");
        else
            this.count--;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
