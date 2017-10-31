package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-28 14:39
 **/
public class Solution666 {

    int res = 0;
    public int pathSum(int[] arr){
        int len = arr.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i<len;i++){
            hm.put(arr[i]/10, arr[i]%10);
        }
        helper(arr[0]/10, hm, arr, 0);
        return res;
    }

    public void helper(int num, Map<Integer, Integer> hm, int[] arr, int currsum){
        int level = num/10;
        int pos = num%10;
        int left = (level+1) * 10 + 2*pos - 1;
        int right = left+1;
        currsum+=hm.get(num);
        if(hm.get(left)==null && hm.get(right) == null){
            res+=currsum;
            return;
        }
        if(hm.get(left)!=null)
            helper(left, hm, arr, currsum);
        if(hm.get(right)!=null)
            helper(right, hm, arr, currsum);
    }

    public int copy(int n){
        int dp[] = new int[n+1];
        for(int i = 1;i<=n;i++){
            dp[i] = i;
            for(int j = 3;j<i;j++){
                dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution666 solution666 = new Solution666();
        System.out.println(solution666.pathSum(new int[]{113, 215, 221}));
        System.out.println(solution666.copy(3));
    }
}
