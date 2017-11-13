
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution148 {


    public ListNode sortList(ListNode head){

        if(head == null || head.next==null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;
        while(fast!=null && fast.next!=null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode head, ListNode slow){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(head != null && slow!=null){
            if(head.data<slow.data){
                curr.next = head;
                head = head.next;
            }else{
                curr.next = slow;
                slow = slow.next;
            }
            curr = curr.next;
        }
        if(head!=null)
            curr.next = head;
        if(slow!=null)
            curr.next = slow;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution148 solution216 = new Solution148();
        ListNode root = new ListNode(5);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);

        ListNode root2 = new ListNode(4);
        root2.next = new ListNode(5);
        root2.next.next = new ListNode(6);
        ListNode.print(solution216.sortList(root));
        //ListNode.print(solution216.merge(root, root2));
    }


}
