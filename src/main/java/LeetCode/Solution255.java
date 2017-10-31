
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution255 {

    boolean verifyPreorder(int[] preorder){
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(int[] preorder, int start, int end, int lower, int upper){
        if(start > end){
            return true;
        }
        int val = preorder[start];
        int i = 0;
        for(i = start+1;i<=end;i++){
            if(preorder[i]>=val)
                break;
        }
        return helper(preorder, start+1, i-1, lower, val) &&
                helper(preorder, i, end, val, upper);
    }

    public static void main(String[] args) {
        Solution255 solution216 = new Solution255();

    }


}
