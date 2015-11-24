package com.myrssreader.ui.Home;


import com.myrssreader.bean.FeedRespose;

import java.util.List;

/**
 * Created by Tong on 2015/11/18.
 */
public interface HomeView {
    void firstLoadSubscribe(List<FeedRespose> feedResposeList);
    void addSubscribe(FeedRespose feedRespose);
}
