
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, res, new ArrayList<>(), 0, k, 0, 1);
        System.out.println(res);
        return res;
    }
    public void helper(int n, List<List<Integer>> res, List<Integer> currList, int currSum, int k, int currNum, int index){
        if(currNum == k){
            if(currSum == n){
                res.add(new ArrayList<>(currList));
                return;
            }
            return;
        }

        for(int i = index;i<=9;i++){
            currList.add(i);
            helper(n, res, currList, currSum+i, k, currNum+1, i+1);
            currList.remove(currList.size() - 1);
        }

    }

    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        solution216.combinationSum3(3, 9);
    }


}
