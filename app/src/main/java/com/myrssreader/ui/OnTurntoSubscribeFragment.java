package com.myrssreader.ui;

/**
 * Created by Tong on 2015/11/24.
 */
public interface OnTurntoSubscribeFragment {
    void onGetFeed(String title, String link);

    void setBackEnable(boolean isEnable);
}
