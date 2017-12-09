
package LeetCode.Hard;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution097 {

    public boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i = 1;i<=len1;i++){
            if(s3.charAt(i-1) == s1.charAt(i-1))
                dp[i][0] = true;
        }
        for(int i = 1;i<=len2;i++){
            if(s3.charAt(i-1) == s2.charAt(i-1))
                dp[0][i] = true;
        }
        for(int i = 1;i<=len1;i++){
            for(int j = 1;j<=len2;j++){
                if(dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
                if(dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }

            }
        }

        return dp[len1][len2];
    }

        public static void main(String[] args) {
        Solution097 solution044 = new Solution097();
        System.out.println(solution044.isInterleave("abcd","efghj", "abcdefghl"));
    }

}
