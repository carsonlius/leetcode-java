package com.carsonlius.solution.tree;

import java.util.Stack;

/**
 * 二叉树后序遍历
 * */
public class PosOrder {


    public void solution(TreeNode head){
        if (head == null) {
            return;
        }
        solution(head.left);
        solution(head.right);
        System.out.println(head.data);
    }

    public void solution2(TreeNode head){
        //  考虑极端情况
        if (head == null) {
            return;
        }

        //  利用2个栈,先以中右左的顺序入栈A,然后出栈A进入栈B 在栈A为空时不断的弹出栈B的元素
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();

        //  头节点入栈A
        stackA.add(head);
        while (!stackA.isEmpty()) {
            TreeNode current = stackA.pop();

            //  弹出栈A栈顶节点进入栈B,左右节点入栈A
            stackB.add(current);

            if (current.left != null) {
                stackA.add(current.left);
            }

            if (current.right != null) {
                stackA.add(current.right);
            }
        }

        //  在栈A为空时 弹出栈B元素的顺讯就是需要的
        while (!stackB.isEmpty()) {
            TreeNode current = stackB.pop();
            System.out.println(current.data);
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

        PosOrder posOrder = new PosOrder();
        posOrder.solution(head);
        System.out.println("--------");
        posOrder.solution2(head);
    }
}
