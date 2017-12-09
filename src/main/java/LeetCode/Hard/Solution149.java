package LeetCode.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution149 {

    public int maxPoints(int[][] points){
        int len = points.length;
        Map<Double, Integer> map = new HashMap<>();
        int dup = 0;
        int max = 0;
        for(int i = 0;i<len;i++){
            map.clear();
            for(int j = 0;j<len;j++){
                if(i == j)
                    continue;
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                    dup++;
                }else if(points[i][0] == points[j][0]) {
                    double xielv = Integer.MAX_VALUE;
                    map.put(xielv, map.getOrDefault(xielv, 0)+1);
                }else {
                    double xielv1 = (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    map.put(xielv1, map.getOrDefault(xielv1, 0)+1);
                }

            }
            if(map.size()==0){
                max = Math.max(max, dup);
            }else{
                for(Map.Entry entry : map.entrySet()){
                    max=Math.max(max, (int)entry.getValue()+ dup);
                }
            }
        }
        return max;
    }


}
