package cn.pppobear.sort;

import cn.pppobear.datastructure.heap.MaxHeap;

import java.util.Arrays;

import static cn.pppobear.util.SortHelper.exch;
import static cn.pppobear.util.SortHelper.less;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-21
 **/
public class HeapSort implements SortAlgorithm {

    public static <T extends Comparable<T>> void sortWithHeap(T[] unsortedArr) {
        var n = unsortedArr.length;
        var heapData = Arrays.copyOf(unsortedArr, n);
        var heap = new MaxHeap<>(heapData);
        for (int i = n - 1; i >= 0; i--) {
            unsortedArr[i] = heap.pop();
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;

        for (int i = (n - 2) / 2; i >= 0; i--)
            shiftDown(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            exch(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private <T extends Comparable<T>> void shiftDown(T[] arr, int size, int i) {
        T cur = arr[i];
        int maxChildIdx;
        while (2 * i + 1 < size) {
            maxChildIdx = 2 * i + 1;
            if (maxChildIdx+1 < size && less(arr[maxChildIdx], arr[maxChildIdx+1])) maxChildIdx++;
            if (less(arr[maxChildIdx], cur)) break;
            arr[i] = arr[maxChildIdx];
            i = maxChildIdx;
        }
        arr[i] = cur;
    }
}
