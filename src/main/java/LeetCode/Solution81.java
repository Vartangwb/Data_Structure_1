
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution81 {

     public static boolean search(int[] nums, int target){
         int left = 0;
         int right = nums.length - 1;
         while(left <= right){
             int mid = (left + right) / 2;
             if(nums[mid] == target)
                 return true;
             if(nums[left] < nums[mid]){
                 if(target >= nums[left] && target < nums[mid]){
                     right = mid - 1;
                 }else{
                     left = mid + 1;
                 }
             }else if(nums[left] > nums[mid]){
                 if(target > nums[mid] && target<=nums[right]){
                     left = mid+1;
                 }else{
                     right = mid-1;
                 }
             }else {
                 if(nums[left] == target){
                     return true;
                 }
                 left ++;
             }
         }
         return false;
     }

    public static void main(String[] args) {
        Solution81 solution216 = new Solution81();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);


    }


}
