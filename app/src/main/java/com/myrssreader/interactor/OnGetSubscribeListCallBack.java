package com.myrssreader.interactor;

import com.myrssreader.bean.FeedRespose;

import java.util.List;

/**
 * Created by Tong on 2015/11/24.
 */
public interface OnGetSubscribeListCallBack {
    void onSuccess(List<FeedRespose> feedResposeList);
    void onSuccessAdd(FeedRespose feedRespose);
    void onFailure(String errorString);
}
