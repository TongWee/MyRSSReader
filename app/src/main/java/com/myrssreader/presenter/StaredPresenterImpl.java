package com.myrssreader.presenter;

import com.myrssreader.interactor.StaredInteractor;
import com.myrssreader.ui.Stared.StaredView;

/**
 * Created by Tong on 2015/11/18.
 */
public class StaredPresenterImpl implements StaredPresenter {

    private StaredView staredView;

    private StaredInteractor staredInteractor;

    public StaredPresenterImpl(StaredView _staredView, StaredInteractor _staredInteractor){
        this.staredView = _staredView;
        this.staredInteractor = _staredInteractor;
    }
}
