package com.carsonlius.solution;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] array, int startIndex, int endIndex) {
        // 递归基
        if (startIndex >= endIndex) {
            return;
        }

        // 基准索引
        int partition = partition2(array, startIndex, endIndex);
//        int partition = partition(array, startIndex, endIndex);
        sort(array, startIndex, partition - 1);
        sort(array, partition + 1, endIndex);

    }

    private int partition(int[] array, int startIndex, int endIndex) {
        // 双指针循环
        // 随机选择基准
        int partition = array[startIndex];

        // 左右指针
        int left = startIndex;
        int right = endIndex;

        // 双循环
        while (left < right) {

            while (left < right && array[right] > partition) {
                right--;
            }

            while (left < right && array[left] <= partition) {
                left++;
            }


            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

//        if (array[left] < partition) {
        array[startIndex] = array[left];
        array[left] = partition;
//        }


        return left;
    }

    private int partition2(int[] array, int startIndex, int endIndex) {
        // mark指针左边都是小于基准的数值
        int mark = startIndex;

        // 基准
        int partition = array[startIndex];

        for (int i = startIndex+1; i <= endIndex; i++) {
            if (array[i] < partition) {
                mark++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = partition;
        return mark;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        System.out.println(Arrays.toString(array));

        quickSort.sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

}
