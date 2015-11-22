package com.myrssreader.presenter;

import android.widget.Toast;

import com.myrssreader.RSSReaderApp;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.interactor.OnGetFeedListCallBack;
import com.myrssreader.interactor.SubscribeInteractor;
import com.myrssreader.ui.Subscribe.SubscribeView;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribePresenterImpl implements SubscribePresenter,OnGetFeedListCallBack {

    private SubscribeView subscribeView;

    private SubscribeInteractor subscribeInteractor;
    public SubscribePresenterImpl (SubscribeView _subscribeView, SubscribeInteractor _subscribeInteractor){
        this.subscribeView = _subscribeView;
        this.subscribeInteractor = _subscribeInteractor;
    }

    @Override
    public void onSuccess(FeedRespose feedRespose) {

    }

    @Override
    public void onFailure(String ex) {
        Toast.makeText(RSSReaderApp.getContext(),"Failed",Toast.LENGTH_SHORT).show();
    }
}
