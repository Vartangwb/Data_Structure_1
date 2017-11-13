package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-10 14:46
 **/
public class Solution356 {

    public boolean isReflected(int[][] points){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        Set<String> set = new HashSet<>();
        for(int[] point : points){
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(point[0] + " " + point[1]);
        }
        sum=max+min;
        for(int[] point:points){
            if(!set.contains(sum - point[0] + " "+point[1]))
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Solution356 solution228 = new Solution356();
        }

}
