package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-10 14:46
 **/
public class Solution228 {

    public List<String> summaryRanges(int[] nums){
        List<String> ls = new ArrayList<>();
        for(int i = 0;i<nums.length;i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            int j = i+1;
            while(j<=nums.length){
                if(j!=nums.length && nums[j] - nums[j-1] == 1){
                    j++;
                }else{
                    if(j==i+1){
                        ls.add(sb.toString());
                    }else{
                        i = j-1;
                        ls.add(sb.append("->").append(nums[i]).toString());
                    }
                    break;
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        Solution228 solution228 = new Solution228();
        System.out.println(solution228.summaryRanges(new int[]{0,2,3,4,5,6,8,9}));
    }

}
