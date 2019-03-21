package cn.pppobear.sort;

import org.junit.Test;

import java.util.Arrays;

import static cn.pppobear.util.SortHelper.testSort;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-21
 **/
public class QuickSortTest {

    @Test
    public void sortTest() {
        var arr1 = Arrays.copyOfRange(DataInit.nearlyOrderedArray, 0, DataInit.N);
        var arr2 = Arrays.copyOfRange(DataInit.randomArray, 0, DataInit.N);

        testSort("cn.pppobear.sort.QuickSort", arr1, "近乎有序数组");
        testSort("cn.pppobear.sort.QuickSort", arr2, "随机生成数组");
    }
}
