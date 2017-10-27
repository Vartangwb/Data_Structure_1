package LeetCode;

import java.util.Stack;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution439 {

    public String parseTernary(String expression){
        Stack<Character> ss = new Stack<Character>();
        int len = expression.length();
        for(int i = len - 1; i>=0;i--){
            char c = expression.charAt(i);
            if(!ss.isEmpty() && ss.peek() == '?'){
                ss.pop();
                char first = ss.pop();
                ss.pop();
                char sec = ss.pop();
                ss.push(c == 'T' ? first : sec);
            }else{
                ss.push(c);
            }
        }
        char cc = ss.pop();
        return cc + "";
    }

    public static void main(String[] args) {
        Solution439 solution439 = new Solution439();
        System.out.println(solution439.parseTernary("F?1:T?4:5"));
    }

}
