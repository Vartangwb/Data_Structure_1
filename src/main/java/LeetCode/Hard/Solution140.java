
package LeetCode.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
//https://www.cnblogs.com/weedboy/p/7204529.html
//https://www.cnblogs.com/yuzhangcmu/p/4037299.html
public class Solution140 {


    public boolean wordBreak(String s, Set<String> set){
        int len = s.length();
        boolean dp[] = new boolean[len+1];
        dp[0] = true;
        for(int i = 1;i<=len;i++){
            for(int j = 0;j<i;j++){
                String tmp = s.substring(j, i);
                if(dp[j] && set.contains(tmp)){
                    dp[i] = true;
                }
            }
        }
        for (boolean b : dp) {
            System.out.println(b);
        }
        return dp[len];
    }

    public List<List<String>> wordBreak1(String s, Set<String> set){

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(res, path, s, set, 0);
        System.out.println(res);
        return res;
    }

    public void helper(List<List<String>> res, List<String> path, String s, Set<String> set, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(path));
        }
        for(int i = index;i<s.length();i++){
            String currStr = s.substring(index, i+1);
            if(set.contains(currStr)){
                path.add(currStr);
                helper(res, path, s, set, i+1);
                path.remove(currStr);
            }
        }
    }


        public static void main(String[] args) {
        Solution140 solution044 = new Solution140();
        Set<String> ss = new HashSet<>();
        ss.add("abc");
        ss.add("def");
        ss.add("defg");
        ss.add("gh");
        ss.add("h");

        System.out.println(solution044.wordBreak1("abcdefgh", ss));
    }

}
