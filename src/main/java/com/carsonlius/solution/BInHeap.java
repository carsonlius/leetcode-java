package com.carsonlius.solution;

import java.util.Arrays;

public class BInHeap {
    /**
     * 向上调整
     * */
    public static void upAdjust(int[] array){
        // 最后一个作为索引
        int childIndex = array.length -1;
        int parentIndex = (childIndex -1)/2;

        int temp = array[childIndex];
        while (childIndex > 0 && array[parentIndex] > temp) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }

        array[childIndex] = temp;
    }

    /**
     * 下沉
     * */
    public static void downAdjust(int[] array, int parentIndex, int length){
        // 不断的跟子节点换值，在大于子节点最小值的时候
        int childIndex = 2*parentIndex +1;
        int temp = array[parentIndex];
        while (childIndex < length) {

            // childIndex是两个子节点中的比较小的值
            if (childIndex< length-1 && array[childIndex+1] < array[childIndex]) {
                childIndex++;
            }

            // 父节点比两个子节点都小 则跳出循环
            if (temp <= array[childIndex]){
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }

        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array){
        // 最后一个非叶子节点开始下沉
        int parentIndex = (array.length-2)/2;
        for (int i = parentIndex; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{11,3,2,6,5,7,8,9,10,4};
        upAdjust(array);
        System.out.println(Arrays.toString(
                array
        ));

        array = new int[]{7,1,3,10,5,2,8,9,6};
        int[] array2 = new int[]{10,9,8,7,5,6,2,3,1};
        buildHeap(array);
        buildHeap(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }


}
