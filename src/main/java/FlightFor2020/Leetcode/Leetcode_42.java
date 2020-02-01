package FlightFor2020.Leetcode;

import javax.management.InstanceAlreadyExistsException;
import java.util.Stack;

public class Leetcode_42 {

    public int trap2(int[] height)
    {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int currIndex = 0;
        while(currIndex < height.length)
        {
            while(!stack.isEmpty() && height[stack.peek()] < height[currIndex])
            {
                int h = height[stack.pop()];
                if(stack.isEmpty())
                    break;
                int dis = currIndex - stack.peek() - 1;
                int hi = Math.min(height[currIndex], height[stack.peek()]);
                res += (hi - h) * dis;
            }
            stack.push(currIndex);
            currIndex++;
        }

        return res;
    }
    public int trap(int[] height)
    {
        int res = 0;
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++)
        {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for(int i = 0; i < height.length; i++)
        {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

}
