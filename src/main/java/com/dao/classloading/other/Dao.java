package com.dao.classloading.other;

/**
 * 测试类的加载
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.classloading.other.Dao.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-12 11:22:00
 */
public class Dao {
    static {
        System.out.println("静态块：万物皆导");
    }
}
