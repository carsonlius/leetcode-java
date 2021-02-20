package com.carsonlius.solution;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MergeKLists {
    public ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // copy 归并官解
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
            // 设置递归基
            if (left == right) {
                return lists[left];
            }

            if (left > right) {
                return null;
            }

            int middle = (left + right) >> 1;

            System.out.println("left:" + left + " right:" + right + " middle:" + middle);
            return mergeTwoLists(merge(lists, left, middle), merge(lists, middle+1, right));
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        System.out.println("hello world!");
        ListNode head = new ListNode();
        ListNode current = head;

        // 因为是递归的方法，所以这里修改了left,right在上一层还是会被还原
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right= right.next;
            }
            current = current.next;
        }

        current.next = left == null ? right : left;

        return head.next;
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();

        ListNode[] listNodes = new ListNode[3];
        ListNode listNode3 = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        listNodes[0] = listNode1;

        ListNode list2Node3 = new ListNode(4);
        ListNode list2Node2  = new ListNode(3, list2Node3);
        ListNode list2Node1  = new ListNode(3, list2Node2);
        listNodes[1] = list2Node1;

        ListNode list1Node2 = new ListNode(6);
        ListNode list1Node1 = new ListNode(2, list1Node2);
        listNodes[2] = list1Node1;

        System.out.println(mergeKLists.solution(listNodes));
    }
}
