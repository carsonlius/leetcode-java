package com.carsonlius.solution.tree;

import java.util.Stack;

/**
 * 先序列遍历
 *
 * */
public class TreePreLoop <T>{

    public void solution(TreeNode<T> head){
        if (head == null) {
            return;
        }

        System.out.println(head.data);
        solution(head.left);
        solution(head.right);
    }

    public void solution2(TreeNode<T> head){
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.add(head);

        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            System.out.println(current.data);
            if (current.right != null) {
                stack.add(current.right);
            }

            if (current.left != null) {
                stack.add(current.left);
            }
        }
    }

}
