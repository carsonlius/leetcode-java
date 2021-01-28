package com.carsonlius.solution;


public class MergeTwoLists {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        // 选择一个长度小的

        while (l1 != null && l2 !=null) {
            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }

        current.next = l2 == null ? l1 : l2;

        return head.next;
    }
}
