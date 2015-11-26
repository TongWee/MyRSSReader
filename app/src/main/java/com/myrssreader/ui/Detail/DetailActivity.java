package com.myrssreader.ui.Detail;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.myrssreader.R;
import com.myrssreader.ui.ActionBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class DetailActivity extends ActionBarActivity implements DetailView {


    @Bind(R.id.tool_Bar)
    Toolbar _ToolBar;
    @Bind(R.id.wv_detail)
    WebView _WvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        _ToolBar.setTitle(R.string.activity_detail);
        setSupportActionBar(_ToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String link = getIntent().getStringExtra("link");
        if (link != null)
            _WvDetail.loadUrl(link);
    }
}
