package com.carsonlius.solution;

/*
* 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

 

说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */


import java.util.*;

public class ReverseKGroup {
    public ListNode solution(ListNode head, int k){
        // 每k个节点 分成一组，每一组都做反转 然后串起来
        //copy 官解 模拟  四个节点 pre head tail  nex,记录pre,nex，逆转head tail之后接上pre nex
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode tail = pre;

        while (head != null) {

            // 查看剩下的节点是否够k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return newHead.next;
                }
            }

            // 记录下一次的节点
            ListNode nex = tail.next;

            // 反转
            List<ListNode> newListNode = reverseItem(head, tail);
            head = newListNode.get(0);
            tail = newListNode.get(1);

            // 将反转后的连表接回原链表
            pre.next = head;
            tail.next = nex;

            // 移动pre, head的位置
            pre = tail;
            head = nex;
        }

        return newHead.next;
    }

    private List<ListNode> reverseItem(ListNode head, ListNode tail){
        ListNode prefix = tail.next;
        ListNode current = head;

        while (prefix != tail) {
            ListNode temp = current.next;
            current.next = prefix;
            prefix = current;
            current = temp;
        }

        List<ListNode> newListNodes = new ArrayList<>();
        newListNodes.add(tail);
        newListNodes.add(head);
        return newListNodes;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode current = head;
        int[] nums = {1,2,3,4,5};
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode headCurrent = head.next;
       ListNode newHead = reverseKGroup.solution(headCurrent, 3);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }



    }
}
