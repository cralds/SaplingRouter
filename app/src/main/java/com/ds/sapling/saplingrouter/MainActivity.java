package com.ds.sapling.saplingrouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ds.sapling.routemanager.RouteManager;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tvLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouteManager.getInstance().navigation("login/login");
            }
        });
        findViewById(R.id.tvRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouteManager.getInstance().navigation("login/register");
            }
        });
        findViewById(R.id.tvMine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/mine/mine")
                        .withString("userName","cral")
                        .navigation();
            }
        });

    }
}
