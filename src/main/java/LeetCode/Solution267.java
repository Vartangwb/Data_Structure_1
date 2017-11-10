
package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution267 {

    public class Solution {
        public List<String> generatePalindromes(String s) {
            List<String> ret = new ArrayList<String>();
            if (s == null || s.length() == 0) {
                return ret;
            }

            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (!map.containsKey(curr)) {
                    map.put(curr, 1);
                }
                else {
                    map.put(curr, map.get(curr) + 1);
                }
            }

            StringBuilder sb = new StringBuilder();
            String center = "";
            for (Character c : map.keySet()) {
                if (map.get(c) % 2 != 0) {
                    counter++;
                    if (counter > 1) {
                        return ret;
                    }
                    center = "" + c;
                }
                for (int i = 0; i < map.get(c) / 2; i++) {
                    sb.append(c);
                }
            }

            char[] nums = sb.toString().toCharArray();
            List<String> half = permutation(nums);
            for (String h : half) {
                ret.add(h + center + new StringBuilder(h).reverse());
            }
            return ret;
        }

        private List<String> permutation(char[] nums) {
            List<String> ret = new ArrayList<String>();
            if (nums.length == 0) {
                ret.add("");
                return ret;
            }
            Arrays.sort(nums);
            boolean[] mark = new boolean[nums.length];
            dfs(nums, mark, new StringBuilder(), ret);
            return ret;
        }

        private void dfs(char[] nums, boolean[] mark, StringBuilder path, List<String> ret) {
            if (path.length() >= nums.length) {
                ret.add(path.toString());
                return;
            }
            int len = path.length();
            for (int i = 0; i < nums.length; i++) {
                if (mark[i]) {
                    continue;
                }
                else if (i > 0 && nums[i] == nums[i - 1] && !mark[i - 1]) {
                    continue;
                }
                else {
                    path.append(nums[i]);
                    mark[i] = true;
                    dfs(nums, mark, path, ret);
                    path.setLength(len);
                    mark[i] = false;
                }
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        findLeftBound(root.left, res);
        findLeaves(root.left, res);
        findLeaves(root.right, res);
        findRightBound(root.right, res);
        return res;
    }

    private void findLeftBound(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            findLeftBound(root.left, res);
        } else {
            findLeftBound(root.right, res);
        }
    }

    private void findRightBound(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            findRightBound(root.right, res);
        } else {
            findRightBound(root.left, res);
        }
        res.add(root.val);
    }

    private void findLeaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        findLeaves(root.left, res);
        findLeaves(root.right, res);
    }

    public static void main(String[] args) {
        Solution267 solution216 = new Solution267();
        /*
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        //System.out.println(solution216.boundaryOfBinaryTree(root));
        solution216.boundaryOfBinaryTree(root);
    }


}
