package com.carsonlius.solution.list;

import com.carsonlius.solution.Node;

/**
 * 获取相交链表的相交点
 * */
public class GetLoopNode {
    public Node solution(Node head){
        if (head == null || head.next == null) {
            return null;
        }

        // 找到第一次相交的位置
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != slow){
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        //  一个指针移动到头指针，2指针每次移动一个节点，再次相交的地方就是相交点
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5};
        GenList genList = new GenList();
        Node head = genList.getNormalList(nodes);
        Node current = head;
        Node loopNode = null;
        while (current.next != null) {
            if (current.data == 5) {
                loopNode = current;
            }
            current = current.next;
        }

        current.next = loopNode;

        GetLoopNode getLoopNode = new GetLoopNode();
        Node loop = getLoopNode.solution(head);
        System.out.println(loop != null ? loop.data : "没有相交");
    }


}
