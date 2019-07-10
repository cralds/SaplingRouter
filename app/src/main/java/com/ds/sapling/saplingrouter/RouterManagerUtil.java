package com.ds.sapling.saplingrouter;

import android.content.Context;

import com.ds.sapling.routemanager.RouteManager;
import com.ds.sapling.router.RegisterActivity$login$IRouter;
import com.ds.sapling.router.SearchActivity$main$IRouter;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
public class RouterManagerUtil {
    public static void init(Context context){
        RouteManager.getInstance().init(context);

        RouteManager.getInstance().registerHost(new RegisterActivity$login$IRouter());
        RouteManager.getInstance().registerHost(new SearchActivity$main$IRouter());
    }
}
