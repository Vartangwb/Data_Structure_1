package LintCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution081
 *
 * @author tangwenbo
 * @create 2017-10-11 10:31
 **/
//https://segmentfault.com/a/1190000003709954
public class Solution081 {

    public int[] medianII(int[] nums) {
        // write your code here
        if(nums.length <= 1)
            return nums;
        int res[] = new int[nums.length];

        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        maxQueue.offer(Math.min(nums[0], nums[1]));
        minQueue.offer(Math.max(nums[0], nums[1]));
        res[0] = res[1] = Math.min(nums[0], nums[1]);

        for(int i = 2;i<nums.length;i++){
            int minTop = minQueue.peek();
            int maxTop = maxQueue.peek();
            int curr = nums[i];
            if(curr < maxTop){
                if(maxQueue.size() <= minQueue.size()){
                    maxQueue.offer(curr);
                }else{
                    minQueue.offer(maxQueue.poll());
                    maxQueue.offer(curr);
                }
            }else if(curr>=maxTop && curr<=minTop){
                if(maxQueue.size()<=minQueue.size()){
                    maxQueue.offer(curr);
                }else{
                    minQueue.offer(curr);
                }
            }else{
                if(minQueue.size()<=maxQueue.size()){
                    minQueue.offer(curr);
                }else{
                    maxQueue.offer(minQueue.poll());
                    minQueue.offer(curr);
                }
            }
            if(maxQueue.size() == minQueue.size()){
                res[i] = (maxQueue.peek() + minQueue.peek())/2;

            }else if(maxQueue.size()>minQueue.size()){
                res[i] = maxQueue.peek();
            }else{
                res[i] = minQueue.peek();
            }

        }

        return res;
    }

}
