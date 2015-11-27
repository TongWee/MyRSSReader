package com.myrssreader.util;

import com.myrssreader.RSSReaderApp;

/**
 * Created by Tong on 2015/11/20.
 */
public class ResourceHelper {

    public static String getResourceString(int rId) {
        return RSSReaderApp.getContext().getResources().getString(rId);
    }

    public static String[] getResourceStringArr(int rId) {
        return RSSReaderApp.getContext().getResources().getStringArray(rId);
    }

}
