package Algors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-08 11:21
 **/
public class MergeIntervel {


    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        for(i = 0;i<intervals.size();i++){
            if(intervals.get(i).start<newInterval.start){
                res.add(intervals.get(i));
            }else{
                break;
            }
        }
        if(res.size()==0){
            res.add(newInterval);
        }else if(res.get(res.size()-1).end<newInterval.start){
            res.add(newInterval);
        }else{
            Interval interval = new Interval();
            interval.start = res.get(res.size()-1).start;
            interval.end = Math.max(res.get(res.size()-1).end, newInterval.end);
            res.remove(res.size()-1);
            res.add(interval);
        }
        for(;i<intervals.size();i++){
            if(res.get(res.size()-1).end>=intervals.get(i).start){
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Interval interval1  = new Interval(1,3);
        Interval interval2 = new Interval(6,8);
        Interval interval3 = new Interval(5,9);
        MergeIntervel mergeIntervel = new MergeIntervel();
        System.out.println(mergeIntervel.insert(Arrays.asList(interval1, interval2), interval3).size());

    }


}
