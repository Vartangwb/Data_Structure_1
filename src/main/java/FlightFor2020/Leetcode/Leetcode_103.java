package FlightFor2020.Leetcode;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty())
        {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if(depth %2 == 0)
                {
                    tmp.add(node.val);

                }
                else
                    tmp.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            res.add(tmp);
            depth++;

        }
        return res;
    }
}
