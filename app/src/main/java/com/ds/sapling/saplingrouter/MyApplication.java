package com.ds.sapling.saplingrouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
        ARouter.openDebug();
        ARouter.openLog();
        RouterManagerUtil.init(this);
    }
}
