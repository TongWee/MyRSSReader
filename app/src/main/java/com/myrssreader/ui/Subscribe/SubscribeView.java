package com.myrssreader.ui.Subscribe;

import com.myrssreader.bean.FeedItem;

import java.util.List;

/**
 * Created by Tong on 2015/11/18.
 */
public interface SubscribeView {
    void showRefresh();
    void hideRefresh();
    void loadMoreItems(List<FeedItem> feedItems);
    void refreshItems(List<FeedItem> feedItems);
}
