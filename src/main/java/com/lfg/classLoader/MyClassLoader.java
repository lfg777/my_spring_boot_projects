package com.lfg.classLoader;

/**
 * Created by lifengguang on 2018/1/12.
 */
public class MyClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = super.findLoadedClass(name);

        if (clazz == null) {


        }
        return clazz;
    }
}
