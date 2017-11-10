
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution095 {


    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0)
            return res;
        res = helper(1,n);
        return res;
    }

    public static List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end) {
            res.add(null);
            return res;
        }
        if(start==end) {
            res.add(new TreeNode(start));
            return res;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            for(TreeNode l:left)
                for(TreeNode r:right){

                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);

                }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution095 solution274 = new Solution095();
        solution274.generateTrees(9);
    }


}
