package com.myrssreader.presenter;

import android.content.Context;

import com.myrssreader.interactor.MainInteractor;
import com.myrssreader.ui.Home.HomeView;
import com.myrssreader.ui.Main.MainView;

/**
 * Created by Tong on 2015/11/18.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private MainInteractor mainInteractor;
    public MainPresenterImpl(MainView _mainView, MainInteractor _mainInteractor){
        this.mainView = _mainView;
        this.mainInteractor = _mainInteractor;
    }

    @Override
    public void initSubscribeData(Context context) {
//        mainInteractor.createDatabase(context);
        mainInteractor.initData();
    }
}
