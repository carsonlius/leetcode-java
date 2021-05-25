package com.carsonlius.solution.list;

import com.carsonlius.solution.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树转成有序的双向链表
 * */
public class BinTreeToList {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        int data;
        public TreeNode(int data){
            this.data = data;
        }
    }

    public TreeNode solution(TreeNode head){
        // 使用队列存储中序遍历的各个节点
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        insertTreeNodeQueue(head, treeNodeQueue);

        // 依次弹出队列元素, left->pre right->next
        TreeNode newHead = treeNodeQueue.poll();
        TreeNode pre = newHead;
        pre.left = null;
        pre.right = null;
        while (!treeNodeQueue.isEmpty()) {
            TreeNode current = treeNodeQueue.poll();
            pre.right = current;
            current.left = pre;
            pre = current;
        }

        return newHead;
    }

    public void insertTreeNodeQueue(TreeNode node, Queue<TreeNode> treeNodeQueue){
        if (node == null) {
            return;
        }

        insertTreeNodeQueue(node.left, treeNodeQueue);
        treeNodeQueue.offer(node);
        insertTreeNodeQueue(node.right, treeNodeQueue);
    }

    public static void main(String[] args) {

    }

}
