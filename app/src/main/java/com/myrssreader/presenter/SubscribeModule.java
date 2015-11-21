package com.myrssreader.presenter;

import com.myrssreader.AppModule;
import com.myrssreader.interactor.SubscribeInteractor;
import com.myrssreader.ui.Subscribe.SubscribeFragment;
import com.myrssreader.ui.Subscribe.SubscribeView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tong on 2015/11/19.
 */

@Module(
        injects = SubscribeFragment.class,
        addsTo = MainModule.class,
        library = true
)
public class SubscribeModule {

    private SubscribeView subscribeView;

    public SubscribeModule(SubscribeView _subscribeView){
        this.subscribeView = _subscribeView;
    }

    @Provides
    @Singleton
    public SubscribeView provideSubscribeView(){
        return this.subscribeView;
    }

    @Provides
    @Singleton
    public SubscribePresenter provideSubscribePresenter(SubscribeView _subscribeView, SubscribeInteractor _subscribeInteractor){
        return new SubscribePresenterImpl(_subscribeView, _subscribeInteractor);
    }
}
