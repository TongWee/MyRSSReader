package com.myrssreader.presenter;

import android.view.View;

/**
 * Created by Tong on 2015/11/18.
 */
public interface SubscribePresenter {

    void firstTimeRefreshHomeItems();

    void refreshHomeItems();

    void loadMoreHomeItems();

    void onItemClicked(View v, int position);
}
