package com.carsonlius.solution;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array;
    private int size;
    public PriorityQueue() {
        this.array = new int[16];
    }

    private void resize() {
        int newSize = array.length * 2;
        array = Arrays.copyOf(array, newSize);
    }

    public void enQueue(int value){
        if (size >= array.length) {
            resize();
        }
        array[size++] = value;

        // 上浮
        upAdjust();
    }

    public void upAdjust(){
        int childIndex = size-1;
        int parentIndex = (childIndex-1)/2;
        System.out.println("upAdjust childIndex:" + childIndex + "parentIndex:" + parentIndex);
        int temp = array[childIndex];

        while (childIndex > 0) {
            if (array[parentIndex] >= temp) {
                break;
            }

            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }

        array[childIndex] = temp;
    }

    public int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("this queue is empty!");
        }
        int head = array[0];
        array[0] = array[size--];
// git config –global user.name “liusen”
        // 下沉
        downAdjust();

        return head;
    }
    public void downAdjust(){
        int parentIndex = 0;
        int childIndex = 1;
        int temp = array[parentIndex];
        while (childIndex < size) {
            // 寻找2个子节点中大值
            if (childIndex+1 < size && array[childIndex+1] > array[childIndex]) {
                childIndex++;
            }

            // 子节点小于父节点
            if (array[childIndex] <= temp){
                break;
            }

            // 交换位置
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2* parentIndex +1;
        }

        array[parentIndex] = temp;
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());


    }


}
