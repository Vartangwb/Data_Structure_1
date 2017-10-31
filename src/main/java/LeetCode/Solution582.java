package LeetCode;
import java.util.*;


/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill){
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<pid.size();i++){
            if(map.get(ppid.get(i)) == null){
                map.put(ppid.get(i), new ArrayList<>());
                map.get(ppid.get(i)).add(pid.get(i));
            }else{
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        queue.add(kill);
        while(queue.isEmpty() == false){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int curr = queue.peek();
                queue.poll();
                res.add(curr);
                for(int id:map.get(curr))
                    queue.add(id);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution582 solution281 = new Solution582();
    }

}
