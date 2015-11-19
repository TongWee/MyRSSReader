package com.myrssreader.ui.Subscribe;

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

    @Override
    public List<Object> getModules(){
        return Arrays.<Object>asList(new SubscribeModule(this));
    }
}
