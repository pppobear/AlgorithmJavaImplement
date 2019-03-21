package cn.pppobear.datastructure.symboltable;

/**
 * 使用链表实现的 无序符号表
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-20
 **/
public class LinkedListUnorderedSymbolTable<Key, Value> implements UnorderedSymbolTable<Key, Value> {
    private Node head;
    private int size = 0;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public Value get(Key key) {
        var cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public void put(Key key, Value value) {
        var cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        head = new Node(key, value, head);
        size++;
    }

    public void delete(Key key) {
        if (head == null) {
            return;
        }
        if (head.key.equals(key)) {
            head = head.next;
            size--;
        }
        var pre = head;
        var cur = head.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                pre.next = cur.next;
                size--;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}
