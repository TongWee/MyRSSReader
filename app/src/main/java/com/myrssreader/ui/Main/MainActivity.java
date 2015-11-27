package com.myrssreader.ui.Main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.myrssreader.R;
import com.myrssreader.presenter.MainModule;
import com.myrssreader.presenter.MainPresenter;
import com.myrssreader.ui.BaseActivity;
import com.myrssreader.ui.Help.HelpActivity;
import com.myrssreader.ui.Home.HomeFragment;
import com.myrssreader.ui.OnTurntoSubscribeFragment;
import com.myrssreader.ui.Setting.SettingActivity;
import com.myrssreader.ui.Stared.StaredFragment;
import com.myrssreader.ui.Subscribe.SubscribeFragment;
import com.myrssreader.ui.Suggestion.SuggestionActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView, NavigationView.OnNavigationItemSelectedListener, OnTurntoSubscribeFragment {

    @Inject
    MainPresenter mMainPresenter;
    @Bind(R.id.tool_Bar)
    Toolbar _ToolBar;
    @Bind(R.id.main_content)
    CoordinatorLayout _MainContent;
    @Bind(R.id.navigation_view)
    NavigationView _NavigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout _DrawerLayout;
    private HomeFragment homeFragment;
    private StaredFragment staredFragment;
    private SubscribeFragment subscribeFragment;
    private String curFragment;
    private boolean isBackEnable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        _ToolBar.setTitle(R.string.menu_home);
        setSupportActionBar(_ToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMainPresenter.initSubscribeData(this);

        ActionBarDrawerToggle adTogger = new ActionBarDrawerToggle(this,
                _DrawerLayout, _ToolBar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        _DrawerLayout.setDrawerListener(adTogger);
        adTogger.syncState();

        _NavigationView.setNavigationItemSelectedListener(this);

        homeFragment = new HomeFragment();
        homeFragment.setOnTurntoSubscribeFragment(this);
        curFragment = "HomeFragment";
        getFragmentManager().beginTransaction().replace(R.id.main_container, homeFragment).commit();

    }

    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }

    @Override
    public void onBackPressed() {
        if (isBackEnable) {
            if (_DrawerLayout.isDrawerOpen(Gravity.LEFT))
                _DrawerLayout.closeDrawer(Gravity.LEFT);
            else if (curFragment.equals("SubscribeFragment")) {
                curFragment = "HomeFragment";
                _ToolBar.setTitle("主页");
                getFragmentManager().beginTransaction().replace(R.id.main_container, homeFragment).commit();
            } else
                super.doExit();
        }
    }

    @Override
    public void changeFragment(int rId) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = null;
        boolean isActivity = false;
        switch (rId) {
            case R.id.menu_item_main:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                homeFragment.setOnTurntoSubscribeFragment(this);
                fragment = homeFragment;
                curFragment = "HomeFragment";
                _ToolBar.setTitle(R.string.menu_home);
                break;
            case R.id.menu_item_subscribe:
                if (subscribeFragment == null)
                    subscribeFragment = new SubscribeFragment();
                subscribeFragment.setOnBackListener(this);
                fragment = subscribeFragment;
                curFragment = "Subscribe";
                _ToolBar.setTitle(R.string.menu_subscribe);
                break;
            case R.id.menu_item_star:
                if (staredFragment == null)
                    staredFragment = new StaredFragment();
                fragment = staredFragment;
                curFragment = "StaredFragment";
                _ToolBar.setTitle(R.string.menu_star);
                break;
            case R.id.menu_item_help:
                isActivity = true;
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.menu_item_setting:
                isActivity = true;
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.menu_item_suggestion:
                isActivity = true;
                startActivity(new Intent(this, SuggestionActivity.class));
                break;
            default:
                return;
        }
        if (!isActivity) {
            fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.main_container, fragment).commit();
        }
        _DrawerLayout.closeDrawer(Gravity.LEFT);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        changeFragment(menuItem.getItemId());
        return true;
    }

    @Override
    public void onGetLink(String link) {
        Bundle bundle = new Bundle();
        bundle.putString("Link", link);
        if (subscribeFragment == null)
            subscribeFragment = new SubscribeFragment();
        subscribeFragment.setArguments(bundle);
        subscribeFragment.setOnBackListener(this);
        _ToolBar.setTitle("订阅");
        curFragment = "SubscribeFragment";
        getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.main_container, subscribeFragment).commit();
    }

    @Override
    public void setBackEnable(boolean isEnable) {
        this.isBackEnable = isEnable;
    }

}
