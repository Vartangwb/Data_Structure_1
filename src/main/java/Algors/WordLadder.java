package Algors;

import java.util.*;

/**
 * WordLadder
 *
 * @author tangwenbo
 * @create 2017-11-28 19:01
 **/
public class WordLadder {

    public int getShortestLen(String begin, String end, Set<String> set){
        if(begin.equals(end))
            return 0;
        int currLevel = 1;
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        queue.add(begin);
        map.put(begin, 1);
        set.remove(begin);
        while(!queue.isEmpty()){
            String first = queue.poll();
            int currLen = map.get(first) + 1;
            char[] curr = first.toCharArray();

            for(int i = 0;i<curr.length;i++){
                char tmp = curr[i];
                for(int j = 0;j<26;j++){
                    if(tmp == 'a'+j)
                        continue;
                    curr[i] = (char)('a'+j);
                    String temp = new String(curr);
                    if(temp.equals(end)){
                        return currLen;
                    }
                    if(set.contains(temp)){
                        set.remove(temp);
                        queue.add(temp);
                        map.put(temp, currLen);
                    }
                }
                curr[i] = tmp;
            }
        }
        return 0;
    }
}
