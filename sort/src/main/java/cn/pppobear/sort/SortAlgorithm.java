package cn.pppobear.sort;

import java.util.Arrays;
import java.util.List;

/**
 * <p> Description: 排序接口 </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-18
 **/
public interface SortAlgorithm {

    /**
     * 传入一个无序的数组，返回其排好序的结果
     * @param unsortedArr 待排序的数组
     * @param <T> 数组元素的类型
     * @return 排好序的数组
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> T[] sorted(T[] unsortedArr) {
        var sortedArr = (T[])new Object[unsortedArr.length];
        System.arraycopy(unsortedArr, 0, sortedArr, 0, unsortedArr.length);
        sort(sortedArr);
        return sortedArr;
    }


    /**
     * 传入一个无序的列表，返回其排好序的结果
     * @param unsortedList 待排序的列表
     * @param <T> 列表元素的类型
     * @return 排好序的列表
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>>  List<T> sorted(List<T> unsortedList) {
        return Arrays.asList(sorted(unsortedList.toArray((T[]) new Comparable[unsortedList.size()])));
    }

    /**
     * 传入一个无序的数组，将其排序
     * @param unsortedArr 待排序的数组
     * @param <T> 数组元素的类型
     */
    <T extends Comparable<T>> void sort(T[] unsortedArr);

    /**
     * 传入一个无序的列表，将其排序
     * @param unsortedList 待排序的列表
     * @param <T> 列表元素的类型
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> void sort(List<T> unsortedList) {
        sort(unsortedList.toArray((T[]) new Comparable[unsortedList.size()]));
    }
}