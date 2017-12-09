
package LeetCode.Hard;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
//https://www.cnblogs.com/weedboy/p/7204529.html
public class Solution644 {


    public double solve(int[] nums, int k){
        double maxSum = 0;
        int sum = 0;
        int len = 0;
        int index = 0;
        int maxLen = 0;
        for(int i = 0;i<k;i++){
            sum+=nums[i];
        }
        len = k;
        maxSum = sum/k;
        for(int i = k;i<nums.length;i++){
            sum+=nums[i];
            len++;
            maxSum = Math.max(maxSum, sum/len);
            int tmpSum = sum;

            for(int j = len-1;j>=k;j--){
                tmpSum-=nums[i-j];
                maxSum = Math.max(maxSum, tmpSum/j);
            }
        }
        return maxSum;
    }

    class pair{
        char val;
        int index;
        public pair(char val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution644 solution044 = new Solution644();
        System.out.println(solution044.solve(new int[]{1,2,3,4}, 3));
    }

}
