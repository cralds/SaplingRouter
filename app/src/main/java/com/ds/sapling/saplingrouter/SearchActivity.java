package com.ds.sapling.saplingrouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ds.sapling.annotation.SaplingRoute;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
@SaplingRoute("main/search")
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
