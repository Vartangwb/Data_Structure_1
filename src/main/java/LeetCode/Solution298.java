
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution298 {
    int res = 0;
    int longestConsecutive(TreeNode root){
        if(root == null)
            return 0;
        helper(root, root.val, 0);
        return res;
    }
    public void helper(TreeNode root, int parVal, int cnt){
        if(root == null)
            return;
        if(root.val == parVal + 1)
            cnt++;
        res = Math.max(res, cnt);
        helper(root.left, root.val, cnt);
        helper(root.right, root.val, cnt);
    }

    public static void main(String[] args) {
        Solution298 solution216 = new Solution298();
        //solution216.combinationSum3(3, 9);
    }


}
