package com.lfg.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifengguang on 2017/7/6.
 */
public class AnalyData {

    static String oldFilePath = "C:\\Users\\lifengguang\\Desktop\\b.txt";

     static String newFilePath = "C:\\Users\\lifengguang\\Desktop\\a.txt";

    static List<Object> list = new ArrayList<>();

    private static void compare(String oldPath,String newPath) throws Exception {
        FileReader fr = new FileReader(oldPath);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line =br.readLine()) != null) {
            FileReader nfr = new FileReader(newPath);
            BufferedReader nbr = new BufferedReader(nfr);
            String nline = null;
            boolean isEq = false;

            while ((nline = nbr.readLine()) != null) {
                if (line.equals(nline)) {
                    isEq = true;
                }
            }
            if (!isEq) {
                list.add(line);
            }


        }
        System.out.println(oldPath.substring(oldPath.indexOf(".txt")-3)+"有"+newPath.substring(newPath.indexOf(".txt")-3)+"没有："+list);
        list.clear();

    }

    public static void main(String[] args) throws Exception {
        /*AnalyData.compare(oldFilePath,newFilePath);
        AnalyData.compare(newFilePath,oldFilePath);*/
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

}
