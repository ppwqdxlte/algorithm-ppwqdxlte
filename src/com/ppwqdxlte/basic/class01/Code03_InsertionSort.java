package com.ppwqdxlte.basic.class01;

import java.util.Arrays;

/**
 * @author:李罡毛
 * @date:2021/7/6 17:01
 * 插入排序，0 ~ 1范围排序
 *         0 ~ 2范围排序,下标2从上一次0~1已排顺序基础上，从后往头比较，直到插入合适位置
 *         ......
 *         0 ~ N-1范围排序，下标N-1从上一次0~N-2已排基础上，从后往头比较，直到插入合适位置
 */
public class Code03_InsertionSort {
    private static void insertionSort(int[] arr){
        if (arr == null || arr.length <2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j] >arr[j+1] ; j--) {
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        if (arr == null || i1 == i2 ||
                i1 >= arr.length || i2 >= arr.length) return;
        arr[i1] = arr[i1]^arr[i2];
        arr[i2] = arr[i1]^arr[i2];
        arr[i1] = arr[i1]^arr[i2];
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int testLoop = 500000;
        boolean isSuccess = true;
        for (int i = 0; i < testLoop; i++) {
            int[] arr1 = getRandomIntArray(maxSize,maxValue);
            int[] arr2 = getCopyOfIntArray(arr1);
            insertionSort(arr1);
            jdkArraySort(arr2);
            if (!isEqual(arr1,arr2)){
                isSuccess = false;
                printIntArray(arr1);
                printIntArray(arr2);
                break;
            }
        }
        System.out.println(isSuccess?"No problem!":"Failed!");
    }

    private static void printIntArray(int[] arr1) {
        if (arr1 == null) return;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] +"\t");
        }
        System.out.println();
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return true;
        if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) return false;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    private static void jdkArraySort(int[] arr2) {
        Arrays.sort(arr2);
    }

    private static int[] getCopyOfIntArray(int[] arr1) {
        if (arr1 == null) return null;
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    private static int[] getRandomIntArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
        }
        return arr;
    }

}
