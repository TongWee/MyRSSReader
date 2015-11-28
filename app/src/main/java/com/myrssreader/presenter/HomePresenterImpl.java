package com.myrssreader.presenter;

import android.widget.Toast;

import com.myrssreader.RSSReaderApp;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.interactor.HomeInteractor;
import com.myrssreader.interactor.OnGetSubscribeListCallBack;
import com.myrssreader.ui.Home.HomeView;

import java.util.List;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomePresenterImpl implements HomePresenter, OnGetSubscribeListCallBack {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresenterImpl(HomeView _homeView, HomeInteractor _homeInteractor) {
        this.homeView = _homeView;
        this.homeInteractor = _homeInteractor;
    }

    /**
     * 添加订阅
     * @param urlString RSS源URL地址
     */
    @Override
    public void addSubscribe(String urlString) {
        homeInteractor.addSubscribe(urlString, this);
    }

    /**
     * 第一次加载订阅频道列表
     */
    @Override
    public void firstLoadSubscribeList() {
        homeInteractor.loadSubscribeList(this);
    }

    /**
     * 回调函数获取订阅列表
     * @param feedResposeList 回调函数参数
     */
    @Override
    public void onSuccess(List<FeedRespose> feedResposeList) {
        homeView.firstLoadSubscribe(feedResposeList);
    }

    /**
     * 回调函数添加订阅
     * @param feedRespose 回调函数参数
     */
    @Override
    public void onSuccessAdd(FeedRespose feedRespose) {
        homeView.addSubscribe(feedRespose);
    }

    /**
     * 回调函数订阅失败
     * @param errorString 错误信息
     */
    @Override
    public void onFailure(String errorString) {
        Toast.makeText(RSSReaderApp.getContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}
