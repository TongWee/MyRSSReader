package com.myrssreader.ui.Subscribe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myrssreader.R;
import com.myrssreader.bean.FeedItem;
import com.myrssreader.presenter.SubscribeModule;
import com.myrssreader.presenter.SubscribePresenter;
import com.myrssreader.ui.BaseFragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class SubscribeFragment extends BaseFragment implements SubscribeView {

    @Inject
    SubscribePresenter mSubscribePresenter;
    @Bind(R.id.subscribe_recycler_view)
    RecyclerView _SubscribeRecyclerView;
    @Bind(R.id.subscribe_swipe_refresh_layout)
    SwipeRefreshLayout _SubscribeSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subscribe, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new SubscribeModule(this));
    }

    @Override
    public void showRefresh() {
        _SubscribeSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefresh() {
        _SubscribeSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMoreItems(List<FeedItem> feedItems) {

    }

    @Override
    public void refreshItems(List<FeedItem> feedItems) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
