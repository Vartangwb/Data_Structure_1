

package LeetCode.Hard;

import java.util.Arrays;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution719 {

    public int findKNum(int[] nums, int k){
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1]-nums[0];
        while(left<right){
            int count = 0;
            int m = (left+right)/2;
            int ll = 0;
            int rr = 0;
            for(rr = 0;rr<nums.length;rr++){
                if(nums[rr]-nums[ll]>m){
                    ll++;
                }
                count+=(rr-ll);
            }
            if(count>=k){
                right = m;
            }else{
                left = m+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution719 solution044 = new Solution719();
        System.out.println(solution044.findKNum(new int[]{3,2,1,5}, 2));
    }



}
