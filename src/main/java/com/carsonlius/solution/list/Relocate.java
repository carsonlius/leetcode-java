package com.carsonlius.solution.list;

import com.carsonlius.solution.Node;

/**
 * 按照左右半区的方式重新组合单链表
 * */
public class Relocate {
    public Node solution(Node head){

        //  判断极端情况
        if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) {
            return head;
        }

        //  找到临界点middle， middle.next为右半边
        Node left = head;
        Node right = head.next;
        Node middle = head;
        while (right.next != null && right.next.next != null) {
            right = right.next.next;
            middle = middle.next;
        }

        //  切断left,right链表
        right = middle.next;
        middle.next = null;

        // 合并
        return mergeTwoNode(left, right);
    }

    private Node mergeTwoNode(Node left, Node right){
        Node current = left;
        Node next = null;

        while (current.next != null) {
            next = right.next;
            Node currentNext = current.next;
            current.next = right;
            right.next = currentNext;

            right = next;
            current = currentNext;
        }

        current.next = right;

        return left;
    }

    public static void main(String[] args) {
        int[] nodes =  {1,2,3,4,5,6};
        GenList genList = new GenList();
        Node head1 = genList.getNormalList(nodes);
        Relocate relocate = new Relocate();

        Node newHead = relocate.solution(head1);
        System.out.println("----");
        genList.printNode(head1);
        genList.printNode(newHead);
        System.out.println("-----");

    }


}

