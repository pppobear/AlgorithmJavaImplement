package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;

/**
 * <p> Description: 测试前，对数据进行初始化 </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-11
 **/
public class DataInit {
    public static final int N = 50000;
    public static Comparable[] nearlyOrderedArray = SortHelper.generateNearlyOrderedArray(N, N/500);
    public static Comparable[] randomArray = SortHelper.generateRandomArray(N, 0, N*10);
}
