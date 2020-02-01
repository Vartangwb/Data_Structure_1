package FlightFor2020.Leetcode;

import java.util.Stack;

public class Leetcode_71 {

    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(!stack.isEmpty() && arr[i].equals(".."))
            {
                stack.pop();
            }
            else {
                if (!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals(".."))
                {
                    stack.push(arr[i]);
                }
            }
        }

        String res = "";
        while(!stack.isEmpty())
        {
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
