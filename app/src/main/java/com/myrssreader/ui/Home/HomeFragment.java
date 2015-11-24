package com.myrssreader.ui.Home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.myrssreader.R;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.presenter.HomeModule;
import com.myrssreader.presenter.HomePresenter;
import com.myrssreader.ui.BaseFragment;
import com.myrssreader.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomeFragment extends BaseFragment implements HomeView,OnItemClickListener {

    @Inject
    HomePresenter mHomePresenter;
    @Bind(R.id.home_recycler_view)
    RecyclerView _HomeRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity());
        _HomeRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        _HomeRecyclerView.setAdapter(homeAdapter);
        homeAdapter.addItem(initData());

        return rootView;
    }
    private List<FeedRespose> initData(){
        FeedRespose f1 = new FeedRespose();
        f1.setTitle("36氪");
        f1.setDescription("为创业者提供最好的产品和服务");
        FeedRespose f2 = new FeedRespose();
        f2.setTitle("廖雪峰的博客");
        f2.setDescription("技术大牛的博客");
        FeedRespose f3 = new FeedRespose();
        f3.setTitle("Tong的博客");
        f3.setDescription("记录学习科研工作中的点滴");
        List<FeedRespose> feedResposeList = new ArrayList<>();
        feedResposeList.add(f1);
        feedResposeList.add(f2);
        feedResposeList.add(f2);
        feedResposeList.add(f3);
        feedResposeList.add(f1);
        feedResposeList.add(f2);
        feedResposeList.add(f1);
        feedResposeList.add(f2);
        feedResposeList.add(f3);
        feedResposeList.add(f1);
        feedResposeList.add(f1);
        feedResposeList.add(f2);
        feedResposeList.add(f1);
        feedResposeList.add(f2);
        feedResposeList.add(f3);
        feedResposeList.add(f1);
        feedResposeList.add(f1);
        feedResposeList.add(f2);
        feedResposeList.add(f1);
        feedResposeList.add(f2);
        feedResposeList.add(f3);
        feedResposeList.add(f1);
        return feedResposeList;
    }
    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new HomeModule(this));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClickListener(View view, int position) {
        Toast.makeText(getActivity(),Integer.toString(position),Toast.LENGTH_SHORT).show();
    }
}
