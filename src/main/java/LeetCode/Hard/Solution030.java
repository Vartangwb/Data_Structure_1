
package LeetCode.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
//https://segmentfault.com/a/1190000002625580?utm_source=tuicool
//http://blog.csdn.net/linhuanmars/article/details/20342851
public class Solution030 {

    public List<Integer> solve(String s, String[] t) {
        List<Integer> res = new ArrayList<>();
        int lent = t[0].length();
        int lens = s.length();
        Map<String, Integer> map = new HashMap<>();
        for(String ss:t){
            if(map.containsKey(ss)){
                map.put(ss, map.get(ss)+1);
            }else{
                map.put(ss, 1);
            }
        }
        for(int i = 0;i<lent;i++){
            int count = 0;
            Map<String, Integer> hm = new HashMap<>();
            int left = i;
            for(int j = i;j<=lens - lent;j+=lent){
                String currstr = s.substring(j, j+lent);
                if(map.containsKey(currstr)){
                    if(hm.containsKey(currstr)){
                        hm.put(currstr, hm.get(currstr)+1);
                    }else{
                        hm.put(currstr, 1);
                    }
                    count++;
                    if(hm.get(currstr)>map.get(currstr)){
                        while(true){
                            String tmp = s.substring(left, left+lent);
                            hm.put(tmp, hm.get(tmp)-1);
                            count--;
                            left+=lent;
                            if(tmp.equals(currstr)){
                                break;
                            }
                        }
                    }
                    if(count == t.length){
                        res.add(left);
                        String rr = s.substring(left, left+lent);
                        hm.put(rr, hm.get(rr) - 1);
                        left += lent;
                        count--;
                    }
                }else{
                    hm.clear();
                    count = 0;
                    left=j+lent;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Solution030 solution044 = new Solution030();
        System.out.println(solution044.solve("dabcdefghkabcdef", new String[]{"abc", "def"}));
    }

}
