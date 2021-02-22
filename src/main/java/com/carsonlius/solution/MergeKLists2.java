package com.carsonlius.solution;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class MergeKLists2 {

    /**
     * 适配器节点适配优先级队列
     * */
    class Status implements Comparable<Status> {
        ListNode node;
        int val;

        public Status(ListNode node, int val) {
            this.node = node;
            this.val = val;
        }

        @Override
        public int compareTo(Status o) {
            return Integer.compare(val, o.val);
        }
    }

    public ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Status> queue = new PriorityQueue<>();

        // copy 官解每次取最小的数值 (优先级队列来实现)
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(new Status(list, list.val));
            }
        }

        // 循环取队列中的最小值
        ListNode head = new ListNode();
        ListNode current = head;

        while (!queue.isEmpty()) {
            Status least = queue.poll();
            current.next = least.node;
            if (least.node.next != null) {
                queue.add(new Status(least.node.next, least.node.next.val));
            }

            current = current.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        int left = 2;
        int right = 10;
        int result = left + ((right-left)>>1);
        System.out.println(result);
    }
}
