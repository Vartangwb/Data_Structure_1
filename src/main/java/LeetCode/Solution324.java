
package LeetCode;

import java.util.Arrays;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution324 {

    public void wiggleSort(int[] nums){
        int[] tmp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            tmp[i] = nums[i];
        }
        int len = nums.length;
        int k = len-1;
        int j = len/2;
        Arrays.sort(tmp);
        System.out.println(nums[len-1]);
        for(int i = 0;i<len;i++){
            nums[i] = ((i&1)==0)?tmp[j--]:tmp[k--];
        }
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        Solution324 solution216 = new Solution324();
        solution216.wiggleSort(new int[]{5,4,3,2,1});
    }


}
