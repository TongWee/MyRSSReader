package com.myrssreader.ui.Setting;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.myrssreader.ActionBarActivity;
import com.myrssreader.R;
import com.myrssreader.RSSReaderApp;
import com.myrssreader.bean.FeedItem;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.util.RSSHandler;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
