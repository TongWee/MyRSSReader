package com.myrssreader.ui.Help;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.myrssreader.R;
import com.myrssreader.ui.ActionBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class HelpActivity extends ActionBarActivity implements HelpView {
    @Bind(R.id.tool_Bar)
    Toolbar _ToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);
        _ToolBar.setTitle(R.string.activity_help);
        setSupportActionBar(_ToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
