package com.ds.sapling.routemanager;

import android.content.Context;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
public class RouteManager {
    private static volatile RouteManager instance;

    Map<String,IRouter> map = new HashMap<>();
    private Context context;

    public void init(Context context){
        this.context = context;
    }

    public static RouteManager getInstance(){
        if (instance == null){
            synchronized (RouteManager.class){
                instance = new RouteManager();
            }
        }
        return instance;
    }



    public void registerHost(IRouter iRouter){
        map.put(iRouter.getHost(),iRouter);
    }

    public void navigation(String path){
        navigation(path,null);
    }
    public void navigation(String path, Bundle bundle){
        String host = path.split("/")[0];
        IRouter iRouter = map.get(host);
        if (iRouter == null){
            return;
        }
        iRouter.navigation(bundle,path,context);
    }
}
