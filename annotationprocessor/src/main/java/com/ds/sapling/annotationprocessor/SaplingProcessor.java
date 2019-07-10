package com.ds.sapling.annotationprocessor;

import com.ds.sapling.annotation.SaplingRoute;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
/**
 *  作者 cral
 *  创建日期 2019/6/27
 **/
@AutoService(Processor.class)
public class SaplingProcessor extends AbstractProcessor {
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new LinkedHashSet<>();
        set.add(SaplingRoute.class.getCanonicalName());
        return set;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("============= process ====================");
        if (set == null || set.isEmpty()){
            return false;
        }
        Set<? extends Element> pathSet = roundEnvironment.getElementsAnnotatedWith(SaplingRoute.class);
        System.out.println("pathset.size() ============="+pathSet.size());
        Element element = pathSet.iterator().next();
        SaplingRoute saplingRoute = element.getAnnotation(SaplingRoute.class);
        String path = saplingRoute.value();
        String host = path.split("/")[0];

        ClassName typeClassName = ClassName.get((TypeElement) element);

        System.out.println("element.getSimpleName ============="+element.getSimpleName());
        System.out.println("typeClassName ============="+typeClassName.simpleName());
        ClassName targetClassName = ClassName.get("com.ds.sapling.router",typeClassName.simpleName()+"$"+host+"$IRouter");

        //注册方法
        MethodSpec.Builder build = MethodSpec.constructorBuilder()
                .addStatement("super()")
                .addModifiers(Modifier.PUBLIC);
        for (Element e : pathSet){
            SaplingRoute route = e.getAnnotation(SaplingRoute.class);
            build.addStatement("registerPath($S,$T.class)",route.value(),ClassName.get((TypeElement) e));
        }
        MethodSpec methodSpec = build.build();
        //获取host方法
        MethodSpec methodHost = MethodSpec.methodBuilder("getHost")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addStatement("return $S",host)
                .build();

        //创建类
        TypeSpec typeSpec = TypeSpec.classBuilder(targetClassName)
                .superclass(ClassName.get("com.ds.sapling.routemanager","BaseRouter"))
                .addMethod(methodSpec)
                .addMethod(methodHost)
                .addModifiers(Modifier.PUBLIC)
                .build();

        JavaFile javaFile = JavaFile.builder(targetClassName.packageName(),typeSpec).build();
        try {
            javaFile.writeTo(processingEnv.getFiler());
            System.out.println("============= success ====================");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("============= fail ====================" + e.getMessage());
        }

        return false;
    }
}
