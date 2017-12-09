
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution061 {

    public ListNode rotateList(ListNode node, int k){
        ListNode newOne = node;
        int len = 0;
        ListNode tail = null;
        while(newOne!=null){
            len++;
            if(newOne.next==null)
                tail = newOne;
            newOne = newOne.next;
        }
        tail.next = node;
        k = k%len;
        for(int i = 0;i<len-k-1;i++){
            node = node.next;
        }
        newOne = node.next;
        node.next = null;
        return newOne;
    }

    public static void main(String[] args) {
        Solution061 solution216 = new Solution061();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        ListNode.print(solution216.rotateList(root, 2));
    }


}
