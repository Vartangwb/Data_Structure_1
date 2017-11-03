
package LeetCode;

import java.util.Arrays;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution688 {

    int[][] dir = new int[][]{{1,1}, {1,0}, {1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
    public double solve(int N, int K, int r, int c){
        int dp[][] = new int[N][N];
        Arrays.fill(dp[0], new Integer(1));
        Arrays.fill(dp[1], new Integer(1));
        Arrays.fill(dp[2], new Integer(1));
        for(int i = 0;i<K;i++){
            int[][] tmp = new int[N][N];
            for(int j = 0; j<N;j++){
                for(int k = 0; k<N;k++){
                    for(int m = 0; m<8;m++){
                        int currx = i + dir[m][0];
                        int curry = j + dir[m][1];
                        if(currx>=0 && currx<N && curry>=0 && curry<N){
                            tmp[currx][curry] += dp[i][j];
                        }
                    }
                }
            }
            dp = tmp;
        }
        return dp[r][c]/Math.pow(8, K);
    }
    public static void main(String[] args) {
        Solution688 solution216 = new Solution688();
        System.out.println(solution216.solve(3, 2, 0, 0));
    }


}
