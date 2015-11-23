package com.myrssreader.ui.Subscribe;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class SubscribeFragment extends BaseFragment implements SubscribeView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    SubscribePresenter mSubscribePresenter;
    @Bind(R.id.subscribe_recycler_view)
    RecyclerView _SubscribeRecyclerView;
    @Bind(R.id.subscribe_swipe_refresh_layout)
    SwipeRefreshLayout _SubscribeSwipeRefreshLayout;

    private SubscribeAdapter subscribeAdapter;
    private LinearLayoutManager linearLayoutManager;
    private boolean isFirstLoad = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subscribe, container, false);
        ButterKnife.bind(this, rootView);
        _SubscribeSwipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        _SubscribeSwipeRefreshLayout.setOnRefreshListener(this);

        subscribeAdapter = new SubscribeAdapter(getActivity());
        linearLayoutManager = new LinearLayoutManager(getActivity());
        _SubscribeRecyclerView.setLayoutManager(linearLayoutManager);
        _SubscribeRecyclerView.setAdapter(subscribeAdapter);

        mSubscribePresenter.firstTimeRefreshHomeItems();

        return rootView;
    }

    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new SubscribeModule(this));
    }

    @Override
    public void showRefresh() {
        _SubscribeSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                _SubscribeSwipeRefreshLayout.setRefreshing(true);
            }
        });
        //_SubscribeSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefresh() {

        _SubscribeSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMoreItems(List<FeedItem> feedItems) {
        subscribeAdapter.addItems(feedItems);
    }

    @Override
    public void refreshItems(List<FeedItem> feedItems) {
        mSubscribePresenter.refreshHomeItems();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        mSubscribePresenter.refreshHomeItems();
    }
}
