package com.myrssreader.presenter;

import com.myrssreader.AppModule;
import com.myrssreader.interactor.MainInteractor;
import com.myrssreader.ui.Main.MainActivity;
import com.myrssreader.ui.Main.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tong on 2015/11/19.
 */
@Module(
        injects = MainActivity.class,
        addsTo = AppModule.class,
        library = true
)

public class MainModule {

    private MainView view;

    public MainModule(MainView _view) {
        this.view = _view;
    }

    @Provides
    @Singleton
    public MainView provideMainView() {
        return this.view;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(MainView _view, MainInteractor _mainInteractor) {
        return new MainPresenterImpl(_view, _mainInteractor);
    }
}
