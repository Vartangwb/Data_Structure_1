package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution285 {

    public TreeNode solve(TreeNode root, TreeNode p){
        if(p.right != null){
            TreeNode mm = p.right;
            while(mm.left!=null){
                mm = mm.left;
            }
            return mm;
        }else{
            TreeNode pre = null;
            while(root!=p){
                if(root.val<p.val){
                    root = root.right;
                }else if(root.val>p.val){
                    pre = root;
                    root = root.left;

                }
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        Solution285 solution285 = new Solution285();
        solution285.solve(new TreeNode(1), new TreeNode(1));
    }

}
