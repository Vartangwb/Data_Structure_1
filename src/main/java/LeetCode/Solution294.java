package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution294 {

    public boolean canWin(String s) {
        char[] arr = s.toCharArray();
        for(int i = 1; i < s.length(); i++) {
            if(arr[i] == '+' && arr[i - 1] == '+') {
                arr[i] = '-';
                arr[i - 1] = '-';
                String next = String.valueOf(arr);
                if(!canWin(next)) {
                    return true;
                }
                arr[i] = '+';
                arr[i - 1] = '+';
            }
        }

        return false;
    }
}
