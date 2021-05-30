package com.carsonlius.solution.list;


import com.carsonlius.solution.Node;

/**
 * 合并2个有序单链表
 */
public class Merge {
    public Node solution(Node head1, Node head2) {
        // 考虑边界情况
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        //  遍历2个链表 cur1<cur2 则把cur2链接到cur1上, 涉及到cur1 cur2 pre（pre->cur2->cu1）
        Node newHead = head1.data < head2.data ? head1 : head2;
        Node current1 = newHead == head1 ? head1 : head2;
        Node current2 = newHead == head1 ? head2 : head1;
        Node pre = null;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                pre = current1;
                current1 = current1.next;
            } else {
                // current2.data < current1.data pre->current1->current2;
                Node next = current2.next;
                pre.next = current2;
                current2.next = current1;
                pre = current2;

                current2 = next;
            }
        }

        //  newHead连接上没有遍历结束的cur
        pre.next = current1 == null ? current2 : current1;

        return newHead;
    }

    public static void main(String[] args) {
        GenList genList = new GenList();
        int[] nodes1 = {0, 2, 3, 7};
        Node head1 = genList.getNormalList(nodes1);
        int[] nodes2 = {1, 3, 5, 7, 9};
        Node head2 = genList.getNormalList(nodes2);
        genList.printNode(head1);
        genList.printNode(head2);

        Merge merge = new Merge();
        Node newHead = merge.solution(head1, head2);

        genList.printNode(newHead);

    }

}
