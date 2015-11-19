package com.myrssreader.interactor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tong on 2015/11/19.
 */

@Module(
        complete = true,
        library = false
)
public class InteractorsModule {

    @Provides
    @Singleton
    public ArticleInteractor provideArticleInteractor(){return new ArticleInteractorImpl();}

    @Provides
    @Singleton
    public HomeInteractor provideHomeInteractor(){return new HomeInteractorImpl();}

    @Provides
    @Singleton
    public StaredInteractor provideStaredInteractor(){return new StaredInteractorImpl();}

    @Provides
    @Singleton
    public SubscribeInteractor provideSubscribeInteractor(){return new SubscribeInteractorImpl();}

    @Provides
    @Singleton
    public MainInteractor provideMainInteractor(){return new MainInteractorImpl();}
}
