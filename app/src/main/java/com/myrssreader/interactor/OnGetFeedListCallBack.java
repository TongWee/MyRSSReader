package com.myrssreader.interactor;

import com.myrssreader.bean.FeedRespose;

/**
 * Created by Tong on 2015/11/22.
 */
public interface OnGetFeedListCallBack {
    void onSuccess(FeedRespose feedRespose);
    void onFailure(String ex);
}
