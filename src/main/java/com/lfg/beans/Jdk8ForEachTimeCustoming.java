package com.lfg.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifengguang on 2017/5/11.
 */
public class Jdk8ForEachTimeCustoming {

    public static void main(String[] args) {
            List<String> list=new ArrayList<String>();
            for(int i=0;i<100000;i++){
                list.add("a");
            }
            long a=System.currentTimeMillis();
            for(String action:list){
                if(action==null){
                    //什么都不干，就判断一下而已
                }
            }
            long b=System.currentTimeMillis();
            System.out.println(b-a);//传统的foreach时间1
            list.stream().forEach(action->{
                if(action==null){
                    //什么都不干，就判断一下而已
                }
            });

            long c=System.currentTimeMillis();
            System.out.println(c-b);//JDK8的时间2
        }
}
