package com.dao.classloading;

/**
 * 类加载示例
 *
 * @author 阿导
 * @version 1.0
 * @fileName PACKAGE_NAME.com.dao.classloading.ClassLoadDemo.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-12 10:51:00
 */
public class ClassLoadDemo {

    public static void main(String[] args){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
