package com.myrssreader.presenter;

import com.myrssreader.interactor.ArticleInteractor;
import com.myrssreader.ui.Article.ArticleView;

/**
 * Created by Tong on 2015/11/18.
 */
public class ArticlePresenterImpl implements ArticlePresenter {

    private ArticleView articleView;
    private ArticleInteractor articleInteractor;
    public ArticlePresenterImpl(ArticleView _articleView, ArticleInteractor _articleInteractor){
        this.articleView = _articleView;
        this.articleInteractor = _articleInteractor;
    }
}
