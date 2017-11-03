
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n){
        int len = strs.length;
        int dp[][][] = new int[2][m + 1][n + 1];
        dp[0][0][0] = 0;
        dp[1][0][0] = 0;
        for(int k = 1; k <= strs.length; k++){
            int ones = 0;
            int zeros = 0;
            for(int i = 0;i < strs[k-1].length(); i++){
                if(strs[k - 1].charAt(i) == '0'){
                    zeros ++;
                } else{
                    ones ++;
                }
            }
            int pre = (k + 1) & 1;
            int now = k & 1;
            for(int i = 0; i <=m; i++){
                for(int j = 0; j <=n ;j++){
                    dp[now][i][j] = dp[pre][i][j];
                }
            }
            for(int i = 0;i<=m;i++){
                for(int j = 0; j <= n;j++){
                    if(i>=ones && j>=zeros){
                        dp[now][i][j] = Math.max(dp[now][i][j],
                                dp[pre][i - ones][j - zeros] + 1);
                    }
                }
            }

        }
        return dp[strs.length & 1][m][n];
    }

    public static void main(String[] args) {
        Solution474 solution216 = new Solution474();
        System.out.println(solution216.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }


}
