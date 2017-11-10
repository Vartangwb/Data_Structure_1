
package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution548 {

    public boolean splitArray(int[] nums){
        int len = nums.length;
        int sums[] = new int[len];
        sums[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            sums[i] = sums[i-1] + nums[i];
        }
        for(int j = 3;j<len-3;j++){
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 1;i<j-1;i++){
                if(sums[i-1] == sums[j-1]-sums[i]){
                    map.put(sums[i-1], 1);
                }
            }
            for(int k = j+2;k<len-1;k++){

                int sum1 = sums[k-1]-sums[j];
                int sum2 = sums[len-1] - sums[k];
                if(sum1 == sum2 && map.containsKey(sum1))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution548 solution274 = new Solution548();
        System.out.println(solution274.splitArray(new int[]{1,2,1,2,1,2,1}));
    }


}
