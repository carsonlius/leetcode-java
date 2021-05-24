package com.carsonlius.solution;

import java.util.HashMap;
import java.util.Map;

/**
 *  复制含有随机节点的链表
 * */
public class CopyListWithRand {

    static class RandNode {
        RandNode next;
        RandNode random;
        int data;

        public RandNode(int data){
            this.data = data;
        }
    }

    public RandNode solution2(RandNode head){
        if (head == null) {
            return null;
        }

        Map<RandNode, RandNode> map = new HashMap<>();

        // 每个节点创建副本
        RandNode current = head;
        while (current != null) {
            map.put(current, new RandNode(current.data));
            current = current.next;
        }

        // 为每个副本构建next random节点
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        // 获取首节点的副本
        return map.get(head);
    }

    public RandNode solution(RandNode head){
        // 极限情况
        if (head == null) {
            return head;
        }

        //  生成复制节点,复制节点在原节点后面
        RandNode current  =  head;
        RandNode next = null;
        while (current != null) {
            next = current.next;
            current.next = new RandNode(current.data);
            current.next.next = next;
            current = next;
        }

        //  复制随机节点
        current = head;
        while (current !=null) {
            next = current.next.next;
            current.next.random = current.random !=null ? current.random.next : null;
            current = next;
        }

        //  将复制节点剔除出来
        RandNode copyHead = head.next;
        current = copyHead;
        while (current != null) {
            current.next =  current.next != null? current.next.next : null;
            current = current.next;
        }

        // 返回复制节点
        return copyHead;
    }

    public static void main(String[] args) {
        RandNode head = new RandNode(1);
        RandNode secNode = new RandNode(2);
        RandNode lastNode = new RandNode(3);
        head.next = secNode;
        secNode.next = lastNode;
        head.random = lastNode;
        secNode.random = null;
        lastNode.random = head;
        CopyListWithRand copyListWithRand = new CopyListWithRand();

        copyListWithRand.printRandNode(head);

        RandNode newHead = copyListWithRand.solution(head);


        copyListWithRand.printRandNode(newHead);

        System.out.println("方法2");
        copyListWithRand.printRandNode(head);
        newHead = copyListWithRand.solution2(head);
        copyListWithRand.printRandNode(newHead);
    }


    private void printRandNode(RandNode randNode){
        while (randNode != null) {
            System.out.print("{value:" + randNode.data + ",random:" +(randNode.random != null ? randNode.random.data: "") + "} -->");
            randNode = randNode.next;
        }

        System.out.println(" ");
    }
}
