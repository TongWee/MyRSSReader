package com.myrssreader.presenter;

import android.view.View;
import android.widget.Toast;

import com.myrssreader.RSSReaderApp;
import com.myrssreader.bean.FeedItem;
import com.myrssreader.interactor.OnGetFeedListCallBack;
import com.myrssreader.interactor.SubscribeInteractor;
import com.myrssreader.ui.Subscribe.SubscribeView;

import java.util.List;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribePresenterImpl implements SubscribePresenter, OnGetFeedListCallBack {

    private SubscribeView subscribeView;
    private SubscribeInteractor subscribeInteractor;
    private String link = "http://www.liaoxuefeng.com/feed";
    private boolean isLoadingMore = false;
    private boolean isFirstTimeLoad = true;
    private boolean isResfreshing = false;

    public SubscribePresenterImpl(SubscribeView _subscribeView, SubscribeInteractor _subscribeInteractor) {
        this.subscribeView = _subscribeView;
        this.subscribeInteractor = _subscribeInteractor;
    }

    /**
     * 将获取的文章列表加载交给view层加载到UI上
     *
     * @param feedItemList 文章列表
     */
    @Override
    public void onSuccess(List<FeedItem> feedItemList) {
        if (isLoadingMore) {
            subscribeView.loadMoreItems(feedItemList);
            subscribeView.hideRefresh();
            isLoadingMore = false;
        } else if (isFirstTimeLoad) {
            subscribeView.loadMoreItems(feedItemList);
            subscribeView.hideRefresh();
            isFirstTimeLoad = false;
        } else if (isResfreshing) {
            subscribeView.refreshItems(feedItemList);
            subscribeView.hideRefresh();
            isFirstTimeLoad = false;
        }
        subscribeView.setBackEnable(true);
        subscribeView.hideRefresh();
    }

    /**
     * Toast显示错误信息
     *
     * @param ex 错误信息
     */
    @Override
    public void onFailure(String ex) {
        Toast.makeText(RSSReaderApp.getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
        subscribeView.hideRefresh();
        subscribeView.setBackEnable(true);
    }

    /**
     * 第一次加载文章列表
     *
     * @param _link RSS源URL地址
     */
    @Override
    public void firstTimeRefreshHomeItems(String _link) {
        subscribeView.setBackEnable(false);
        subscribeView.showRefresh();
        if (_link != null)
            this.link = _link;
        subscribeInteractor.getFeedListPage(link, this);
    }

    /**
     * 刷新文章列表
     */
    @Override
    public void refreshHomeItems() {
        subscribeView.setBackEnable(false);
        if (isResfreshing)
            return;
        isResfreshing = true;
        subscribeView.showRefresh();
        subscribeInteractor.getFeedListPage(link, this);
    }

    /**
     * 加载更多
     * (暂未添加该功能)
     */
    @Override
    public void loadMoreHomeItems() {
        refreshHomeItems();
//        if(isLoadingMore)
//            return;
//        isLoadingMore = true;
//        subscribeView.showRefresh();
//        subscribeInteractor.getFeedListPage(link, mItemPrePage,this);
    }

    @Override
    public void onItemClicked(View v, int position) {

    }
}
