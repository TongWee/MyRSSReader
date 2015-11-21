package com.myrssreader.ui.Suggestion;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.myrssreader.ActionBarActivity;
import com.myrssreader.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Tong on 2015/11/18.
 */
public class SuggestionActivity extends ActionBarActivity implements SuggestionView {
    @Bind(R.id.tool_Bar)
    Toolbar _ToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        ButterKnife.bind(this);
        _ToolBar.setTitle(R.string.activity_suggestion);
        setSupportActionBar(_ToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
