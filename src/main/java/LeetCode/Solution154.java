
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution154 {

    int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];
    }
    public static void main(String[] args) {
        Solution154 solution216 = new Solution154();

    }


}
