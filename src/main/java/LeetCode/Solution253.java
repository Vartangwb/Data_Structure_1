
package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution253 {

     public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Interval> list = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });
        List<List<Interval>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(list.get(0));
        for(int i = 1; i < list.size(); i++){
            int index = 0;
            for(index = 0;index<res.size();index++){
                if(list.get(i).start>res.get(index).get(res.get(index).size() - 1).end){
                    res.get(index).add(list.get(i));
                    break;
                }
            }
            if(index == res.size()){
                res.add(new ArrayList<>());
                res.get(index).add(list.get(i));
            }

        }
        return res.size();
    }

    public static void main(String[] args) {
        Solution253 solution216 = new Solution253();
        System.out.println(solution216.minMeetingRooms(new Interval[]{new Interval(0,30), new Interval(5, 10), new Interval(15, 20)}));
    }


}
