
package LeetCode;

import java.util.Stack;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution388 {


    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\\n");
        Stack<Integer> stc = new Stack<>();
        int currLen = 0;
        int res = 0;
        for(int i = 0;i<tokens.length;i++){
            int len = getLen(tokens[i]);
            while(stc.size() > len){
                currLen -=stc.pop();
            }
            currLen+=tokens[i].replaceAll("\t","").length()+1;
            if(tokens[i].contains(".")){
                res = res>(currLen-1)?res:(currLen-1);
            }
            stc.add(tokens[i].replaceAll("\t","").length()+1);
        }
        return res;

    }
    public int getLen(String s){
        return s.length() - s.replaceAll("\\t","").length();
    }

    public static void main(String[] args) {
        Solution388 solution274 = new Solution388();
        System.out.println(solution274.getLen("\t123"));
    }


}
