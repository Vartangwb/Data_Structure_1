
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution562 {

    int longestLine(int[][] M) {
        if (M.length <= 0 || M[0].length <= 0) return 0;
        int row = M.length, col = M[0].length;
        //vector<vector<vector<int>>> dp(row+1, vector<vector<int>>(col+1, vector<int>(4, 0)));
        int[][][] dp = new int[row+1][col+1][4];
        int max_len = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (M[i - 1][j - 1] == 0) continue;
                dp[i][j][0] = dp[i - 1][j][0] + 1;
                dp[i][j][1] = dp[i][j - 1][1] + 1;
                dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                if (j != col) dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
                for (int k = 0; k < 4; k++) {
                    max_len = Math.max(max_len, dp[i][j][k]);
                }

            }
        }
        System.out.println(max_len);
        return max_len;
    }
        public static void main(String[] args) {
            Solution562 solution216 = new Solution562();
            solution216.longestLine(new int[][]{{1,1,0},{0,1,0},{0,0,1}});
        }

}
