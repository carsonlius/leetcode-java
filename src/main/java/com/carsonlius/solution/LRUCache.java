package com.carsonlius.solution;

import java.util.HashMap;

public class LRUCache {
    class Node {
        Node pre;
        Node next;

        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    private Node head;
    private Node end;
    private final int limit;
    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    // 获取指定节点,这样hashLinked兼顾了速度和内存
    private String get(String key) {
        Node node = hashMap.get(key);
        // 不存在不需要要刷新节点位置
        if (node == null) {
            return null;
        }

        // 刷新节点
        refreshNode(node);

        //  返回节点值
        return node.value;
    }


    public void put(String key, String value) {
        //  获取当前节点
        Node node = hashMap.get(key);

        // 节点不存在
        if (node == null) {
            // 超过了限制,删除首节点,也删除这个hashKey
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }

            Node newNode = new Node(key, value);

            //  插入新节点到尾部
            addNode(newNode);

            // 插入hashMap
            hashMap.put(key, newNode);

            return;
        }

        // 取值刷新
        node.value = value;
        removeNode(node);
        hashMap.put(key, node);
    }

    /**
     * 删除旧节点，添加新节点
     *
     * @param node 待刷新的节点
     */
    private void refreshNode(Node node) {
        // 是尾节点则不需要处理
        if (end == node) {
            return;
        }

        // 删除
        removeNode(node);

        // 添加到尾步
        addNode(node);
    }

    /**
     * 添加节点
     *
     * @param node
     */
    private void addNode(Node node) {
        // 如果链表没有值
        if (head == null && end == null) {
            head = node;
            end = node;
            return;
        }

        end.next = node;
        node.pre = end;
        node.next = null;
        end = node;
    }

    /**
     * 删除节点
     *
     * @param node
     * @return key
     */
    private String removeNode(Node node) {
        // 链表只有一个节点且等于当前节点
        if (head == node && end == node) {
            head = null;
            end = null;
        } else if (node == head) {
            //  删除head节点
            head.pre = null;
            head = head.next;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        return node.key;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001", "用户1");
        lruCache.put("002", "用户2");
        lruCache.put("003", "用户3");
        lruCache.put("004", "用户4");
        lruCache.put("005", "用户5");
        lruCache.get("002");
        lruCache.put("004", "用户4信息更新呢");
//        lruCache.put("006", "用户6");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }
}



