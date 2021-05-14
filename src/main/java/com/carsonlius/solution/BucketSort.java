package com.carsonlius.solution;

import java.util.*;

public class BucketSort {
    public double[] sort(double[] array) {
        // 获取最大值和最小值，计算桶间距
        double max = 0;
        double min = 0;
        for (double v : array) {
            if (v > max) {
                max = v;
            }

            if (min > v) {
                min = v;
            }
        }

        double d = max-min;
        int bucketLength = array.length;

        //  初始化桶
        List<LinkedList<Double>> listBuckets = new ArrayList<>();
        for (int i = 0; i < bucketLength; i++) {
            listBuckets.add(new LinkedList<>());
        }

        // 桶中添加元素
        double rangeLength = d/(bucketLength-1);
        for (double v : array) {
            int index = (int)((v-min)/rangeLength);
            listBuckets.get(index).add(v);
        }

        // 桶中元素排序
        for (LinkedList<Double> listBucket : listBuckets) {
            Collections.sort(listBucket);
        }

        //  遍历输出元素
        double[] sortArray = new double[array.length];
        int index =0;
        for (LinkedList<Double> listBucket : listBuckets) {
            for (Double aDouble : listBucket) {
                sortArray[index++] = aDouble;
            }
        }
        return sortArray;
    }

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortedArray = bucketSort.sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}