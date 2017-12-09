
package LeetCode.Hard;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution044 {

    public boolean isMatch(String s, String p){
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int index1, int index2){
        if(index1 == s.length() && index2 == p.length()){
            return true;
        }
        if(index1==s.length() && index2!=p.length())
            return false;
        if(index1!=s.length() && index2==p.length())
            return false;
        if(s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='?'){
            return isMatch(s, p,index1+1, index2+1);
        }
        if(p.charAt(index2) == '*'){
            String tmps = s.substring(index1);
            String tmpp = p.substring(index2);
            for(int i = 0;i<=tmps.length() - tmpp.length()+1;i++){
                if(isMatch(tmps, tmpp, i, 1))
                    return true;
            }
        }

        return false;

    }
    boolean isMatch(char s[], char p[]) {
        int m = s.length, n = p.length;
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p[i - 1] == '*') dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = (s[i - 1] == p[j - 1] || p[j - 1] == '?') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution044 solution044 = new Solution044();
        System.out.println(solution044.isMatch("abcdefg", "abc*g"));
    }

}
