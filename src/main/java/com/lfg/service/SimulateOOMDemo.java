package com.lfg.service;

/**
 * @author fg.Li
 * 2019/3/27:17:02
 * <p>
 **/
public class SimulateOOMDemo {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        long i = 1,j=10;
        while (i<100000000L) {
            j=j%i;
            i++;
        }
        System.out.println("耗时："+(System.currentTimeMillis()-start));

        i = 0;j=0;
        long startAgain = System.currentTimeMillis();

        while (i < 100000000L) {
            j=j<<1;
            i++;
        }

        System.out.println("耗时2："+(System.currentTimeMillis()-startAgain));
    }
}
