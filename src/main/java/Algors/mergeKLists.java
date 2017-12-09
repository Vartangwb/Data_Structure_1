package Algors;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-28 19:01
 **/
public class mergeKLists {

    public ListNode mergeKLists(List<ListNode> lists){
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(3, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.data - o2.data;
            }
        });
        for(int i = 0;i<lists.size();i++){
            ListNode node = lists.get(i);
            if(node!=null)
                priorityQueue.add(node);
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(priorityQueue.size()>0){
            ListNode tmp = priorityQueue.poll();
            ListNode newone = tmp.next;
            tmp.next = null;
            curr.next = tmp;
            curr = curr.next;
            if(newone!=null){
                priorityQueue.add(newone);
            }
        }
        return head.next;
    }



    public static void main(String[] args) {
        mergeKLists kmp  = new mergeKLists();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(6);
        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(8);
        head2.next.next = new ListNode(9);
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        listNodes.add(head1);
        listNodes.add(head2);
        ListNode.print(kmp.mergeKLists(listNodes));
    }

}
