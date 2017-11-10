

package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution277 {


    public int getTarget(int n){
        boolean dp[] = new boolean[n];
        Arrays.fill(dp, true);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(dp[i] && i != j)
                if(knows(i, j) || !knows(j, i)){
                    dp[i] = false;
                    break;
                }else{
                    dp[j] = false;
                }
            }
            if(dp[i] == true){
                return i;
            }
        }
        return -1;
    }
    public boolean knows(int i, int j){
        return true;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int a : arr) {
            int abs = Math.abs(a - x);
            if (!map.containsKey(abs)) map.put(abs, new LinkedList<>());
            map.get(abs).add(a);
        }
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            for (int i : e.getValue()) {
                result.add(i);
                if (result.size() == k) break;
            }
            if (result.size() == k) break;
        }
        Collections.sort(result);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        Solution277 solution277 = new Solution277();
        solution277.findClosestElements(new int[]{1,2,3,4,5}, 4, -1);
    }


}
