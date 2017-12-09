package Algors;

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
    }

}
