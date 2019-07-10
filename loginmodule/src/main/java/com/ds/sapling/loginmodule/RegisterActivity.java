package com.ds.sapling.loginmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ds.sapling.annotation.SaplingRoute;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
@SaplingRoute("login/register")
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
