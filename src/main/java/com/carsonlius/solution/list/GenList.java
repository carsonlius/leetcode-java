package com.carsonlius.solution.list;

import com.carsonlius.solution.HeadSort;
import com.carsonlius.solution.Node;

/**
 * 生成链表
 * */
public class GenList {

    /*
    * 普通的单链表
    * */
    public Node getNormalList(int[] nodes){
        Node head = null;
        Node current = null;
        for (int node : nodes) {
            if (head == null) {
                head = new Node(node);
                current = head;
            } else {
                Node next = new Node(node);
                current.next = next;
                current = next;
            }
        }
        return head;
    }

    public void printNode(Node node){
        Node current = node.next;
        System.out.print(node.data);
        while (current != null) {
            System.out.print("-->" + current.data);
            current = current.next;
        }

        System.out.println("");
    }
}
