
package LeetCode;

/**
 *
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution372 {

    public static final int MOD = 1337;
    public int superPow(int a, int[] b) {

        int res = 1;
        for(int i = 0;i<b.length;i++){
            res = mypow(res, 10) * mypow(a, b[i]) % MOD;

        }
        return res;
    }

    public int mypow(int a, int b){
        if(b == 0)
            return 1;
        if(b == 1)
            return a % MOD;
        return mypow(a%MOD, b/2) * mypow(a%MOD, b - b/2) % MOD;
    }


    int findDerangement(int n) {
        if (n < 2) return 0;
        long[] dp = new long[n + 1];
        dp[1] = 0; dp[2] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (i - 1) % 1000000007;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution372 solution372 = new Solution372();
        System.out.println(solution372.superPow(2, new int[]{3}));
    }


}
