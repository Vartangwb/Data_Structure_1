package LeetCode;

/**
 * array
 *
 * @author tangwenbo
 * @create 2017-10-16 20:59
 **/
public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int dp[] = new int[len1];
        for(int i = 0;i<len1;i++){
            dp[i] = -1;
        }
        for(int i = 0; i < len1; i++){
            int index = 0;
            for(index = 0;index<len2;index++){
                if(nums2[index] == nums1[i])
                    break;
            }
            for(;index<len2;index++){
                if(nums2[index]>nums1[i]){
                    dp[i] = nums2[index];
                    break;
                }
            }
        }
        return dp;
    }



}
