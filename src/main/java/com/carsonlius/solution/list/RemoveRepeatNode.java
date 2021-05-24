package com.carsonlius.solution.list;

import com.carsonlius.solution.Node;

import java.util.HashSet;
import java.util.Set;

/*
* 删除无序链表中重复出现的点
* */
public class RemoveRepeatNode {
    public void solution(Node head){

        // 利用set判断是否已经出现过了，用来存储Node.data
        Set<Integer> integerSet = new HashSet<>();

        Node current = head.next;
        Node pre = head;
        integerSet.add(head.data);
        while (current != null) {
            // 存在，删除当前节点
            if (integerSet.contains(current.data)) {
                pre.next = current.next;
            } else  {
                pre = current;
                integerSet.add(current.data);
            }

            // 移动到下一个节点
            current = current.next;
        }
    }

    public void solution2(Node head){
        if (head == null || head.next == null) {
            return;
        }

        // 类似于选择排序算法
        // todo 循环链表，删除当前值之后的重复值
        Node current = head;
        Node pre = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            pre = current;
            while (next != null) {
                // 删除和当前节点重复的值
                if (next.data == current.data) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }

            current = current.next;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2,3,3,4,4,2,1,1};
        Node head = new Node(1);
        Node current = head;
        for (int anInt : ints) {
            Node next = new Node(anInt);
            current.next = next;
            current = next;
        }

        RemoveRepeatNode removeRepeatNode = new RemoveRepeatNode();

        removeRepeatNode.printNode(head);
        System.out.println("删除重复node1");
//        Node newHead = head;
//        removeRepeatNode.solution(newHead);
//        removeRepeatNode.printNode(newHead);
        System.out.println("删除重复node2");
        removeRepeatNode.solution2(head);
        removeRepeatNode.printNode(head);

    }

    private void printNode(Node node){
        Node current = node;
        while (current != null) {
            System.out.print("-->" + current.data);
            current = current.next;
        }

    }

}
