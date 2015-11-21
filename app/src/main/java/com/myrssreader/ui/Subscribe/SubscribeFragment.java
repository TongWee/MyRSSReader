package com.myrssreader.ui.Subscribe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myrssreader.R;
import com.myrssreader.presenter.SubscribeModule;
import com.myrssreader.presenter.SubscribePresenter;
import com.myrssreader.ui.BaseFragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribeFragment extends BaseFragment implements SubscribeView{

    @Inject
    SubscribePresenter mSubscribePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subscribe,container,false);
        return rootView;
    }

    @Override
    public List<Object> getModules(){
        return Arrays.<Object>asList(new SubscribeModule(this));
    }
}
