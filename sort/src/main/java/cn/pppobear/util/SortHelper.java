package cn.pppobear.util;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p> Description: 排序辅助类 </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-10
 **/
@Slf4j
public class SortHelper {

    private SortHelper() {}

    /** 判断两个元素，是否前者小于后者
     * @param a 要比较的元素
     * @param b 另一个要比较的元素
     * @return 若 a小于b，返回true，否则返回false;
     */
    @SuppressWarnings("unchecked")
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /** 调换数组中两个指定索引的元素
     * @param arr 被操作的数组
     * @param i 要调位的索引
     * @param j 另一个要调位的索引
     */
    public static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(Comparable[] arr) {
        Stream.of(arr).forEach(comparable -> System.out.print(comparable + " "));
        System.out.println();
    }

    /** 判断数组是否有序（升序）
     * @param arr 需要测试的数组
     * @return 数组为升序则返回true, 否则返回false
     */
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i-1])) {
                return false;
            }
        }
        return true;
    }

    /** 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     *
     * @param n 数组的元素个数
     * @param rangeL 生成随机数的最小值
     * @param rangeR 生成随机数的最大值
     * @return 生成的随机数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        return  IntStream.range(0, n)
                .map(ignored -> (int) (Math.random() * (rangeR - rangeL + 1) + rangeL))
                .boxed().toArray(Integer[]::new);
    }

    /** 生成一个近乎有序的数组
     * 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
     * @param n 数组的元素个数
     * @param swapTimes 定义了数组的无序程度:
     *  swapTimes == 0 时, 数组完全有序
     *  swapTimes 越大, 数组越趋向于无序
     * @return 生成的随机数组
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        var arr = IntStream.range(0, n).boxed().toArray(Integer[]::new);

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }

    /** 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     * @param sortClassName 排序类类名
     * @param methodName 排序方法名称
     * @param arr 需要排序的数组
     */
    @SuppressWarnings("unchecked")
    public static void testSort(String sortClassName, String methodName, Comparable[] arr, String arrType){
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try{
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            var sortMethod = sortClass.getMethod(methodName, Comparable[].class);
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );
            log.info("使用 排序类: {} 的 {} 方法, 对 {} 进行排序, 耗时: {}ms.",
                    sortClass.getSimpleName(), methodName, arrType, (endTime-startTime));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}