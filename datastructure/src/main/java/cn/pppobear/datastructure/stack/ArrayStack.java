package cn.pppobear.datastructure.stack;

import java.util.Iterator;

/**
 * 使用数组实现的栈
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-20
 **/
@SuppressWarnings("unchecked")
public class ArrayStack<Item> implements IStack<Item> {

    private int size = 0;

    private Item[] arr = (Item[]) new Object[1];

    private void resize(int size) {
        Item[] newArr = (Item[]) new Object[size];
        System.arraycopy(arr, 0, newArr, 0, this.size);
        arr = newArr;
    }

    private void check() {
        if (size >= arr.length) {
            resize(2 * arr.length);
        } else if (size > 0 && size <= arr.length / 4) {
            resize(arr.length / 2);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Item item) {
        check();
        arr[size++] = item;
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        var i = arr[--size];
        arr[size] = null;
        check();
        return i;
    }

    @Override
    public Item top() {
        return isEmpty()? null: arr[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {

            private int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return arr[--i];
            }
        };
    }
}
