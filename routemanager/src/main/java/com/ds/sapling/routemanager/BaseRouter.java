package com.ds.sapling.routemanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
public abstract class BaseRouter implements IRouter {
    private Map<String,Class> map;

    public BaseRouter(){
        map = new HashMap<>();
    }

    @Override
    public void navigation(Bundle bundle, String path, Context context) {
        Class cls = map.get(path);
        if (cls == null){
            Log.d("BaseRouter","no class matched");
            return;
        }
        Intent intent = new Intent(context,cls);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void registerPath(String path,Class cls){
        map.put(path,cls);
    }

}
