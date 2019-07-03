package com.lfg.algorithm;

/**
 *快速排序算法
 * @author fg.Li
 * 2018/8/24:11:24
 * <p>
 *
 **/
public class QuickSort {

    /**
     * 快速排序算法,固定基准点
     *
     *
     */
    public static void quickSort(int[] list,int left,int right) {
        if (null == list || list.length <= 1 || left>right) {
            return;
        }
        int base = list[left],i=left,j=right;

        while (i < j) {
            while (i < j && list[j] >= base) {
                j--;
            }
            while (i < j && list[i] <= base) {
                i++;
            }
            if (i < j) {
                int temp = list[i];
                list[i] = list[j];
                list[j]=temp;
            }
        }
        list[left] = list[i];
        list[i] = base;
        quickSort(list,left,i-1);
        quickSort(list,i+1,right);

    }

    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.printf(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, -76, 13, 27, 50 };
        sort(a);


    }


}
