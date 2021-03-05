package com.carsonlius.solution;

import java.util.List;
import java.util.Stack;

public class ReverseList {
    public ListNode solution(ListNode head){
        // 迭代算法
        ListNode prefix = null;
        ListNode current = head;
        while (current != null) {
            // 记录当前节点
            ListNode temp = current.next;

            // 头插法
            current.next = prefix;
            prefix = current;
            current = temp;
        }

        return prefix;
    }

    public ListNode solution2(ListNode head){
        Stack<ListNode> listNodeStack = new Stack<>();
        while (head != null) {
            listNodeStack.push(head);
            head = head.next;
        }

        ListNode newHead = new ListNode();
        ListNode current = newHead;

        while (!listNodeStack.isEmpty()) {
            current.next =  listNodeStack.pop();
            current = current.next;
            current.next = null;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode current = head;
        int[] nums = {1,2,3,4,5};
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        ReverseList reverseList = new ReverseList();
        ListNode newHead = reverseList.solution2(head.next);
        head = newHead;

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }
}
