package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution281 {

    public class ZigzagIterator {

        public List<Iterator<Integer>> iterators = new ArrayList<Iterator<Integer>>();
        int count = 0;

        public ZigzagIterator(List<Integer> a, List<Integer> b){
            if(a.isEmpty() == false)
                iterators.add(a.iterator());
            if(b.isEmpty() == false)
                iterators.add(b.iterator());

        }

        public int next(){
            int x = iterators.get(count).next();
            if(iterators.get(count).hasNext() == false){
                iterators.remove(count);
            }else{
                count++;
            }
            if(iterators.size()!=0)
                count = count%iterators.size();
            return x;
        }

        public boolean hasNext(){
            return !iterators.isEmpty();
        }

    }

    public static void main(String[] args) {
        Solution281 solution281 = new Solution281();
    }

}
