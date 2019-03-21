package cn.pppobear.datastructure.stack;

import java.util.Iterator;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-20
 **/
public class LinkedStack<Item> implements IStack<Item> {

    private Node top = null;

    private int size = 0;

    private class Node {
        Item val;
        Node nxt;

        Node(Item val, Node nxt) {
            this.val = val;
            this.nxt = nxt;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Item item) {
        top = new Node(item, top);
        size++;
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        var val = top.val;
        top = top.nxt;
        size--;
        return val;
    }

    @Override
    public Item top() {
        return isEmpty()? null: top.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {

            private Node cur = top;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Item next() {
                var i = cur.val;
                cur = cur.nxt;
                return i;
            }
        };
    }
}
