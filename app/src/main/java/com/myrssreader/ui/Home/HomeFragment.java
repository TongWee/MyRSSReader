package com.myrssreader.ui.Home;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.myrssreader.R;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.presenter.HomeModule;
import com.myrssreader.presenter.HomePresenter;
import com.myrssreader.ui.BaseFragment;
import com.myrssreader.ui.OnItemClickListener;
import com.myrssreader.ui.OnTurntoSubscribeFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Tong on 2015/11/18.
 */
public class HomeFragment extends BaseFragment implements HomeView, OnItemClickListener {

    @Inject
    HomePresenter mHomePresenter;
    @Bind(R.id.home_recycler_view)
    RecyclerView _HomeRecyclerView;
    @Bind(R.id.home_fab)
    FloatingActionButton _HomeFab;

    OnTurntoSubscribeFragment  onTurntoSubscribeFragment;

    public void setOnTurntoSubscribeFragment(OnTurntoSubscribeFragment onTurntoSubscribeFragment){
        this.onTurntoSubscribeFragment = onTurntoSubscribeFragment;
    }
    private HomeAdapter homeAdapter;
    MaterialDialog mMaterialDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        homeAdapter = new HomeAdapter(getActivity());
        _HomeRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        _HomeRecyclerView.setAdapter(homeAdapter);

        mHomePresenter.firstLoadSubscribeList();
        //homeAdapter.addItems(initData());

        homeAdapter.setOnItemClickListener(this);

        _HomeFab.attachToRecyclerView(_HomeRecyclerView);
        _HomeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Click Fab", Toast.LENGTH_SHORT).show();
                mMaterialDialog.show();
            }
        });
        final EditText editText = new EditText(getActivity());
        editText.setSingleLine(true);
        TextInputLayout textInputLayout = new TextInputLayout(getActivity());
        textInputLayout.addView(editText);
        textInputLayout.setHintAnimationEnabled(true);
        textInputLayout.setHint("添加订阅");
        mMaterialDialog = new MaterialDialog(getActivity()).setContentView(textInputLayout)
                .setPositiveButton("确 认", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String link = editText.getText().toString();
                        mHomePresenter.addSubscribe(link);
                        mMaterialDialog.dismiss();
                        editText.clearFocus();
                    }
                })
                .setNegativeButton("取 消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                        editText.clearFocus();
                    }
                });

        return rootView;
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
        FeedRespose feedRespose = homeAdapter.getFeedList(position);




//        Toast.makeText(getActivity(), feedRespose.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void firstLoadSubscribe(List<FeedRespose> feedResposeList) {
        homeAdapter.addItems(feedResposeList);
    }

    @Override
    public void addSubscribe(FeedRespose feedRespose) {
        homeAdapter.addItem(feedRespose);
    }
}
