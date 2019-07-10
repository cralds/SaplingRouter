package com.ds.sapling.routemanager;

import android.content.Context;
import android.os.Bundle;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
public interface IRouter {
    void navigation(Bundle bundle,String path, Context context);
    String getHost();
}
