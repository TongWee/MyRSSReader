package com.myrssreader.presenter;

import com.myrssreader.AppModule;
import com.myrssreader.interactor.HomeInteractor;
import com.myrssreader.ui.Home.HomeFragment;
import com.myrssreader.ui.Home.HomeView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tong on 2015/11/18.
 */

@Module(
        injects = HomeFragment.class,
        addsTo = MainModule.class,
        library = true
)


public class HomeModule {

    private HomeView homeView;

    public HomeModule(HomeView _homeView){
        this.homeView = _homeView;
    }

    @Provides
    @Singleton
    public HomeView provideHomeView(){
        return this.homeView;
    }

    @Provides
    @Singleton
    public HomePresenter provideHomePresneter(HomeView _homeView, HomeInteractor homeInteractor){
        return new HomePresenterImpl(_homeView, homeInteractor);
    }

}
