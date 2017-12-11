package Algors;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-08 10:52
 **/

//https://segmentfault.com/a/1190000003709954
public class PriorityQueues {

    PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });

    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void putNum(int num){
        if(minQueue.size()==0 || num>=minQueue.peek()){
            if(minQueue.size()>maxQueue.size()){
                maxQueue.offer(minQueue.poll());
            }
            minQueue.offer(num);
        }else if(maxQueue.size()==0 || num<=maxQueue.peek()){
            if(maxQueue.size()>minQueue.size()){
                minQueue.offer(maxQueue.poll());
            }
            maxQueue.offer(num);
        }else{
            if(maxQueue.size() <= minQueue.size()){
                maxQueue.offer(num);
            } else {
                minQueue.offer(num);
            }
        }
    }

    public double getNum(){
        // 返回大小较大的那个堆堆顶，如果大小一样说明是偶数个，则返回堆顶均值
        if(maxQueue.size() > minQueue.size()){
            return maxQueue.peek();
        } else if (maxQueue.size() < minQueue.size()){
            return minQueue.peek();
        } else if (maxQueue.isEmpty() && minQueue.isEmpty()){
            return 0;
        } else {
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        PriorityQueues priorityQueues = new PriorityQueues();
        priorityQueues.putNum(1);
        priorityQueues.putNum(2);
        priorityQueues.putNum(3);
        System.out.println(priorityQueues.getNum());
        System.out.println(Arrays.stream(priorityQueues.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        double res[] = new double[len];
        //两个堆，一个最大堆，一个最小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(maxHeap.size() == 0 || maxHeap.peek() >= num){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            if(minHeap.size()>maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.size()>minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }
            if(i-k+1>=0){
                if(k%2==1){
                    res[i-k+1]=maxHeap.peek();
                }else{
                    res[i-k+1]=(maxHeap.peek()/2.0+minHeap.peek()/2.0);
                }
                int toBeRemove = nums[i-k+1];
                if(toBeRemove<=maxHeap.peek()){
                    maxHeap.remove(toBeRemove);
                }else{
                    minHeap.remove(toBeRemove);
                }
                if( minHeap.size() > maxHeap.size() )
                    maxHeap.add(minHeap.poll());
                if( maxHeap.size() > minHeap.size() + 1 )
                    minHeap.add(maxHeap.poll());
            }
        }
        return res;
    }


}
