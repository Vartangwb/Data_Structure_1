
package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution210 {

    public int[] findOrder(int numCourses, int[][] pres){
        Map<Integer, List<Integer>> map = new HashMap<>();
        int in[] = new int[numCourses];
        for(int[] pre : pres){
            int num1 = pre[0];
            int num2 = pre[1];
            in[num1]++;
            if(!map.containsKey(num2)){
                List<Integer> ls = new ArrayList<>();
                ls.add(num1);
                map.put(num2, ls);

            }else{
                map.get(num2).add(num1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int ii : in){
            if(ii == 0){
                queue.add(ii);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(queue.isEmpty() == false){
            int num = queue.poll();
            list.add(num);
            List<Integer> tmp = map.get(num);
            if(tmp!=null)
            for(int ala : tmp){
                in[ala]--;
                if(in[ala] == 0){
                    queue.add(ala);
                }
            }
        }
        for(int ii : in){
            if(ii!=0){
                return null;
            }
        }
        System.out.println(list);
        return null;
    }



    public static void main(String[] args) {
        Solution210 solution216 = new Solution210();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        int[][] arr = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        solution216.findOrder(4, arr);
    }


}
