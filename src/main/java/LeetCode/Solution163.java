
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution163 {

    public List<String> solve(int[] nums, int begin, int end){

        int pre = begin - 1;
        int curr = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0;i<=nums.length;i++){
            curr = i==nums.length?end+1:nums[i];
            if(pre!=curr-1){
                if(curr-1 == pre+1){
                    list.add(curr-1 + "");
                }else{
                    list.add(pre+1 + "->" + (curr-1));
                }
            }
            pre = curr;
        }

        return list;
    }
    public static void main(String[] args) {
        Solution163 solution216 = new Solution163();
        System.out.println(solution216.solve(new int[]{1,3,4}, 1, 7));
    }


}
