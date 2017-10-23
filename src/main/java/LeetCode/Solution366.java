package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        helper(list, root);
        return list;
    }
    public int helper(List<List<Integer>> list, TreeNode root){
        if(root == null)
            return -1;
        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int depth = 1 + Math.max(left, right);
        if(list.size() == depth){
            list.add(new ArrayList<Integer>());
        }
        list.get(depth).add(root.val);
        return depth;
    }
    //https://segmentfault.com/a/1190000003783283
    public void wiggleSort(int[] nums) {
        // 先将数组排序
        Arrays.sort(nums);
        // 将数组中一对一对交换
        for(int i = 2;i<nums.length;i++){
            int tmp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = tmp;
        }

    }

    //range addition
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for(int i=0; i<updates.length; i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int k = updates[i][2];
            array[start] +=k;
            if(end+1<array.length){
                array[end+1] -= k;
            }
        }
        for(int i=1; i<array.length; i++){
            array[i] += array[i-1];
        }
        return array;
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        List<Integer> ls = new ArrayList<Integer>();
        queue.add(root);
        while(queue.isEmpty()==false){
            int size = queue.size();
            ls.clear();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                ls.add(curr.val);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }

        }
        return ls.get(0);
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> ls = new ArrayList<int[]>();
        for(int i = 0;i<people.length;i++){
            ls.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        for(int i = 0;i<people.length;i++){
            people[i][0] = ls.get(i)[0];
            people[i][1] = ls.get(i)[1];

        }
        return people;
    }
    public int countSubstrings(String s) {
        if (s.equals("")) {
            return 0;
        }
        int len = s.length();
        int count = 0;
        boolean dp[][] = new boolean[len][len];
        for(int i = 0;i<len;i++){
            dp[i][i] = true;
        }
        count+=len;
        for(int l = 1;l<len;l++){
            for(int i = 0;i<len - l;i++){
                int j = i+l;
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }
                else{

                    dp[i][j]=((i+1>=j-1) || dp[i+1][j-1]);
                    if(dp[i][j]==true){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(mid == 0 && nums[mid] != nums[mid+1])
                return nums[mid];
            else
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            else if((nums[mid] == nums[mid+1] && mid % 2 == 0) || (nums[mid] == nums[mid-1] && mid % 2 == 1))
                left = mid+1;
            else
                right = mid-1;
        }
        return nums[left];
    }
    int carry = 1;
    ListNode plusOne(ListNode head) {
        int date = helper(head);
        ListNode dd = new ListNode(0);
        if(date == 1) {
            dd.data = 1;
            dd.next = head;
            return dd;
        }else{
            return head;
        }
    }
    public int helper(ListNode head){
        if(head == null)
            return 1;
        int tmp = helper(head.next);
        int sum = tmp + head.data;
        head.data = sum%10;
        carry = sum/10;
        return carry;

    }
        public static void main(String[] args) {
        Solution366 solution366 = new Solution366();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution366.findLeaves(root));
        System.out.println(solution366.findBottomLeftValue(root));
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(0,1);
        ls.add(0,2);
        System.out.println(ls);
        System.out.println(solution366.countSubstrings("aaa") +"asda");
        System.out.println(solution366.singleNonDuplicate(new int[]{2,2,3,3,1}));
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        solution366.plusOne(head);
        ListNode.print(head);
        String res = "";
        
    }
}
