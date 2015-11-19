package com.myrssreader.ui.Article;

import android.app.Activity;

import com.myrssreader.presenter.ArticleModule;
import com.myrssreader.presenter.ArticlePresenter;
import com.myrssreader.ui.BaseActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tong on 2015/11/18.
 */
public class ArticleActivity extends BaseActivity implements ArticleView {

    @Inject
    ArticlePresenter mArticlePresenter;

    @Override
    public List<Object> getModules(){
        return Arrays.<Object>asList(new ArticleModule(this));
    }
}
