
package LeetCode;

import java.util.*;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-08 15:17
 **/
public class Solution207{

    public boolean canFinish(int numCourses, int[][] pre){
        Map<Integer, List<Integer>> arr = new HashMap<>();
        int[] in = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<pre.length;i++){
            if(arr.get(pre[i][1]) != null){
                arr.get(pre[i][1]).add(pre[i][0]);
                in[pre[i][0]]++;
            }else{
                List<Integer> ls = new ArrayList<>();
                ls.add(pre[i][0]);
                arr.put(pre[i][1], ls);
                in[pre[i][0]] ++;
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(in[i] == 0)
                queue.add(i);
        }

        List<Integer> lss = new ArrayList<>();
        while(queue.size()>0){
            int num = queue.poll();
            lss = arr.get(num);
            if(lss!=null){
                for(int i:lss){
                    in[i]--;
                    if(in[i] == 0)
                        queue.add(i);
                }
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(in[i]!=0){
                return false;
            }
        }
        return true;

    }


}
