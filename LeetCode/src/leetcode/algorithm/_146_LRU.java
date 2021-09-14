package leetcode.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _146_LRU {
//    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
//    实现 LRUCache 类：
//    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
//    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，
//    则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

    class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }


    class LRUCache {
        int capacity, size;
        Node head, tail;
        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                remove(node);
                addFirst(node);
                return node.val;
            }
        }

        public void put(int key, int value) {
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.val = value;
                remove(node);
            } else {
                node = new Node(key, value);
                map.put(key, node);
                if (size == capacity) {
                    map.remove(removeLast().key);
                }
            }
            addFirst(node);
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public void addFirst(Node node) {
            Node tmp = head.next;
            head.next = node;
            node.prev = head;
            node.next = tmp;
            tmp.prev = node;
            size++;
        }

        public Node removeLast() {
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }
}
