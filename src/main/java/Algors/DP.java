package Algors;

import LeetCode.TreeNode;

/**
 * BinTree
 *
 * @author tangwenbo
 * @create 2017-12-04 10:25
 **/
public class DP {


    public int dpSol(int n, int k){
        int M = 1000000007;
        int dp[][] = new int[n+1][k+1];
        dp[0][0] = 1;
        for(int i = 0;i<=n;i++){
            for(int kk=0;kk<=k;kk++){
                for(int j = 0;j<i;j++)
                    if(kk>=j && kk-j<=k)
                        dp[i][kk]=(dp[i][kk]+dp[i-1][kk-j])%M;
            }
        }
        return dp[n][k];
    }

    public int dpSol2(int n, int k){
        int M = 100000007;
        int dp[][] = new int[n+1][k+1];
        dp[0][0]=1;
        for(int i = 1;i<=n;i++){
            dp[i][0] = 1;
            for(int j = 1;j<=k;j++){
                dp[i][j] = (dp[i-1][j]+dp[i][j-1])%M;
                if(j>=i){
                    dp[i][j] = (dp[i][j]-dp[i-1][j-i]+M)%M;
                }
            }
        }
        return dp[n][k];
    }



    public static void main(String[] args) {
        DP bfs = new DP();
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
    
    }
}
