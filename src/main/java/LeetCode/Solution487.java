
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution487 {


    int findMaxConsecutiveOnes(int[] nums){
        int k = 1;
        int zeroNum = 0;
        int maxRes = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                zeroNum++;

            }
            while(zeroNum > k){
                if(nums[left++] == 0)
                    zeroNum--;
            }
            maxRes = Math.max(right - left + 1, maxRes);
            right++;
        }
        System.out.println(maxRes);
        return maxRes;
    }
    public static void main(String[] args) {
        Solution487 solution216 = new Solution487();
        solution216.findMaxConsecutiveOnes(new int[]{1,1,1,0,1,0,0});
    }


}
