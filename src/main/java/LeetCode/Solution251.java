
package LeetCode;

import java.util.Iterator;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution251 {

    public class Vector2D{
        List<Iterator<Integer>> iterators;
        int lineIndex;
        List<List<Integer>> lists;
        public Vector2D(List<List<Integer>> vec2d) {
            lists = vec2d;
            lineIndex = 0;
            for(int i = 0;i<lists.size();i++){
                iterators.add(lists.get(i).iterator());
            }
        }
        public int next(){
            return iterators.get(lineIndex).next();
        }

        public boolean hasNext(){
            while(lineIndex < lists.size()){
                if(iterators.get(lineIndex).hasNext()){
                    return true;
                }else{
                    lineIndex++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution251 solution216 = new Solution251();
    }


}
