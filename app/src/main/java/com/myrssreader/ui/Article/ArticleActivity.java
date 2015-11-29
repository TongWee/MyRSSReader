package com.myrssreader.ui.Article;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myrssreader.R;
import com.myrssreader.bean.FeedItem;
import com.myrssreader.presenter.ArticlePresenter;
import com.myrssreader.ui.ActionBarActivity;
import com.myrssreader.ui.Detail.DetailActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class ArticleActivity extends ActionBarActivity implements ArticleView {

    @Inject
    ArticlePresenter mArticlePresenter;
    @Bind(R.id.tool_Bar)
    Toolbar _ToolBar;
    @Bind(R.id.btn_readmore)
    Button _BtnReadmore;
    @Bind(R.id.tv_article)
    TextView _TvArticle;
    @Bind(R.id.tv_description)
    TextView _TvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FeedItem feedItem = getIntent().getParcelableExtra("feedItem");
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        _ToolBar.setTitle(R.string.activity_article);
        setSupportActionBar(_ToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Intent intent = new Intent(this, DetailActivity.class);

        if (feedItem != null) {
            _TvArticle.setText(feedItem.getTitle());
            if(feedItem.getDescription().length() < 10)
                _TvDescription.setVisibility(View.GONE);
            else
                _TvDescription.setText(Html.fromHtml(feedItem.getDescription()));
            intent.putExtra("link", feedItem.getLink());
        }

        _BtnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (feedItem.getLink() != null)
                    startActivity(intent);
            }
        });
    }
}
