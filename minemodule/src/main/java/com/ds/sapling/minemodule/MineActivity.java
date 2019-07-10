package com.ds.sapling.minemodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
@Route(path = "/mine/mine")
public class MineActivity extends AppCompatActivity {
    @Autowired
    public String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ARouter.getInstance().inject(this);
        TextView tvName = findViewById(R.id.mine_tvName);
        tvName.setText(String.format("my name is %1$s",userName+""));
    }
}
