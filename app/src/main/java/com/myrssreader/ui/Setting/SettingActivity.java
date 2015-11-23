package com.myrssreader.ui.Setting;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;

import com.myrssreader.ActionBarActivity;
import com.myrssreader.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class SettingActivity extends ActionBarActivity {
    @Bind(R.id.tool_Bar)
    Toolbar _ToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_setting);
        ButterKnife.bind(this);
        _ToolBar.setTitle(R.string.activity_setting);
        setSupportActionBar(_ToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
