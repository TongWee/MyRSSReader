package com.myrssreader.presenter;

import com.myrssreader.AppModule;
import com.myrssreader.interactor.ArticleInteractor;
import com.myrssreader.ui.Article.ArticleActivity;
import com.myrssreader.ui.Article.ArticleView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tong on 2015/11/19.
 */

@Module(
        injects = ArticleActivity.class,
        addsTo = AppModule.class,
        library = true
)
public class ArticleModule {

    private ArticleView articleView;

    public ArticleModule(ArticleView _articleView) {
        this.articleView = _articleView;
    }

    @Provides
    @Singleton
    public ArticleView provideArticleView(){
        return this.articleView;
    }

    @Provides
    @Singleton
    public ArticlePresenter provideArticlePresenter(ArticleView _articleView, ArticleInteractor _articleInteractor){
        return new ArticlePresenterImpl(_articleView, _articleInteractor);
    }
}
