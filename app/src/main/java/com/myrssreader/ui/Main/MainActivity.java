package com.myrssreader.ui.Main;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.myrssreader.R;
import com.myrssreader.presenter.MainModule;
import com.myrssreader.presenter.MainPresenter;
import com.myrssreader.ui.BaseActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        _ToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        ActionBarDrawerToggle adTogger = new ActionBarDrawerToggle(this,
                _DrawerLayout,_ToolBar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        _DrawerLayout.setDrawerListener(adTogger);
        adTogger.syncState();

        FragmentManager mFragmentManager;
    }

    @Override
    public void onBackPressed() {
        if(_DrawerLayout.isDrawerOpen(Gravity.LEFT))
            _DrawerLayout.closeDrawer(Gravity.LEFT);
        else
            doExit();
    }

    private long exitTime = 0;

    public void doExit(){
        if(System.currentTimeMillis() - exitTime > 2000){
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }
        else
            finish();
    }
    @Override
    public List<Object> getModules(){
        return Arrays.<Object>asList(new MainModule(this));
    }
}
