package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution544 {

    public String findContestMatch(int n){
        List<String> v = new ArrayList<String>();
        for(int i = 1;i<=n;i++){
            v.add(String.valueOf(i));
        }
        while(n>1){
            for(int i = 0;i<n/2;i++){
                String ss = "(" + v.get(i) + "," + v.get(n-i-1)+")";
                v.set(i, ss);
            }
            n /= 2;
        }
        return v.get(0);
    }

    public static void main(String[] args) {
        Solution544 solution544 = new Solution544();
        System.out.println(solution544.findContestMatch(8));
    }
}
