package com.myrssreader.presenter;

import com.myrssreader.AppModule;
import com.myrssreader.interactor.StaredInteractor;
import com.myrssreader.ui.Stared.StaredFragment;
import com.myrssreader.ui.Stared.StaredView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tong on 2015/11/19.
 */

@Module(
        injects = StaredFragment.class,
        addsTo = MainModule.class,
        library = true
)

public class StaredModule {

    private StaredView staredView;

    public StaredModule(StaredView _staredView){
        this.staredView = _staredView;
    }

    @Provides
    @Singleton
    public StaredView provideStaredView(){
        return this.staredView;
    }

    @Provides
    @Singleton
    public StaredPresenter provideStaredPresenter(StaredView _staredView, StaredInteractor _staredInteractor){
        return new StaredPresenterImpl(_staredView, _staredInteractor);
    }
}
