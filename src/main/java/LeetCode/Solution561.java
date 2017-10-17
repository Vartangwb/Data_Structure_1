package LeetCode;

import java.util.Arrays;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-16 20:59
 **/
public class Solution561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }


}
