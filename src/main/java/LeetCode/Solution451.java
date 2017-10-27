package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution451 {

    public String frequencySort(String s){

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int len = s.length();
        for(int i = 0;i < len;i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }else{
                hm.put(s.charAt(i), 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {

                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        if(o1.getValue() == o2.getValue()){
                            return o1.getKey() - o2.getKey();
                        }else
                            return o2.getValue() - o1.getValue();
                    }
                }
        );

        for(Map.Entry<Character, Integer> entry : hm.entrySet()){
            priorityQueue.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry e = priorityQueue.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();


    }
    public static void main(String[] args) {
        Solution451 solution281 = new Solution451();
    }

}
