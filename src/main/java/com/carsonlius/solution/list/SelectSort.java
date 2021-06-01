package com.carsonlius.solution.list;

import com.carsonlius.solution.Node;

/**
 *
 * 选择排序 o(n2)
 * */
public class SelectSort {

    public Node solution(Node head){
        // 考虑极端情况
        if (head == null || head.next == null) {
            return head;
        }

        //  链表分成前后2部分，left是有序的，right是无序的
        Node right = head;
        Node tail = null; // 排序节点最后一个
        Node small = null;
        Node smallPre = null; // 未排序的最小的节点

        //  遍历节点,直到right变成最后一个
        while (right != null) {
            small = right;
            smallPre = getSmallPreNode(right);
            if (smallPre != null) {
                small = smallPre.next;
                // 删除原来的节点
                smallPre.next = smallPre.next.next;
            }

            // 移动right边界
            right = right == small ? right.next : right;
            
            // 追加到left边界
            if (tail == null) {
                // 初始化
                tail = small;
                head = small;
            } else {
                // 追加到tail尾部
                tail.next = small;
                tail = tail.next;
            }
        }

        return head;
    }

    private Node getSmallPreNode(Node right){
        Node current = right.next;
        Node smallNode = right;
        Node smallPre = null;
        Node preNode = right;

        while (current != null) {
            if (smallNode.data > current.data) {
                smallNode = current;
                smallPre = preNode;
            }
            preNode = current;
            current = current.next;
        }
        return smallPre;
    }

    public static void main(String[] args) {
        int[] nodes = {9,1,2,3,6,5,4,1};
        GenList genList = new GenList();
        Node head = genList.getNormalList(nodes);
        genList.printNode(head);
        System.out.println("----");
        SelectSort selectSort = new SelectSort();
        genList.printNode(selectSort.solution(head));
    }
}
