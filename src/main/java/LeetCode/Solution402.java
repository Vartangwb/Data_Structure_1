

package LeetCode;

import java.util.Stack;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution402 {

    public String removeKdigits(String num, int k){
        int len = num.length();
        if(k == num.length()){
            return "0";
        }
        Stack<Character> stc = new Stack<>();
        int i = 0;
        while(i < num.length()){
            while(k>0 && !stc.isEmpty() && num.charAt(i) < stc.peek()){
                stc.pop();
                k--;
            }
            stc.add(num.charAt(i));
            i++;
        }
        if(k>0){
            stc.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stc.isEmpty()){
            sb.append(stc.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution402 solution402 = new Solution402();
        solution402.removeKdigits("1432219", 2);
    }


}
