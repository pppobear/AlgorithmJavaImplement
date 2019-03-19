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

    private static <T extends Comparable<T>> void insertionSort(T[] unsortedArr, int l, int r) {
        int n = r - l;
        if (n < 2) {
            return;
        }
        int j;
        T curItem;
        for (int i = l; i < r; i++) {
            curItem = unsortedArr[i];
            j = i;
            while (j > l && SortHelper.less(curItem, unsortedArr[j - 1])) {
                j--;
            }
            System.arraycopy(unsortedArr, j, unsortedArr, j + 1, i - j);
            unsortedArr[j] = curItem;
        }
    }


    @SuppressWarnings("unchecked")
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r);

        int i = l, j = mid;
        for (int k = i; k < r; k++) {
            if (r - j < 1) arr[k] = aux[i++ - l];
            else if (mid - i < 1) arr[k] = aux[j++ - l];
            else if (aux[i - l].compareTo(aux[j - l]) < 0) arr[k] = aux[i++ - l];
            else arr[k] = aux[j++ - l];
        }
    }

    /**
     * 递归版本的 归并排序的入口函数
     *
     * @param arr 待排序数组
     */
    public static void sortRecursive(Comparable[] arr) {
        int n = arr.length;
        sortRecursive(arr, 0, n);
    }

    @SuppressWarnings("unchecked")
    private static void sortRecursive(Comparable[] arr, int l, int r) {
        if (r - l < 2) return;

        //优化一 对于序列规模比较小时，使用插入排序
        if (r - l < INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, l, r);
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
    public void sort(Comparable[] arr) {
        int n = arr.length;

        // 自下而上的 归并排序 原始版本
//        for (int size = 1; size < n; size *= 2)
//            for (int i = 0; i < n-size; i += 2*size)
//                merge(arr, i, i+size, (i+2*size > n) ? n : i+2*size);

        for (int i = 0; i < n; i += INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, i, (n < i + INSERTION_SORT_THRESHOLD) ? n : i + INSERTION_SORT_THRESHOLD);
        }
        for (int size = INSERTION_SORT_THRESHOLD; size < n; size *= 2) {
            for (int i = 0; i < n - size; i += 2 * size) {
                if (SortHelper.less(arr[i + size], arr[i + size - 1])) {
                    merge(arr, i, i + size, n < i + 2 * size ? n : i + 2 * size);
                }
            }
        }
    }
}