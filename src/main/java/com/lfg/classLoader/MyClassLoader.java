package com.lfg.classLoader;

import java.io.*;

/**
 * Created by lifengguang on 2018/1/12.
 */
public class MyClassLoader extends ClassLoader {

    private String path = "C:\\Users\\lifengguang\\Desktop\\";

    public MyClassLoader(String path) {
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent,String path) {
        super(parent);
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = super.findLoadedClass(name);

        if (clazz == null) {
            try {
                byte[] bytes = loadClassData(name);
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return clazz;
    }

    private byte[] loadClassData(String name) throws IOException {
        try {
            name = name.replace(".", "//");
            FileInputStream in = new FileInputStream(new File(path+name+".class"));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int b;
            while ((b = in.read())!= -1) {
                out.write(b);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
