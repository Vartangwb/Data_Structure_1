
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution652 {

    List<TreeNode> findDuplicateSubtrees(TreeNode root){

        Map<String, List<TreeNode>> map = new HashMap<>();
        helper(root, map);
        List<TreeNode> list = new ArrayList<>();
        for(Map.Entry<String, List<TreeNode>> entry : map.entrySet()){
            if(entry.getValue().size()>1){
                list.add(entry.getValue().get(0));
            }
        }
        return list;

    }

    public String helper(TreeNode root, Map<String, List<TreeNode>> map){
        if(root == null)
            return "";
        String left = helper(root.left, map);
        String right = helper(root.right, map);
        String rootstr = "(" + left + root.val + right + ")";
        if(map.containsKey(rootstr)){
            map.get(rootstr).add(root);
        }else{
            List<TreeNode> tmp = new ArrayList<>();
            tmp.add(root);
            map.put(rootstr, tmp);
        }
        return rootstr;
    }

    public static void main(String[] args) {
        Solution652 solution216 = new Solution652();

    }


}
