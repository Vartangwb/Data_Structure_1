package LeetCode;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-23 14:46
 **/
public class ListNode {
    public ListNode next;
    public int data;

    public ListNode(int data) {
        this.data = data;
    }
    public static void print(ListNode head){
        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
