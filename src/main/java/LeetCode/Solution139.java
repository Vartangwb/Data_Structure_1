package LeetCode;

import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-10 14:46
 **/
public class Solution139 {

    public boolean wordBreak(String s, List<String> dict){
        int len = s.length();
        boolean dp[] = new boolean[len+1];
        for(int i = 1;i<=len;i++){
            for(int j = 0;j<i;j++){
                if(dp[j] == true && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[len];
    }
    public static void main(String[] args) {
        Solution139 solution228 = new Solution139();
        }

}
