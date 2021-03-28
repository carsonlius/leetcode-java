package com.carsonlius.solution;


import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;


        public TreeNode(Integer data) {
            this.data = data;
        }
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        // 递归基
        if (inputList == null || inputList.size() == 0) {
            return null;
        }

        Integer data = inputList.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraveral(TreeNode node){
        if (node == null) {
            return;
        }
        System.out.println(node.data);

        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(3, 2, 9,
                null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(linkedList);
        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println("后序遍历");
    }

}
