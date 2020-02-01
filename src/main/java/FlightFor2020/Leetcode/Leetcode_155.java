package FlightFor2020.Leetcode;

import java.util.Stack;

public class Leetcode_155 {
    /** initialize your d
     * ata structure here. */
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public Leetcode_155() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty())
            stack2.push(x);
        else
        {
            int val = stack2.peek();
            if(val > x)
                stack2.push(x);
            else
                stack2.push(val);
        }
    }

    public void pop() {
        stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {

    }
}
