package com.myrssreader.ui.Stared;
import com.myrssreader.presenter.StaredModule;
import com.myrssreader.presenter.StaredPresenter;
import com.myrssreader.ui.BaseFragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tong on 2015/11/18.
 */
public class StaredFragment extends BaseFragment implements StaredView {

    @Inject
    StaredPresenter mStaredPresenter;

    @Override
    public List<Object> getModules(){
        return Arrays.<Object>asList(new StaredModule(this));
    }
}
