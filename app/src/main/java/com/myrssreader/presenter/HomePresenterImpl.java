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

    @Override
    public void addSubscribe(String urlString) {
        homeInteractor.addSubscribe(urlString, this);
    }

    @Override
    public void firstLoadSubscribeList() {
        homeInteractor.loadSubscribeList(this);
    }

    @Override
    public void onSuccess(List<FeedRespose> feedResposeList) {
        homeView.firstLoadSubscribe(feedResposeList);
    }

    @Override
    public void onSuccessAdd(FeedRespose feedRespose) {
        homeView.addSubscribe(feedRespose);
    }

    @Override
    public void onFailure(String errorString) {
        Toast.makeText(RSSReaderApp.getContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}
