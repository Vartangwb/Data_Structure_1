package LeetCode;

/**
 * tree ตÝน้
 *
 * @author tangwenbo
 * @create 2017-10-16 20:59
 **/
public class Solution669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }

    public TreeNode helper(TreeNode root, int L, int R){
        if(root == null)
            return null;
        if(root.val<L){
            return helper(root.right, L, R);
        }
        if(root.val>R)
            return helper(root.left, L, R);
        root.left = helper(root.left, L,R);
        root.right = helper(root.right,L,R);
        return root;

    }



}
