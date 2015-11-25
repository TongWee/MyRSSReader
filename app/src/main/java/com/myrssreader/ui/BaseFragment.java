package com.myrssreader.ui;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;

import com.myrssreader.RSSReaderApp;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Tong on 2015/11/19.
 */
public abstract class BaseFragment extends Fragment {

    private ObjectGraph objectGraph;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        objectGraph = ((RSSReaderApp)activity.getApplication()).createScopedGraph(getModules().toArray());
        objectGraph.inject(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public abstract List<Object> getModules();
}
