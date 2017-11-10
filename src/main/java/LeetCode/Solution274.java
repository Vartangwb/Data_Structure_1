
package LeetCode;

import java.util.Arrays;
/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution274 {

     public int numSquares(int n){
         int[] dp = new int[n + 1];
         Arrays.fill(dp, Integer.MAX_VALUE);
         dp[0] = 0;
         for(int i = 1;i<=n;i++){
             dp[i] = i;
             for(int j = 0;j<i;j++){
                 if(j*j<=i){
                     dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                 }
             }
         }
         for(int i = 0;i<=n;i++){
             System.out.println(dp[i]);
         }
         return dp[n];
     }

    public static void main(String[] args) {
        Solution274 solution274 = new Solution274();
        solution274.numSquares(9);
    }


}
