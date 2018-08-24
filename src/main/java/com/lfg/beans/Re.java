package com.lfg.beans;

/**
 * @author fg.Li
 * 2018/5/30:17:10
 * <p>
 * Copyright@www.ppdai.com
 **/
public class Re {

    private static int x =40;

    private static int y;

    public Re(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static{
        x = 20;
        y=30;
    }

    public static int instance(Re a, Re b) {
        int tx = a.x - b.x;
        int ty = a.y - b.y;
        return tx + ty;
    }



    public static void main(String[] args) {
        Re s1 = new Re(10, 10);
        Re s2 = new Re(5, 5);
        //System.out.println(Re.instance(s1, s2));

        Long u = 6452353234L;
        System.out.println(u%100);
    }

}
