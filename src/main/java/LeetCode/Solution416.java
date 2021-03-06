
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution416 {

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum & 1) == 1){
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for(int i = 1;i <= n;i++){
            dp[i][0] = true;
        }
        for(int j = 1;j <= sum; j++ ){
            dp[0][j] = false;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=sum;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        Solution416 solution216 = new Solution416();

    }


}
