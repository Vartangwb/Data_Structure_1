
package LeetCode;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-08 15:17
 **/
public class Solution713 {

    public int numSubarrayProductLessThanK(int[] nums, int k){
        if(k <= 1)
            return 0;
        int res = 0;
        int prod = 1;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            prod *= nums[i];
            while (prod >= k )
                prod /= nums[left++];
            res += i - left + 1;
        }
        return res;
    }

}
