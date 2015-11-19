package com.myrssreader.presenter;

import com.myrssreader.ui.Home.HomeView;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;

    public HomePresenterImpl(HomeView _homeView){
        this.homeView = _homeView;
    }
}
