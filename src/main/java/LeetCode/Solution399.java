
package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution399 {
    HashMap<String, List<Info>> hashMap = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // build graph, use adjacent list
        for(int i = 0; i < equations.length; i++){
            String[] equation = equations[i];
            if(hashMap.containsKey(equation[0]))
                hashMap.put(equation[0], new ArrayList<>());
            hashMap.get(equation[0]).add(new Info(equation[1], values[i]));
            if(hashMap.containsKey(equation[1]))
                hashMap.put(equation[1], new ArrayList<>());
            hashMap.get(equation[1]).add(new Info(equation[0], 1 / values[i]));

        }
        double[] res = new double[queries.length];
        for(int i = 0;i < res.length; i++){
            res[i] = find(queries[i][0], queries[i][1], 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double value, Set<String> visited){
        if(visited.contains(start))
            return -1;
        if(! hashMap.containsKey(start))
            return -1;
        if(start.equals(end))
            return value;
        visited.add(start);
        for(Info next : hashMap.get(start)){
            double sub = find(next.den, end, value * next.val, visited);
            if(sub != -1.0)
                return sub;
        }
        visited.remove(start);
        return -1;
    }

    class Info{
        String den;
        double val;
        Info(String den, double val){
            this.den = den;
            this.val = val;
        }
    }
        public static void main(String[] args) {
        Solution399 solution216 = new Solution399();
    }


}
