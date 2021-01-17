package com.javashitang.lru;


import java.util.HashMap;
import java.util.Map;

/**
 * @author lilimin
 * @since 2021-01-17
 */
public class MyLruCache<K, V> {

    private int capacity;
    private Map<K, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public MyLruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public V get(Object key) {
        ListNode<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        // 先删除该节点，再接到尾部
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);
        return node.value;
    }

    public void put(K key, V value) {
        // 直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
        if ((get(key)) != null) {
            map.get(key).value = value;
            return;
        }
        // 若不存在，new一个出来，如果超出容量，把头去掉
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    // 把节点移动到尾巴
    private void moveToTail(ListNode node) {
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }

    // 定义双向链表节点
    private class ListNode<K, V> {
        K key;
        V value;
        ListNode pre;
        ListNode next;

        public ListNode() {}

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
