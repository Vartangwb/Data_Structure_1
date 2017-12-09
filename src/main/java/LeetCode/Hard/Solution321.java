
package LeetCode.Hard;

import java.util.Stack;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/

//https://www.cnblogs.com/CarryPotMan/p/5384172.html
public class Solution321 {

    public int maxNum(int[] nums, int k){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<nums.length;i++){
            if(stack.size()<k){
                stack.push(nums[i]);
            }else{
                while(!stack.isEmpty() && stack.peek()<nums[i]){
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        System.out.println(stack);
        return 1;
    }

    public boolean greater(int[] nums1, int[] nums2, int i, int j){
        while(i<nums1.length && j<nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
    }
    public int merge(int[] nums1, int[] nums2, int k){
        int ans[] = new int[k];
        int i = 0;
        int j = 0;
        for(int index = 0;index<k;index++){
            if(greater(nums1, nums2, i, j)){
                ans[index] = nums1[i++];
            }else{
                ans[index] = nums2[j++];
            }
        }
        return 1;
    }
    public int maxNumber(int[] nums1, int[] nums2, int k){
        int res = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = Math.max(k-len2, 0);i<=Math.min(k, len1);i++){
            res = Math.max(0,0);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution321 solution044 = new Solution321();

    }

}
