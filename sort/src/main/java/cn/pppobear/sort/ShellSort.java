package cn.pppobear.sort;

import static cn.pppobear.util.SortHelper.less;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-21
 **/
public class ShellSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        int j, pre;
        T tmp;
        for (int gap = n/2; gap > 0; gap/=2) {
            for (int i = gap; i < n; i++) {
                j = i;
                tmp = arr[j];
                pre = j - gap;
                while (pre >= 0 && less(tmp, arr[pre])) {
                    arr[j] = arr[pre];
                    j -= gap;
                    pre -= gap;
                }
                arr[j] = tmp;
            }
        }
    }
}
