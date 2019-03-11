package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;

/**
 * <p> Description: 冒泡排序类 </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-10
 **/
public class BubbleSort {

    private BubbleSort() {}

    /**
     * 每次
     * @param arr 待排序数组
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        boolean exchanged;

        do {
            exchanged = false;
            for (int i = 1; i < n; i++) {
                if (SortHelper.less(arr[i], arr[i-1])) {
                    SortHelper.exch(arr, i-1, i);
                    exchanged = true;
                }
            }
            n--;
        } while (exchanged);
    }

    public static void sortImprove(Comparable[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int newn;

        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (SortHelper.less(arr[i], arr[i-1])) {
                    SortHelper.exch(arr, i-1, i);
                    newn = i;
                }
            }
            // 记录最后一次的交换位置,在此之后的元素是有序的，在下一轮扫描中均不考虑
            n = newn;
        } while (newn > 0);
    }
}
