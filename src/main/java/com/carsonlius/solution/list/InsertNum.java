package com.carsonlius.solution.list;

import com.carsonlius.solution.Node;

/**
 * 向有序环形链表中插入新节点
 *
 *
 * */
public class InsertNum {
    public Node solution(Node head, int num){
        // 创建新节点
        Node node = new Node(num);

        // 如果head为null, 则返回node（node此时被处理,next指向自己）
        if (head == null) {
            node.next = node;
            return node;
        }

        //  遍历链表 定位smallPre(小) current(大),node在他们之间
        Node current = head.next;
        Node smallPre = head;

        while (current != head) {
            if (smallPre.data <= num && current.data >= num) {
                break;
            }
            smallPre = current;
            current = current.next;
        }
        smallPre.next = node;
        node.next = current;

        // 如果遍历链表没有发现满足上述smallPre small则node放在最后一个节点和head之间, 恰恰此时smallPre

        //  上一步发生了且node值小于头节点的值 则返回node否则head
        return head.data <= num ? head : node;
    }


    public static void main(String[] args) {
        int[] ints = {3,4 };
        Node head = new Node(1);
        Node current = head;
        for (int anInt : ints) {
            Node next = new Node(anInt);
            current.next = next;
            current = next;
        }
        current.next = head;

        InsertNum insertNum = new InsertNum();

        insertNum.printNode(head);
        System.out.println("insert Num");
//        Node newHead = head;
//        removeRepeatNode.solution(newHead);
//        removeRepeatNode.printNode(newHead);
        Node newHead = insertNum.solution(head, 4);
        insertNum.printNode(newHead);
        /**
         * 412323195107103619 刘志江
         * 4123 2319 5210 0636 27 赵后麻
         * */


    }

    private void printNode(Node node){
        Node current = node.next;
        System.out.print(node.data);
        while (current != node) {
            System.out.print("-->" + current.data);
            current = current.next;
        }
        System.out.print("-->" + current.data);

        System.out.println("");
    }
}
