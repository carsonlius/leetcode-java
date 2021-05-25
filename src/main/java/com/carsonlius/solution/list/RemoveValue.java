package com.carsonlius.solution.list;

import com.carsonlius.solution.Node;

/**
 * 单链表中删除指定值的节点
 * */
public class RemoveValue {

    public Node solution(Node head, int num){
        if (head == null) {
            return null;
        }

        //  寻找新head，第一个不等于num的节点
        Node newHead = null;
        while (head != null) {
            if (head.data != num) {
                newHead = head;
                break;
            }
            head = head.next;
        }

        if (newHead == null) {
            return null;
        }

        //  删除新头节点之后的所有等于num的节点
        Node pre = newHead;
        Node current = newHead.next;
        while (current != null) {
            if (current.data == num) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }

        // 返回新节点
        return newHead;
    }


    public static void main(String[] args) {
        int[] nodes = {2,3,4};
        Node head = new Node(1);
        Node current = head;
        Node next = null;
        for (int node : nodes) {
            next = new Node(node);
            current.next = next;
            current  = next;
        }

        RemoveValue removeValue = new RemoveValue();
        removeValue.printNode(head);

        Node newHead = removeValue.solution(head, 3);
        removeValue.printNode(newHead);
    }


    private void printNode(Node node){
        Node current = node;
        while (current != null) {
            System.out.print("-->" + current.data);
            current = current.next;
        }

        System.out.println("");

    }

}
