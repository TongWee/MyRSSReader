package com.myrssreader.presenter;

import com.myrssreader.interactor.SubscribeInteractor;
import com.myrssreader.ui.Subscribe.SubscribeView;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribePresenterImpl implements SubscribePresenter {

    private SubscribeView subscribeView;

    private SubscribeInteractor subscribeInteractor;
    public SubscribePresenterImpl (SubscribeView _subscribeView, SubscribeInteractor _subscribeInteractor){
        this.subscribeView = _subscribeView;
        this.subscribeInteractor = _subscribeInteractor;
    }
}
