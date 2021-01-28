package com.carsonlius.solution;


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }
}

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        new Integer(33);
    }

    public ListNode solution(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode first = head, second = dummy;

        if (head == null) {
            return null;
        }

        // copy 快慢指针算法
        // first先走n步, 然后同时移动first second, first移动到末尾的时候 second指向的就是要删除的值
        int step = 0;
        while (first.next != null) {
            step++;
            first = first.next;

            // 移动second
            if (step > n) {
                second = second.next;
            }
        }

        // 此时second就是要删除的元素的前一位
        second.next = second.next.next;
        ListNode newHead = dummy.next;

        return newHead;
    }
}
