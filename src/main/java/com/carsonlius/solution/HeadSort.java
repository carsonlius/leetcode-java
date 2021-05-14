package com.carsonlius.solution;

import java.util.Arrays;

public class HeadSort {

    private static void downAdjust(int[] array, int fatherIndex, int length) {
        // 循环
        int temp = array[fatherIndex];
        int childIndex = fatherIndex * 2 + 1;

        while (childIndex < length) {
            // 取子结点中大的值
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            // 不需要下沉
            if (temp >= array[childIndex]) {
                break;
            }

            array[fatherIndex] = array[childIndex];
            fatherIndex = childIndex;
            childIndex = 2 * fatherIndex + 1;
        }

        array[fatherIndex] = temp;
    }


    public static void sort(int[] array) {
        // 构建堆
        int firstFather = (array.length - 1) / 2;
        for (int i = firstFather; i >= 0; i--) {
            // 下沉
            downAdjust(array, i, array.length);
        }

        System.out.println("构建的堆" + Arrays.toString(array));
        // 循环删除堆顶
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // 重新构建堆,下沉
            downAdjust(array, 0, i);
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
