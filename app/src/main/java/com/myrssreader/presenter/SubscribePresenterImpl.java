package com.myrssreader.presenter;

import android.view.View;
import android.widget.Toast;

import com.myrssreader.RSSReaderApp;
import com.myrssreader.bean.FeedItem;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.interactor.OnGetFeedListCallBack;
import com.myrssreader.interactor.SubscribeInteractor;
import com.myrssreader.ui.Subscribe.SubscribeView;

import java.util.List;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribePresenterImpl implements SubscribePresenter,OnGetFeedListCallBack {

    private SubscribeView subscribeView;
    private SubscribeInteractor subscribeInteractor;

    private int mItemPrePage = 0;
    private boolean isLoadingMore = false;
    private boolean isFirstTimeLoad = true;
    private boolean isResfreshing = false;

    public SubscribePresenterImpl (SubscribeView _subscribeView, SubscribeInteractor _subscribeInteractor){
        this.subscribeView = _subscribeView;
        this.subscribeInteractor = _subscribeInteractor;
    }

    @Override
    public void onSuccess(List<FeedItem> feedItemList) {
        if(isLoadingMore){
            subscribeView.loadMoreItems(feedItemList);
            subscribeView.hideRefresh();
            isLoadingMore = false;
        }
        else if(isFirstTimeLoad){
            subscribeView.loadMoreItems(feedItemList);
            subscribeView.hideRefresh();
            isFirstTimeLoad = false;
        }
        else if(isResfreshing){
            subscribeView.refreshItems(feedItemList);
            subscribeView.hideRefresh();
            isResfreshing = false;
        }
        subscribeView.hideRefresh();
    }

    @Override
    public void onFailure(String ex) {
        Toast.makeText(RSSReaderApp.getContext(),"Failed",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void firstTimeRefreshHomeItems() {
        subscribeView.showRefresh();
        subscribeInteractor.getFeedListPage("http://www.liaoxuefeng.com/feed", mItemPrePage, this);
        //isFirstTimeLoad = true;
    }

    @Override
    public void refreshHomeItems() {
        if(isResfreshing)
            return;
        isResfreshing = true;
        subscribeView.showRefresh();
        subscribeInteractor.getFeedListPage("http://www.liaoxuefeng.com/feed", mItemPrePage,this);
    }

    @Override
    public void loadMoreHomeItems() {
        if(isLoadingMore)
            return;
        isLoadingMore = true;
        subscribeView.showRefresh();
        subscribeInteractor.getFeedListPage("http://www.liaoxuefeng.com/feed", mItemPrePage,this);
    }

    @Override
    public void onItemClicked(View v, int position) {

    }
}
