
package LeetCode;

import java.util.Arrays;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution015 {


    public void threeSum(int[] nums, int target){
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<len-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int j = i+1;
            int k = len-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==target){
                    System.out.println(nums[i]);

                j++;
                k--;
                while(j<k && nums[j]==nums[j-1])
                    j++;
                while(j<k && nums[k]==nums[k+1])
                    k--;
                }else if(nums[i]+nums[j]+nums[k]>target){
                    k--;
                }else{
                    j++;
                }
            }
        }
    }

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2;i <=n;i++){
            if(Integer.parseInt(s.substring(i-2, i))>=10 && Integer.parseInt(s.substring(i-2, i))<=26){
                dp[i] = dp[i-2]+dp[i];
            }
            if(Integer.parseInt(s.substring(i-1, i))!=0)
                dp[i] = dp[i-1]+dp[i];
        }
        return dp[n];
    }
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;

        int flag = 1;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            flag = -1;
        }
        long top = Math.abs((long)dividend);
        long bom = Math.abs((long)divisor);
        if(dividend == 0 || top < bom)
            return 0;
        long res = divide1(top, bom);

        int ans;
        if(res >Integer.MAX_VALUE)
            ans = (flag == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else
            ans = (int) (flag * res);
        return ans;
    }
    public long divide1(long top, long bom){
        if(top < bom)
            return 0;
        System.out.println("top:"+top);
        System.out.println("bom:"+bom);
        long sum = bom;
        long tmp = 1;
        while((sum + sum) < top){
            sum += sum;
            System.out.println("sum:"+sum);
            tmp +=tmp;
            System.out.println("tmp:"+tmp);
        }

        return tmp + divide1(top - sum, bom);
    }

    public static void main(String[] args) {
        Solution015 solution216 = new Solution015();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        System.out.println(solution216.numDecodings("01"));
        solution216.divide1(20, 2);
    }


}
