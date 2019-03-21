package cn.pppobear.sort;

import org.junit.Test;

import java.util.Arrays;

import static cn.pppobear.util.SortHelper.testSort;

public class HeapSortTest {

    @Test
    public void sortTest() {
        var arr1 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr2 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);

        testSort("cn.pppobear.sort.HeapSort", arr1, "近乎有序数组");
        testSort(HeapSort::sortWithHeap, "借助最大堆排序", arr1, "近乎有序数组");
        testSort("cn.pppobear.sort.HeapSort", arr2, "随机生成数组");
        testSort(HeapSort::sortWithHeap, "借助最大堆排序", arr2, "随机生成数组");
    }
}
