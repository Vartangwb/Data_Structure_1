
package LeetCode;

import java.util.Arrays;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution698 {

    public boolean canPartitionKSubsets(int[] arr, int k){
        Arrays.sort(arr);
        int arr2[] = new int[arr.length];
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            arr2[i] = arr[arr.length - i - 1];
            sum+=arr2[i];
        }
        if(sum%k!=0)
            return false;
        helper(arr2, sum/k, 0, new int[k]);
        return kk;
    }
    boolean kk = false;
    public void helper(int[] arr2, int target, int index, int res[]){
        if(kk == true)
            return ;
        if(index == arr2.length){
            for(int i = 0;i<res.length;i++){
                if(res[i]!=target)
                    return;
            }
            kk = true;
            return;
        }
        for(int i = 0;i<res.length;i++){
            res[i]+=arr2[index];
            helper(arr2, target, index+1, res);
            res[i]-=arr2[index];
        }
    }


    public static void main(String[] args) {
        Solution698 solution274 = new Solution698();
        System.out.println(solution274.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println();
    }


}
