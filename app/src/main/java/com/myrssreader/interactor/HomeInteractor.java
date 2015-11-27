package com.myrssreader.interactor;


/**
 * Created by Tong on 2015/11/18.
 */
public interface HomeInteractor {

    void loadSubscribeList(OnGetSubscribeListCallBack onGetSubscribeListCallBack);

    void addSubscribe(String urlString, OnGetSubscribeListCallBack onGetSubscribeListCallBack);
}
