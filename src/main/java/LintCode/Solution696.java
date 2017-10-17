package LintCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution696
 *
 * @author tangwenbo
 * @create 2017-10-10 15:19
 **/
public class Solution696 {

    public int scheduleCourse(int[][] courses) {
        // write your code here
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int len = courses.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(len, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int time = 0;
        for(int[] i : courses){
            priorityQueue.add(i[0]);
            time += i[0];
            if(time > i[1]){
                time -= priorityQueue.poll();
            }
        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        Solution696 solution696 = new Solution696();
        System.out.println(solution696.scheduleCourse(new int[][]{{100, 200},{200,1300},{1000,1250},{2000, 3200}}));
    }

}
