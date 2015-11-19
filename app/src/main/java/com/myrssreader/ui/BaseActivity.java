package com.myrssreader.ui;

import android.app.Activity;
import android.os.Bundle;
import com.myrssreader.RSSReaderApp;
import java.util.List;
import dagger.ObjectGraph;

/**
 * Created by Tong on 2015/11/19.
 */
public abstract class BaseActivity extends Activity{

    private ObjectGraph objectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建对象图表，并注入依赖关系
        objectGraph = ((RSSReaderApp)getApplication()).createScopedGraph(getModules().toArray());
        objectGraph.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，销毁对象图表
        objectGraph = null;
    }

    /**
     * 依赖倒置：
     * 由调用者（不同的Activity）通过实现抽象方法getModules()，传入各自对应的对象图表
     * 构造指定域对象图表
     * @return Module
     */
    protected abstract List<Object> getModules();
}