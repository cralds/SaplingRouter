package com.sapling.mallmodule;

import com.ds.sapling.routemanager.Animal;
import com.google.auto.service.AutoService;

/**
 * create by cral
 * create at 2020/5/7
 **/
@AutoService(Animal.class)
public class Dog implements Animal {
    @Override
    public int getLegs() {
        return 4;
    }
}
