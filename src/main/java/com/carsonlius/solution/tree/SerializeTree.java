package com.carsonlius.solution.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将一颗二叉树序列化和反序列化
 * */
public class SerializeTree {

    public String serialize(TreeNode head){
        //  通过先序遍历,获取各个节点的数值, 空节点值记录为#,正常节点正常记录，在值后面添加!作为分隔符
        if (head == null) {
            return "#!";
        }

        String serializeString = head.data + "!";
        serializeString += serialize(head.left);
        serializeString += serialize(head.right);
        return serializeString;
    }


    public TreeNode unSerialize(String serializeString){
        //  将各个节点的数值放入队列
        String[] values = serializeString.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.offer(value);
        }

        //  通过先序遍历,构建一颗二叉树
        return buildTreeByPreOrder(queue);
    }

    private TreeNode buildTreeByPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = buildTreeByPreOrder(queue);
        node.right = buildTreeByPreOrder(queue);

        return node;
    }

    private String serializeByLevel(TreeNode head){
        // 层次遍历序列化
        if (head == null) {
            return "#!";
        }

        StringBuilder serialString = new StringBuilder(head.data + "!");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            serialString.append(current.data + "!");
            if (current.left == null) {
                serialString.append("#!");
            } else {
                queue.offer(current.left);
            }

            if (current.right == null) {
                serialString.append("#!");
            } else {
                queue.offer(current.right);
            }
        }

        return serialString.toString();
    }

    private TreeNode unSerializeByLevel(String serialString){
        // 转成数组
        String[] nodes = serialString.split("!");

        // todo 遍历数组



    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(12);
        TreeNode left = new TreeNode(3);
        head.left = left;
        SerializeTree serializeTree = new SerializeTree();
        String serializeString = serializeTree.serialize(head);
        System.out.println("序列化:" + serializeString);
        TreeNode newHead = serializeTree.unSerialize(serializeString);

        PrintTree printTree = new PrintTree();
        printTree.solution(head);

    }
}
