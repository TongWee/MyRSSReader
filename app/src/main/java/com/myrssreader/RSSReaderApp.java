package com.myrssreader;

import android.app.Application;
import android.content.Context;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Tong on 2015/11/18.
 */
public class RSSReaderApp extends Application {

    ObjectGraph objectGraph;

    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();

        objectGraph = ObjectGraph.create(getModules().toArray());

        objectGraph.inject(this);

        super.onCreate();
    }

    /**
     *
     * @return List<Object> 返回AppModule对象列表
     */
    private List<Object> getModules(){
        return Arrays.<Object>asList(new AppModule(this));
    }

    /**
     *
     * @return Context
     */
    public static Context getContext(){
        return context;
    }

    /**
     * 建立指定域对象图表，用于不同的Activity
     * @param modules
     * @return ObjectGraph
     */
    public ObjectGraph createScopedGraph(Object... modules){
        return objectGraph.plus(modules);
    }
}
