package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution576 {


    int findPaths(int m, int n, int N, int i, int j){
        int dp[][][] = new int[51][50][50];
        for(int k = 1;k<=N;k++){
            for(int mm = 0;mm<m;mm++){
                for(int nn = 0;nn<n;nn++){
                    long t1 = dp[k][mm][nn] + mm==0?1:dp[k-1][mm-1][nn];
                    long t2 = dp[k][mm][nn] + mm==m-1?1:dp[k-1][mm+1][nn];
                    long t3 = dp[k][mm][nn] + mm==0?1:dp[k-1][mm-1][nn];
                    long t4 = dp[k][mm][nn] + nn==n-1?1:dp[k-1][mm][nn+1];
                    
                }
            }
        }
        return dp[N][i][j];
    }

    public static void main(String[] args) {
        Solution576 solution281 = new Solution576();
    }

}
