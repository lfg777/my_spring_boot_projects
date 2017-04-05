package com.lfg.beans;

import java.io.PrintStream;

/**
 * Created by lifengguang on 2017/2/10.
 */
public class TTT {

    public static void main(String[] args) {
        int a=10;
        int b=20;
        method1(a,b);
        System.out.println("a="+a);
        System.out.println("b="+b);

    }

    public static void method1(int a, int b){
        PrintStream printStream = new PrintStream(System.out){
            @Override
            public void println(String x) {
                if ("a=10".equals(x)) {
                    x = "a=100";
                }else{
                    x = "b=200";
                }
                super.println(x);

            }
        };
        System.setOut(printStream);
    }

}
