package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void sortTest() {
        var arr1 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr2 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);
        var arr3 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr4 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);

        SortHelper.testSort("cn.pppobear.sort.MergeSort", arr1, "近乎有序数组");
        SortHelper.testSort(MergeSort::sortRecursive, "递归版MergeSort", arr1, "近乎有序数组");
        SortHelper.testSort("cn.pppobear.sort.MergeSort", arr2, "随机生成数组");
        SortHelper.testSort(MergeSort::sortRecursive, "递归版MergeSort", arr1, "随机生成数组");
    }
}
