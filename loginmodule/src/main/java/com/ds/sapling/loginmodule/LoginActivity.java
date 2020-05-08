package com.ds.sapling.loginmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ds.sapling.annotation.SaplingRoute;
import com.ds.sapling.routemanager.Animal;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
@SaplingRoute("login/login")
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        Iterator<Animal> iterator = serviceLoader.iterator();
        if (iterator!=null && iterator.hasNext()){
            Animal animal = iterator.next();
            Log.d("sssssssssssssssss",""+animal.getLegs());
        }
    }
}
