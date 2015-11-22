package com.myrssreader.bean;

/**
 * Created by Tong on 2015/11/18.
 */
public class FeedItem {
    private String title;
    private String category;
    private String description;
    private String pubDate;
    private String link;
    private String source;
    private String author;
    private boolean isLoaded;
    private boolean isStared;

    public FeedItem(){
        title = " ";
        category = " ";
        description = " ";
        pubDate = " ";
        link = " ";
        source = " ";
        author = " ";
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

}
