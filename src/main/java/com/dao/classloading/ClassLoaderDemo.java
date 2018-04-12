package com.dao.classloading;

import com.dao.classloading.other.HelloWorld;

/**
 * 类加载器示例
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.classloading.ClassLoaderDemo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-12 11:20:00
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行静态初始化块
        System.out.println("使用ClassLoader.loadClass()来加载类，不会执行静态初始化块+++");
        String classPath="com.dao.classloading.other.Dao";
        loader.loadClass(classPath);
        //使用Class.forName()来加载类，默认会执行初始化块
        System.out.print("使用Class.forName()来加载类，默认会执行初始化块+++");
        Class.forName(classPath);
        //使用 Class.forName() 来加载类，并指定 ClassLoader，初始化时不执行静态块
        System.out.println("使用 Class.forName() 来加载类，并指定 ClassLoader，初始化时不执行静态块+++");
        Class.forName(classPath, false, loader);
    }
}
