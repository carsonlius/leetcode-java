package com.carsonlius.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 将单向链表按某值划分成左边小,中间相等，右边大的形式
 */
public class ListPortion {
    private int age = 28;
    public ListNode solution(ListNode head, int pivot) {
        // 划分成三段, 需要6个有限的变量
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;

        //  循环链表，把当前值尾插到上面的6个变量上
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = null;

            if (current.val > pivot) {
                if (bH == null && bT == null) {
                    bH = current;
                    bT = current;
                } else {
                    bT.next = current;
                    bT = current;
                }

            } else if (current.val == pivot) {
                if (eH == null && eT == null) {
                    eH = current;
                    eT = current;
                } else {
                    eT.next = current;
                    eT = current;
                }

            } else {
                if (sH == null && sT == null) {
                    sH = current;
                    sT = current;
                } else {
                    sT.next = current;
                    sT = current;
                }
            }

            current = next;
        }

        // 链接三段
        // 小和相等的链接起来
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null) {
            eT.next = bH;
        }


        //  响应
        return sT != null ? sH : (eT == null ? bH : eH);
    }

    public static void main(String[] args) {
        int[] sourceItems = {9,1,8,5,2,5};
        int pivot = 5;
        ListNode prefix = new ListNode(7);
        ListNode head = prefix;
        for (int sourceItem : sourceItems) {
            ListNode current = new ListNode(sourceItem);
            prefix.next = current;
            prefix = current;
        }

        ListPortion listPortion = new ListPortion();
        listPortion.printNode(head);
        ListNode newHead = listPortion.solution(head, pivot);
        listPortion.printNode(newHead);
    }

    private void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println("");
        age --;
    }

}
