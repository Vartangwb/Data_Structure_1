
package LeetCode;

import java.util.Arrays;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution673 {

    //https://www.cnblogs.com/Atanisi/p/7596135.html
    int findNumberOfLIS(int[] nums) {
        int n = nums.length, max_len = 1, res = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for(int i = 1; i < n; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if(nums[j] < nums[i] && dp[j] + 1 == dp[i]){
                    cnt[i] += cnt[j];
                }
            }
            max_len = Math.max(max_len, dp[i]);
        }
        for(int i = 0; i < n; ++i)
            if(dp[i] == max_len) res += cnt[i];
        return res;
    }

    public static void main(String[] args) {
        Solution673 solution216 = new Solution673();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        System.out.println(solution216.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));

    }


}
