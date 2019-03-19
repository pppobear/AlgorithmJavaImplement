package cn.pppobear.search;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-14
 **/
public class BinarySearch {

    @SuppressWarnings("unchecked")
    public static int search(Comparable[] sortedArray, Comparable target) {
        int l = 0, r = sortedArray.length - 1, mid;
        while (l <= r) {
            mid = l + (r-l)/2;
            if (target.compareTo(sortedArray[mid]) == 0) {
                return mid;
            } else if (target.compareTo(sortedArray[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
