package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;
import org.junit.Test;

import java.util.Arrays;

public class SelectionSortTest {

    @Test
    public void sortTest() {
        var arr = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr2 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);

        SortHelper.testSort("cn.pppobear.sort.SelectionSort", "sort", arr, "近乎有序数组");
        SortHelper.testSort("cn.pppobear.sort.SelectionSort", "sort", arr2, "随机生成数组");
    }

}
