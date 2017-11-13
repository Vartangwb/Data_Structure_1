package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-10 14:46
 **/
public class Solution625 {

    public static int smallestFactorization(int a){
        List<Integer> res = new ArrayList<>();
        for(int i = 9;i>=2;i--){
            while(a%i==0){
                a = a/i;
                res.add(i);
            }
        }
        int ss = 0;
        for(int i = res.size() - 1; i >=0 ;i--){
            ss=ss*10+res.get(i);
        }
        return ss;
    }


    public static void main(String[] args) {
        Solution625 solution228 = new Solution625();
        System.out.println(solution228.smallestFactorization(48));
    }

}
