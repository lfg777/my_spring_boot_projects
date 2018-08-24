package com.lfg.beans;

/**
 *快速排序算法
 * @author fg.Li
 * 2018/8/24:11:24
 * <p>
 * Copyright@www.ppdai.com
 **/
public class QuickSort {

    /**
     * 快速排序算法,固定基准点
     * @param list
     * @param left
     * @param right
     */
    public void quickSort(int[] list,int left,int right) {
        if (null == list || list.length <= 1) {
            return;
        }
        int base = list[0],begin=left,end=right;






        while (begin < end && list[end] <= base) {
            while (begin < end && list[begin] >= base) {
                int temp = list[begin];
                list[begin] = list[end];
                list[end] = temp;
            }
        }





    }


}
