
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution114 {

     public void solve(TreeNode root){
         while(root!=null){
             if(root.left!=null){
                 TreeNode tmp = root.left;
                 while(tmp.right!=null){
                     tmp = tmp.right;
                 }
                 tmp.right = root.right;
                 root.right = root.left;
                 root.left = null;
             }
             root = root.right;
         }
     }

    public static void main(String[] args) {
        Solution114 solution216 = new Solution114();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);


    }


}
