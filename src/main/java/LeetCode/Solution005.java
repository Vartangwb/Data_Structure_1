
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution005 {

    public String longestPalindrome(String s){
        int length = s.length();
        if(length <= 1){
            return s;
        }
        int maxLen = 1;
        int start = 0;
        boolean P[][] = new boolean[1001][1001];
        for(int i = 0;i<length;i++){
            P[i][i] = true;
            if(i<length - 1 && s.charAt(i)==s.charAt(i+1)){
                P[i][i+1]=true;
                start = i;
                maxLen = 2;
            }
        }
        for(int len = 3;len<=length;len++){
            for(int index = 0;index<=length-len;index++){
                int j = index+len-1;
                if(P[index+1][j-1]){
                    if(s.charAt(index)==s.charAt(j)){
                        P[index][j] = true;
                        maxLen = len;
                        start = index;
                    }
                }
            }
        }
        if(maxLen == 1){
            return s.substring(0,1);
        }
        if(maxLen>=2){
            return s.substring(start, start+maxLen);
        }
        return null;
    }




    public static void main(String[] args) {
        Solution005 solution005 = new Solution005();
        System.out.println(solution005.longestPalindrome("abcdefef"));

    }


}
