package Algors;

import java.util.Stack;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-07 10:40
 **/
//http://blog.csdn.net/linhuanmars/article/details/24444491
public class Solution084_stack {

    public int maxRec(int[] heights){

        int max = heights[0];
        Stack<pair> stc = new Stack<>();
        stc.push(new pair(heights[0], 0));
        for(int i = 1;i<heights.length;i++){
            while(!stc.isEmpty() && heights[i]<=stc.peek().val){
                 pair pair = stc.pop();
                System.out.println("index:"+pair.index);
                System.out.println("i:"+i);

                 max = Math.max(max, stc.isEmpty()?pair.index*pair.val:(i - stc.peek().index-1)*pair.val);
                System.out.println("max:"+max);
            }
            stc.push(new pair(heights[i], i));
        }
        while(!stc.isEmpty()){
            pair pair = stc.pop();
            max = Math.max(max, stc.isEmpty()?pair.index*pair.val:(heights.length - stc.peek().index-1)*pair.val);
        }
        return max;

    }
    class pair{
        int val;
        int index;
        pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution084_stack solution084_stack = new Solution084_stack();
        System.out.println(solution084_stack.maxRec(new int[]{2,1,5,6,2,3}));
    }

}
