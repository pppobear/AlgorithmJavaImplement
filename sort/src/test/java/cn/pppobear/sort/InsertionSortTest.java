package cn.pppobear.sort;


import cn.pppobear.util.SortHelper;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {

    @Test
    public void sortTest() {
        var arr1 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr2 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);
        var arr3 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr4 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);
        var arr5 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr6 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);

        SortHelper.testSort("cn.pppobear.sort.InsertionSort", "sort", arr1, "近乎有序数组");
        SortHelper.testSort("cn.pppobear.sort.InsertionSort", "sort", arr2, "随机生成数组");
        SortHelper.testSort("cn.pppobear.sort.InsertionSort", "sortImprove", arr3, "近乎有序数组");
        SortHelper.testSort("cn.pppobear.sort.InsertionSort", "sortImprove", arr4, "随机生成数组");
        SortHelper.testSort("cn.pppobear.sort.InsertionSort", "sortImprove2", arr5, "近乎有序数组");
        SortHelper.testSort("cn.pppobear.sort.InsertionSort", "sortImprove2", arr6, "随机生成数组");
    }
}
