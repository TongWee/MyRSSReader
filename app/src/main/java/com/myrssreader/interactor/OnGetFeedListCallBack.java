package com.myrssreader.interactor;

import com.myrssreader.bean.FeedItem;

import java.util.List;

/**
 * Created by Tong on 2015/11/22.
 */
public interface OnGetFeedListCallBack {
    void onSuccess(List<FeedItem> feedList);
    void onFailure(String ex);
}
