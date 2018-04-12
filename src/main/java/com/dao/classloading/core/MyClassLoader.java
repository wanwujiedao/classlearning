package com.dao.classloading.core;

import java.io.*;

/**
 * 自己写一个类加载器
 *
 * @author 阿导
 * @version 1.0
 * @fileName com.dao.classloading.core.MyClassLoader.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-04-12 11:40:00
 */
public class MyClassLoader extends ClassLoader {

    private String root;

    /**
     * 重写 findClass 方法
     *
     * @author 阿导
     * @time 2018/4/12
     * @CopyRight 万物皆导
     * @param name
     * @return java.lang.Class<?>
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //通过类路径，读取字节码文件
        byte[] classData = new byte[0];
        try {
            classData = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) throws IOException {
        //路径处理
        String fileName = root + File.separatorChar+ className.replace('.', File.separatorChar) + ".class";
        InputStream ins =null;
        try {
            //读取流，并写入 baos
             ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ins.close();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args)  {
        //声明类加载器
        MyClassLoader classLoader = new MyClassLoader();
        File directory = new File("");
        classLoader.setRoot(directory.getAbsolutePath()+"/target/classes");

        Class<?> testClass = null;
        try {
            testClass = classLoader.loadClass("com.dao.classloading.other.Dao");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
