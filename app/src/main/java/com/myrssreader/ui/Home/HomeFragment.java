package com.myrssreader.ui.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myrssreader.R;
import com.myrssreader.presenter.ArticleModule;
import com.myrssreader.presenter.HomeModule;
import com.myrssreader.presenter.HomePresenter;
import com.myrssreader.ui.BaseFragment;

import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

import javax.inject.Inject;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomeFragment extends BaseFragment implements HomeView{

    @Inject
    HomePresenter mHomePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        return rootView;
    }

    @Override
    public List<Object> getModules(){
        return Arrays.<Object>asList(new HomeModule(this));
    }
}
