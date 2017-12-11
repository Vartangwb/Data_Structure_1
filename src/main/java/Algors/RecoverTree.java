package Algors;

import LeetCode.TreeNode;

import java.util.ArrayList;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-11 11:40
 **/
//http://blog.csdn.net/linhuanmars/article/details/24566995
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        ArrayList<TreeNode> pre = new ArrayList<>();
        pre.add(null);
        ArrayList<TreeNode> res = new ArrayList<>();
        helper(root, pre, res);
        if(res.size()>0){
            int tmp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val = tmp;
        }
    }

    public void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res){
        if(root == null)
            return;
        helper(root.left, pre, res);
        if(pre.get(0)!=null && pre.get(0).val> root.val){
            if(res.size()==0){
                res.add(pre.get(0));
                res.add(root);
            }else{
                res.set(1,root);
            }
        }
        pre.set(0, root);
        helper(root.right, pre, res);
    }

    public static void main(String[] args) {
        RecoverTree recoverTree = new RecoverTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        recoverTree.recoverTree(root);
    }
}
