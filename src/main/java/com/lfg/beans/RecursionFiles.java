package com.lfg.beans;

import java.io.File;

/**
 * 递归查找文件夹下所有文件
 * @author fg.Li
 * 2018/11/2:13:36
 * <p>
 **/
public class RecursionFiles {

    private final static String path ="D:\\test";

    private static void findFiles(String path) {
        File  file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File subFile : files) {
                    findFiles(subFile.getPath());
                }
            }

        }
        System.out.println(file.getName());

    }



    public static void main(String[] args) {
        findFiles(path);
    }
}
