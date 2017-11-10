package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution373 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[0];
            }
        });
        queue.add(new int[]{nums1[0], nums2[0]});
        int num = 1;
        int index = 0;
        while(num<k){

        }
        return null;
    }


    public static void main(String[] args) {
        Solution373 solution281 = new Solution373();
    }

}
