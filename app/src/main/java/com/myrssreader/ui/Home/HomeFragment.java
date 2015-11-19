package com.myrssreader.ui.Home;

import com.myrssreader.presenter.ArticleModule;
import com.myrssreader.presenter.HomeModule;
import com.myrssreader.presenter.HomePresenter;
import com.myrssreader.ui.BaseFragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomeFragment extends BaseFragment implements HomeView{

    @Inject
    HomePresenter mHomePresenter;

    @Override
    public List<Object> getModules(){
        return Arrays.<Object>asList(new HomeModule(this));
    }
}
