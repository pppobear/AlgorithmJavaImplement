package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;

import java.util.Arrays;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-15
 **/
public class MergeSort implements SortAlgorithm {

    private static final int INSERTION_SORT_THRESHOLD = 64;

    @SuppressWarnings("unchecked")
    private static  <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r)  {
        T[] aux = Arrays.copyOfRange(arr, l, r);

        int i = l, j = mid;
        for (int k = i; k < r; k++) {
            if (r - j < 1)                                  arr[k] = aux[i++ - l];
            else if (mid - i < 1)                           arr[k] = aux[j++ - l];
            else if (SortHelper.less(aux[i-l], aux[j-l]))   arr[k] = aux[i++ - l];
            else                                            arr[k] = aux[j++ - l];
        }
    }

    /**
     * 递归版本的 归并排序的入口函数
     *
     * @param arr 待排序数组
     */
    public static  <T extends Comparable<T>> void sortRecursive(T[] arr) {
        int n = arr.length;
        sortRecursive(arr, 0, n);
    }

    @SuppressWarnings("unchecked")
    private static  <T extends Comparable<T>> void sortRecursive(T[] arr, int l, int r) {
        if (r - l < 2) return;

        if (r - l < INSERTION_SORT_THRESHOLD) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }

        int mid = (int) Math.ceil((l + r) / 2.0);
        sortRecursive(arr, l, mid);
        sortRecursive(arr, mid, r);
        merge(arr, l, mid, r);
    }

    /**
     * 自下而上的 归并排序 优化版本
     *
     * @param arr 待排序数组
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;

        // 自下而上的 归并排序 原始版本
//        for (int size = 1; size < n; size *= 2)
//            for (int i = 0; i < n-size; i += 2*size)
//                merge(arr, i, i+size, (i+2*size > n) ? n : i+2*size);

        for (int i = 0; i < n; i += INSERTION_SORT_THRESHOLD) {
            InsertionSort.insertionSort(arr, i, (n < i + INSERTION_SORT_THRESHOLD) ? n : i + INSERTION_SORT_THRESHOLD);
        }
        for (int size = INSERTION_SORT_THRESHOLD; size < n; size *= 2) {
            for (int i = 0; i < n - size; i += 2 * size) {
                if (SortHelper.less(arr[i + size], arr[i + size - 1])) {
                    merge(arr, i, i + size, n < i + 2 * size ? n : i + 2 * size);
                }
            }
        }
    }

    public <T extends Comparable<T>> void sortStream(T[] arr) {
        // TODO
    }
}