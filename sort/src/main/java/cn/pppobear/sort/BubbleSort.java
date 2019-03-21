package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;

/**
 * <h1> 冒泡排序类 </h1>
 * <p>循环遍历未排序区, 每次将最大的元素放到已排序区的左边界，直至本次循环没有元素交换</p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-10
 **/
public class BubbleSort implements SortAlgorithm {

    /**
     * 如类注释所述，内循环将正在考虑的元素与它右边的元素比较，若其比它小，就交换它们的位置
     * @param arr 待排序数组
     */
    public  <T extends Comparable<T>> void sortBasic(T[] arr) {
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

    /**
     * 最终版
     * @param arr 待排序数组
     */
    @Override
    public  <T extends Comparable<T>> void sort(T[] arr) {
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
            // 记录本轮最后一次的交换位置, 在此之后的元素是有序的, 在下一轮扫描中均不考虑
            n = newn;
        } while (n > 0);
    }
}
