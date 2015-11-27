package com.myrssreader.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tong on 2015/11/18.
 * 每一篇文章对应的对象，在一个feedResponse中存储多个feedItem
 */
public class FeedItem implements Parcelable {
    private String title;
    private String category;
    private String description;
    private String pubDate;
    private String link;
    private String source;
    private String author;
    private boolean isLoaded;
    private boolean isStared;

    public FeedItem() {
        isLoaded = false;
        isStared = false;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setIsLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
    }

    public boolean isStared() {
        return isStared;
    }

    public void setIsStared(boolean isStared) {
        this.isStared = isStared;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(link);
        parcel.writeString(description);
    }

    public static final Parcelable.Creator<FeedItem> CREATOR = new Parcelable.Creator<FeedItem>() {

        @Override
        public FeedItem createFromParcel(Parcel parcel) {
            FeedItem feedItem = new FeedItem();
            feedItem.title = parcel.readString();
            feedItem.link = parcel.readString();
            feedItem.description = parcel.readString();
            return feedItem;
        }

        @Override
        public FeedItem[] newArray(int i) {
            return new FeedItem[i];
        }
    };
}
