package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;

/**
 * <p> Description: 选择排序 </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-10
 **/
public class SelectionSort implements SortAlgorithm {

    /**
     * | ...有序区... | ...无序区... |
     * 从头到尾考虑每一个索引位置，每一次选出无序区最小的元素与无序区最左边的元素交换，然后无序区最左边的位置并入有序区。
     * @param arr 待排序数组
     */
    public void sort(Comparable[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (SortHelper.less(arr[j], arr[min])) {
                    min = j;
                }
            }
            SortHelper.exch(arr, min, i);
        }
    }
}
