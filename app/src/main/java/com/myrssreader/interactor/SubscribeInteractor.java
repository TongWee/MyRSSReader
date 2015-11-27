package com.myrssreader.interactor;

import com.myrssreader.bean.FeedRespose;

/**
 * Created by Tong on 2015/11/18.
 */
public interface SubscribeInteractor {
    void getFeedListPage(String urlString,OnGetFeedListCallBack onGetFeedListCallBack);
}
