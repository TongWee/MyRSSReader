package com.myrssreader.ui.Article;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.myrssreader.R;
import com.myrssreader.presenter.ArticleModule;
import com.myrssreader.presenter.ArticlePresenter;
import com.myrssreader.ui.BaseActivity;
import com.myrssreader.util.ResourceHelper;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class ArticleActivity extends BaseActivity implements ArticleView {

    @Inject
    ArticlePresenter mArticlePresenter;
    @Bind(R.id.tool_Bar)
    Toolbar _ToolBar;
    @Bind(R.id.btn_readmore)
    Button _BtnReadmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        _ToolBar.setTitle(R.string.activity_article);
        setSupportActionBar(_ToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new ArticleModule(this));
    }
}
