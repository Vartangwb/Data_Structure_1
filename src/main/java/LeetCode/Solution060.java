
package LeetCode;

import java.util.Arrays;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution060 {
//http://blog.csdn.net/doc_sgl/article/details/12840715
    public String getPermutation(int n, int k){
        int nums [] = new int[n];
        int pre = 1;
        k--;
        for(int i = 1;i<n;i++){
            pre*=(i+1);
        }
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        String res = "";
        for(int i = 0; i<n;i++){
            pre = pre/(n-i);
            int selected = k/pre;
            res += nums[selected] ;
            for(int j = selected;j<n-1;j++){
                nums[j] = nums[j+1];
            }
            k%=pre;
        }
        return res;
    }

    public String nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len-1;
        for(;index>0;index--){
            if(nums[index] > nums[index - 1])
                break;
        }
        if(index == 0){
            Arrays.sort(nums);
            return nums.toString();
        }
        int indexx = index - 1;
        System.out.println("indexx" + indexx);
        int curr = len-1;
        while(curr>indexx){
            if(nums[curr]>nums[indexx])
                break;
            else
                curr--;
        }
        int tmp = nums[curr];
        nums[curr] = nums[indexx];
        nums[indexx] = tmp;

        Arrays.sort(nums, index, len);
        for(int i = 0;i<len;i++){
            System.out.println(nums[i]);
        }
        return null;
    }


    public static void main(String[] args) {
        Solution060 solution216 = new Solution060();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        int[][] arr = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(solution216.nextPermutation(new int[]{1,2,3,5,4}));
    }


}
