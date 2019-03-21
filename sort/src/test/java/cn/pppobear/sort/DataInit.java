package cn.pppobear.sort;

import cn.pppobear.util.SortHelper;

/**
 * <p> Description: 测试前，对数据进行初始化 </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-11
 **/
class DataInit {
    static final int N = 1000000;
    static Comparable[] nearlyOrderedArray = SortHelper.generateNearlyOrderedArray(N, (int) Math.pow(10, Math.log10(N) - 4));
    static Comparable[] randomArray = SortHelper.generateRandomArray(N, 0, N);
}
