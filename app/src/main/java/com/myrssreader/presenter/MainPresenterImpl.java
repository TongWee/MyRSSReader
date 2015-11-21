package com.myrssreader.presenter;

import com.myrssreader.ui.Home.HomeView;
import com.myrssreader.ui.Main.MainView;

/**
 * Created by Tong on 2015/11/18.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView _mainView){
        this.mainView = _mainView;
    }

}
