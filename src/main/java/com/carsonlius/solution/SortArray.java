package com.carsonlius.solution;

import java.util.Arrays;

public class SortArray {

    public void sort(int[] array) {
        // 记录最后一次交换的位置
        int lastSortIndex = array.length-1;
        int lastExchangeIndex = 0;

        for (int i = 0; i < array.length -1; i++) {
            // 标记是否排序结束
            boolean sortOver = true;

            for (int j = 0; j < lastSortIndex; j++) {
                if (array[j+1] < array[j]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                    // 发生了交换
                    sortOver = false;
                    lastExchangeIndex = j;
                }
            }

            if (sortOver) {
                break;
            }

            lastSortIndex = lastExchangeIndex;
        }
    }



    public void sort2(int[] array){

        // 控制轮数
        for (int i = 0; i < array.length/2; i++) {

            // 标记是否进行了排序
            boolean sorted = true;
            int temp = 0;

            //  从左向右
            for (int j = 0; j < array.length-1 -i; j++) {
                if (array[j+1] < array[j]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j]  = temp;

                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }

            sorted = true;

            //  从右向左
            for (int j = array.length-i-1; j> i; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }

        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};

        SortArray sortArray = new SortArray();
        sortArray.sort(array);
        System.out.println(Arrays.toString(array));


        array = new int[]{2,3,4,5,6,7,8,1};
        sortArray.sort2(array);
        System.out.println(Arrays.toString(array));
    }

}
