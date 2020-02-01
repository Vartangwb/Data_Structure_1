package FlightFor2020.Leetcode;

import java.util.Stack;

public class Leetcode_20 {


    public static boolean isValid(String s) {
        if(s.length() % 2 != 0 )
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(')
            {
                stack.push(s.charAt(i));
            }
            else
            {

                if(stack.isEmpty())
                    return false;
                char curr = stack.pop();

                if(curr == '[' && s.charAt(i) != ']' || curr == '(' && s.charAt(i) != ')' || curr == '{' && s.charAt(i) != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()()"));
    }
}
