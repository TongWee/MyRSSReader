package com.myrssreader.ui.Detail;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.melnykov.fab.FloatingActionButton;
import com.myrssreader.R;
import com.myrssreader.ui.ActionBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class DetailActivity extends ActionBarActivity implements DetailView {
    @Bind(R.id.fab_detail)
    FloatingActionButton _FabDetail;

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

        _FabDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "收藏功能敬请期待", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
