package cn.pppobear.sort;


import cn.pppobear.util.SortHelper;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {

    @Test
    @Ignore
    public void sortTest() {
        var arr1 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr2 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);

        SortHelper.testSort("cn.pppobear.sort.InsertionSort", arr1, "近乎有序数组");
        SortHelper.testSort("cn.pppobear.sort.InsertionSort", arr2, "随机生成数组");
    }
}
