package com.carsonlius.solution.tree;

import java.util.Stack;

public class TreeMiddleLoop {

    public void solution(TreeNode head){
        if (head == null) {
            return ;
        }

        solution(head.left);
        System.out.println(head.data);
        solution(head.right);
    }

    public void solution2(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.data);
                head = head.right;
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

        TreeMiddleLoop treeMiddleLoop = new TreeMiddleLoop();
        treeMiddleLoop.solution(head);
        System.out.println("-----");
        treeMiddleLoop.solution2(head);
    }
}
