
package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map =  new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        for(int i = 0;i<nums.length;i++){
            currSum+=nums[i];
            if(k!=0)
                currSum%=k;
            Integer prev = map.get(currSum);
            if(prev!=null){
                if(i - prev>1)
                    return true;
            }else{
                map.put(currSum, i);
            }
        }
        return false;
    }
        public static void main(String[] args) {
        Solution523 solution216 = new Solution523();
        System.out.println(solution216.checkSubarraySum(new int[]{1,2,3,4,5},3));
    }


}
