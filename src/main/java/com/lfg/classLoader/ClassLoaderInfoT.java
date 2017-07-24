package com.lfg.classLoader;

import java.io.*;
import java.util.*;

/**
 * Created by lifengguang on 2017/7/18.
 */
public class ClassLoaderInfoT {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前类加载器：" + loader);
        System.out.println("当前类的父亲加载器（根加载器）：" + loader.getParent());
        System.out.println("当前类父亲的父亲加载器（无）：" + loader.getParent().getParent());*/

        Map<String,Object> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("4", "4");
        map2.put("2", "2");
        map2.put("3", "3");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("5", "4");
        map3.put("2", "2");
        map3.put("3", "3");

        ArrayList<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);
        list.add(map3);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
       /* List<Map<String, Object>> sub = list.subList(0, 1);
        List<Map<String, Object>> target = new ArrayList<>();
        for (int i=0;i<sub.size();i++) {
            target.add((HashMap<String,Object>)((HashMap<String,Object>) sub.get(i)).clone());
        }
        //target.addAll(sub);
        //list.removeAll(target);
        target.get(0).put("1", false);
        System.out.println(list);
        System.out.println(target);
        System.out.println(sub);*/
        List<Map<String, Object>> target = new ArrayList<>();
        target.addAll(list.subList(0, 1));
        List<Map<String, Object>> subList = deepCopy(target);
        System.out.println(subList);
        subList.get(0).put("1", false);
        System.out.println(subList);
        System.out.println(target);
        System.out.println(list);
        System.out.println(-2%10);


    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }
}
