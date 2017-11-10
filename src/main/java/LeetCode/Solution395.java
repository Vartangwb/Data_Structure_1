package LeetCode;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-05 10:57
 **/
public class Solution395
{
    public int solve(String s, int k){
        int max = 0;
        for(int i = 0;i<s.length()-k;i++){
            int dp[] = new int[26];
            int mask = 0;
            for(int j = i;j<s.length();j++){
                char c = s.charAt(j);
                dp[c-'a']++;
                if(dp[c-'a']<k){
                    mask |= 1<<(c-'a');
                }else{
                    mask &= ~(1<<(c-'a'));
                }
                if(mask == 0){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
}
