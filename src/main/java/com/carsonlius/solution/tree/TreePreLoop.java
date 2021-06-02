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

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        head.left = left1;
        head.right = right1;

        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);

        left1.left = left2;
        left1.right = right2;

        TreePreLoop treePreLoop = new TreePreLoop();
        treePreLoop.solution(head);
        System.out.println("---");
        treePreLoop.solution2(head);

    }

}
