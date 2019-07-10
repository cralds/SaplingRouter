package com.ds.sapling.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
@Retention(value = RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface SaplingRoute {
    String value();
}
