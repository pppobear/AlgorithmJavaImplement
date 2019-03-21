package cn.pppobear.datastructure.heap;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-21
 **/
@SuppressWarnings("unchecked")
public class MaxHeap<T extends Comparable<T>> {

    private T[] data;
    private int len;

    public MaxHeap() {
        data = (T[]) new Comparable[16];
    }

    public MaxHeap(T[] arr) {
        int n = arr.length;
        data = arr;
        len = n;
        for (int i = len/2 ; i >= 0 ; i -- ) {
            shiftDown(i);
        }
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public int size(){
        return len;
    }

    public void put(T item){
        len++;
        check();
        data[len-1] = item;
        shiftUp(len-1);
    }

    /**
     * 获取最大堆中的堆顶元素
     * @return 最大堆中的堆顶元素
     */
    public T getMax(){
        return isEmpty()? null: data[0];
    }


    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public T pop(){
        if (isEmpty()) return null;
        T ret = data[0];
        data[0] = data[--len];
        shiftDown(0);
        data[len] = null;
        check();
        return ret;
    }

    private void resize(int size) {
        T[] newArr = (T[]) new Comparable[size];
        System.arraycopy(data, 0, newArr, 0, this.len);
        data = newArr;
    }

    private void check() {
        if (len >= data.length) {
            resize(2 * data.length);
        } else if ((len > 0) && (len <= (data.length / 4))) {
            resize(data.length / 2);
        }
    }

    private static int parentNode(int i) {
        return i>0? (i-1)/2: -1;
    }

    private int leftChild(int i) {
        return 2*i+1 < len? 2*i+1: -1;
    }

    private void shiftDown(int i) {
        while (leftChild(i) != -1) {
            int j = leftChild(i);
            if (j+1 < len && less(data[j], data[j+1])) j++;
            if (less(data[j], data[i])) break;
            exch(j, i);
            i = j;
        }
    }

    private void shiftUp(int i) {
        T cur = data[i];
        while (i > 0 && less(data[parentNode(i)], cur)) {
            data[i] = data[parentNode(i)];
            i = parentNode(i);
        }
        data[i] = cur;
    }

    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int a, int b) {
        var tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
