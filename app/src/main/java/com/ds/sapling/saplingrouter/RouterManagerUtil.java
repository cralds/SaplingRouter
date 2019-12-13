package com.ds.sapling.saplingrouter;

import android.content.Context;

import com.alibaba.android.arouter.utils.ClassUtils;
import com.ds.sapling.routemanager.IRouter;
import com.ds.sapling.routemanager.RouteManager;

import java.util.Set;

/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
public class RouterManagerUtil {
    public static void init(Context context){
        RouteManager.getInstance().init(context);
        String pkgName = "com.ds.sapling.router";
        Set<String> classNames = null;
        try {
            classNames = ClassUtils.getFileNameByPackageName(context,pkgName);
            if (classNames == null || classNames.size() == 0){
                return;
            }
            for (String name : classNames){
                Class cl = Class.forName(name);
                IRouter iRouter = (IRouter) cl.newInstance();
                RouteManager.getInstance().registerHost(iRouter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
