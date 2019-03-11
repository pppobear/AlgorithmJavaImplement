package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;

/**
 * <p> Description: 插入排序 </p>
 * <p>跟插入排序的区别在于，它可以提前终止里层循环，所以对于接近完成的排序，使用它的时间会很短。</p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-10
 **/
public class InsertionSort {

    private InsertionSort() {}

    /**
     * 从第二个元素开始考虑，它前面的元素比它大，就跟其交换；直至它前面的元素比它小，<strong>提前终止</strong>本轮循环，考虑下一元素。
     * @param arr 待排序数组
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && SortHelper.less(arr[j], arr[j-1]); j--) {
                SortHelper.exch(arr, j, j-1);
            }
        }
    }

    /**
     * 本类sort方法的改进方案一：先记住当前考虑的位置的元素，然后遇到前面比它大的元素就将其往后移，而不是每次都交换位置。
     * @param arr 待排序数组
     */
    public static void sortImprove(Comparable[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            Comparable curItem = arr[i];
            int j;
            for (j = i; j > 0 && SortHelper.less(curItem, arr[j-1]); j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = curItem;
        }
    }

    /**
     * 本类sort方法的改进方案二：同样先记住当前考虑的位置的元素，然后直接往前找到比它大的元素，将比它大的元素后面到它之间的元素
     * 使用System.arraycopy方法一次性后移一位，再将它赋值到比它大的元素原来的位置。
     * @param arr 待排序数组
     */
    public static void sortImprove2(Comparable[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int j;
        for (int i = 1; i < n; i++) {
            Comparable curItem = arr[i];
            j = i;
            while (j > 0 && SortHelper.less(curItem, arr[j-1])) {
                j--;
            }
            System.arraycopy(arr, j, arr, j+1, i-j);
            arr[j] = curItem;
        }
    }
}
