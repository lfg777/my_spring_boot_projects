package com.lfg.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * @author fg.Li
 * 2018/11/2:10:52
 * <p>
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] list = new int[]{10, 3, 5, 11, 24, 15, 23, 18};
        System.out.println("dddd");
        System.out.println("dddd");
        bubbleSort(list);


    }

    private static void bubbleSort(int[] list) {

        for (int i = 0; i < list.length-1; i++) {
            for (int j = 0; j < list.length-i-1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }
}
