
package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution003 {

    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int i = 0;
        int res = 0;
        for(i = 0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            res = Math.max(i-j+1, res);
        }
        return res;
    }



    public static void main(String[] args) {
        Solution003 solution005 = new Solution003();
        System.out.println(solution005.lengthOfLongestSubstring("abcdefef"));

    }


}
