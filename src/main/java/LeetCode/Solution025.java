
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution025 {

     public ListNode reverseKGroup(ListNode head, int k){
         ListNode curr = head;
         for(int i = 0;i<k;i++){
             if(curr == null){
                 return head;
             }
             curr = curr.next;
         }
         ListNode new_head = reverse(head, curr);
         head.next = reverseKGroup(curr, k);
         return new_head;
     }

     ListNode reverse(ListNode head, ListNode tail){
         ListNode pre = tail;
         ListNode helper = new ListNode(0);
         while(head != tail){
             ListNode t = head.next;
             head.next = helper.next;
             helper.next = head;
             head = t;
         }
         return helper.next;
     }

    public static void main(String[] args) {
        Solution025 solution216 = new Solution025();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        ListNode.print(solution216.reverseKGroup(root, 2));

    }


}
