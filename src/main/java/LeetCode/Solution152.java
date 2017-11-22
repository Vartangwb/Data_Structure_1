
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution152 {


    public int maxProduct(int[] nums){
        if(nums.length<=0)
            return 0;
        int maxRes = nums[0];
        int minNum = nums[0];
        int maxNum = nums[0];
        for(int i = 1;i<nums.length;i++){
            int tmp = maxNum;
            maxNum = Math.max(Math.max(maxNum*nums[i],nums[i]), minNum*nums[i]);
            minNum = Math.min(Math.min(minNum*nums[i],nums[i]), maxNum*nums[i]);
            maxRes = Math.max(maxRes, maxNum);
        }
        return maxRes;
    }

    public static void main(String[] args) {

        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(new int[]{2,3,-2,4}));

    }


}
