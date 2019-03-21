package cn.pppobear.sort;

import static cn.pppobear.sort.InsertionSort.insertionSort;
import static cn.pppobear.util.SortHelper.exch;
import static cn.pppobear.util.SortHelper.less;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-21
 **/
public class QuickSort implements SortAlgorithm {

    private static final int INSERTION_SORT_THRESHOLD = 47;

    private static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        int n = r - l;
        // 对于小规模数组, 使用插入排序
        if (n <= INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, l, r);
            return;
        }
        exch(arr, l, (int) (Math.random() * n) + l);
        T v = arr[l];

        // [l, lt) < v, [lt, eq) = v, [gt, r) > v
        int lt = l+1, gt = r, eq = lt;
        while (eq != gt) {
            if (less(arr[eq], v)) {
                exch(arr, eq++, lt++);
            } else if (less(v, arr[eq])) {
                exch(arr, eq, --gt);
            } else {
                eq++;
            }
        }
        exch(arr, l, lt-1);
        sort(arr, l, lt);
        sort(arr, gt, r);
    }

//    private static <T extends Comparable<T>> void sort2Ways(T[] arr, int l, int r) {
//        int n = r - l;
//        // 对于小规模数组, 使用插入排序
//        if (n <= INSERTION_SORT_THRESHOLD) {
//            insertionSort(arr, l, r);
//            return;
//        }
//        exch(arr, l, (int) (Math.random() * n) + l);
//        T v = arr[l];
//
//        // [l, lt) < v, [gt, r) > v
//        int lt = l+1, gt = r;
//        while (true) {
//            while( lt <= r && less(arr[lt], v) )
//                lt++;
//            while (gt > l+1 && less(v, arr[gt-1]))
//                gt--;
//            if (lt >= gt)
//                break;
//            exch(arr, lt++, --gt);
//        }
//        exch(arr, l, gt-1);
//        sort(arr, l, lt);
//        sort(arr, gt, r);
//    }

    @Override
    public <T extends Comparable<T>> void sort(T[] unsortedArr) {
        sort(unsortedArr, 0, unsortedArr.length);
    }
}
