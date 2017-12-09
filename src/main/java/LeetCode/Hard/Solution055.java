

package LeetCode.Hard;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution055 {

    public boolean canJump(int[] nums) {

        int len = nums.length;
        int reach = 0;
        for(int i = 0;i<len;i++){
            if(i<=reach)
                reach = Math.max(reach, i+nums[i]);
        }
        if(reach<nums.length-1)
            return false;
        return true;

    }

    public int canJumpii(int[] nums){
        int len = nums.length;
        int reach = 0;
        int lastReach = 0;
        int step = 0;
        for(int i = 0;i<len;i++){
            if(i<=reach){
                if(i>lastReach){
                    step++;
                    lastReach = reach;
                }
                reach = Math.max(reach, nums[i]+i);
            }
        }
        return step;
    }




    public static void main(String[] args) {
        Solution055 solution044 = new Solution055();
        System.out.println(solution044.canJump(new int[]{0,2,1,5}));
        System.out.println(solution044.canJumpii(new int[]{2,3,1,1,4}));
    }



}
