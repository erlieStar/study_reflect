package com.javashitang.lru;

/**
 * @author lilimin
 * @since 2021-01-18
 */
public class ListNode<K, V> {
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
