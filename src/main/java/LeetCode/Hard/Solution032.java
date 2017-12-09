
package LeetCode.Hard;

import java.util.*;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
//https://segmentfault.com/a/1190000002625580?utm_source=tuicool
//http://blog.csdn.net/linhuanmars/article/details/20342851
public class Solution032 {


    public int solve(String s){
        Stack<pair> stack = new Stack<>();
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp == '('){
                stack.push(new pair('(', i));
            }else{
                if(!stack.isEmpty() && stack.peek().val=='('){
                    pair pp = stack.pop();
                    int currLen = 0;
                    if(stack.isEmpty()){
                        currLen = i+1;
                    }else{
                        currLen = i-stack.peek().index;
                    }
                    max = Math.max(max, currLen);
                }else{
                    stack.push(new pair(')',i));
                }
            }
        }
        return max;
    }

    class pair{
        char val;
        int index;
        public pair(char val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution032 solution044 = new Solution032();
        System.out.println(solution044.solve("))()()))("));
    }

}
