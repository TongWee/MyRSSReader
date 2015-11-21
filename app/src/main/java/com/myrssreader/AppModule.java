package com.myrssreader;

import com.myrssreader.interactor.InteractorsModule;

import dagger.Module;

/**
 * Created by Tong on 2015/11/18.
 */
@Module(
    includes = {
            InteractorsModule.class
    },
    injects = {
            RSSReaderApp.class
    },
        library = true
)
/*
* 项目依赖关系图的根节点
* */
public class AppModule {
    private RSSReaderApp app;
    public AppModule(RSSReaderApp _app){this.app = _app;}
}
