package com.carsonlius.solution;


import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> minStack = new LinkedList<>();
    LinkedList<Integer> mainStack = new LinkedList<>();

    public void push(Integer value){
        // 小于等于当前最小值 则进入最小值栈
        if (minStack.isEmpty() || minStack.getFirst() >= value) {
            minStack.addFirst(value);
        }
        mainStack.addFirst(value);
    }

    public Integer pop() throws Exception {
        if (mainStack.isEmpty()) {
            throw new Exception("Stack is empty");
        }

        // 当前推出的是最小值 则最小值栈也出栈
        if (mainStack.getFirst().equals(minStack.getFirst())) {
            minStack.removeFirst();
        }

        return mainStack.removeFirst();
    }

    public Integer getMinValue() throws Exception {
        if (minStack.isEmpty()) {
            throw new Exception("Stack is empty");
        }

        return minStack.getFirst();
    }

    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(9);
        minStack.push(7);
        minStack.push(3);
        minStack.push(8);
        minStack.push(5);
        System.out.println(minStack.getMinValue());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMinValue());
    }
}
