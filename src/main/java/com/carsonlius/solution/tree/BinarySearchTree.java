package com.carsonlius.solution.tree;

import com.carsonlius.solution.Node;
import com.sun.source.tree.Tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {
    TreeNode root;

    public boolean insert(int data) {
        TreeNode node = new TreeNode(data);
        // 树为空的时候
        if (root == null) {
            root = node;
            return true;
        }

        TreeNode current = root;
        while (current != null) {

            // 判断是否已经存在
            if (current.data == data) {
                return false;
            }

            //  判断想左边还是向右边，在转向后没有对应子节点 则依data生成对应的节点就行了
            if (current.data > data) {
                if (current.left == null) {
                    current.left = new TreeNode(data);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(data);
                    return true;
                }
                current = current.right;
            }
        }

        return true;
    }

    public TreeNode search(int data){
        //  判断极限情况
        if (root == null) {
            return null;
        }

        // 循环判断
        TreeNode current = root;
        while (current != null && current.data != data) {
            if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            System.out.println("没有找到" + data);
        } else {
            System.out.println("找到了" + data);
        }

        return  current;
    }

    public boolean delete(int data){
        //  判断是否有data存在
        if (root == null) {
            return false;
        }
        TreeNode targetNode = root;
        TreeNode targetParentNode = null;
        while (targetNode.data != data) {
            targetParentNode = targetNode;
            if (targetNode.data > data) {
                targetNode = targetNode.left;
            } else {
                targetNode = targetNode.right;
            }

            if (targetNode == null) {
                return false;
            }
        }

        //  没有子节点
        if (targetNode.left == null && targetNode.right == null) {
            // 被删除的是root节点
            if (targetNode == root) {
                root = null;
            } else {
                if (!isLeftNode(targetParentNode, targetNode)) {
                    targetParentNode.right = null;
                } else {
                    targetParentNode.left = null;
                }
            }

            return true;
        }

        //  只有一个子节点
        if (targetNode.left == null ){
            //  父节点是root节点
            if (isRoot(targetNode)) {
                root = targetNode.right;
            } else if(isLeftNode(targetParentNode,targetNode)) {
                targetParentNode.left = targetNode.right;
            } else {
                targetParentNode.right = targetNode.right;
            }
            return true;
        } else if(targetNode.right == null) {
            //  父节点是root节点
            if (isRoot(targetNode)) {
                root = targetNode.left;
            } else if(isLeftNode(targetParentNode,targetNode)) {
                targetParentNode.left = targetNode.left;
            } else {
                targetParentNode.right = targetNode.left;
            }
            return true;
        } else {
            // todo 包含2个子节点
            // 被替换的节点的父节点
            TreeNode replaceParentNode = targetNode;
            TreeNode replaceNode = targetNode.right;
            while (replaceNode.left != null) {
                replaceParentNode = replaceNode;
                replaceNode = replaceNode.left;
            }

            // 如果被删除的节点是root节点
//            if (isRoot(targetNode)) {
//                root = replaceNode;
//            }

            // 后继节点赋值
            targetNode.data = replaceNode.data;
            if (isLeftNode(replaceParentNode,replaceNode)) {
                replaceParentNode.left = replaceNode.right;
            } else {
                replaceParentNode.right = replaceNode.right;
            }
        }


        return true;
    }

    private boolean isLeftNode(TreeNode parent, TreeNode son){
        return parent != null &&  parent.left != null && parent.left == son;
    }

    private boolean isRoot(TreeNode node){
        return node!= null && root == node;
    }

    public static void main(String[] args) {
        System.out.println(2013-1996);
        int[] nodes = {5,2,3,4,5,4,1,8,9,6,111};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int node : nodes) {
            binarySearchTree.insert(node);
        }

        PrintTree printTree = new PrintTree();
        printTree.solution(binarySearchTree.root);

        System.out.println(binarySearchTree.search(4).data);
        binarySearchTree.delete(5);
        printTree.solution(binarySearchTree.root);

    }
}
