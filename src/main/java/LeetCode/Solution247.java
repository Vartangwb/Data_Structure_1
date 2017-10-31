
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution247 {
    List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int m, int n){
        if(m == 0){
            return new ArrayList<>();
        }
        if(m == 1){
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            list.add("8");
            return list;
        }
        List<String> ll = helper(m - 2, n);
        List<String > res = new ArrayList<>();
        for(String l : ll){
            if(m!=n){
                res.add("0"+l+"0");
            }
            res.add("1"+l+"1");
            res.add("9"+l+"6");
            res.add("6"+l+"9");
            res.add("8"+l+"8");

        }
        return res;
    }

    public static void main(String[] args) {
        Solution247 solution216 = new Solution247();
        System.out.println(solution216.findStrobogrammatic( 9));
    }


}
