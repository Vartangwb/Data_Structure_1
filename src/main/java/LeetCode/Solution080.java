
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution080 {

    ListNode removeRep(ListNode head){
        ListNode newHead = new ListNode(0);
        ListNode n1 = newHead;
        ListNode n2 = head;
        while(n2!=null){
            boolean flag = false;
            while(n2.next!=null && n2.next.data == n2.data){
                flag = true;
                n2 = n2.next;
            }
            if(flag) {
                n2 = n2.next;
                continue;
            }
            n1.next = n2;
            n2 = n2.next;
            n1 = n1.next;


        }
        n1.next = n2;
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution080 solution216 = new Solution080();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);


    }


}
