package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution541 {

    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] ss = s.toCharArray();
        for(int i = 0;i<ss.length;i++){
            System.out.println(ss[i]);
        }
        boolean flag = true;
        int i = 0;
        while(i<len){
            if(i+k-1>=len)
                break;
            if(flag){

                reverse(ss, i, i+k-1);
                flag = false;
                System.out.println(i);
                i = i+k;

            }else{
                flag = true;
                i = i+k;
            }
        }
        return new String(ss);
    }
    public void reverse(char[] ss, int left, int right){
        while(left<right){
            char tmp = ss[left];
            ss[left] = ss[right];
            ss[right] = tmp;
            left++;
            right--;
        }
    }
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int len = 1;
        if(x==0)
            return true;
        while(true){
            System.out.println(len);
            if((x/len)<10)
                break;
            len*=10;
        }
        while(true){
            if(x == 0)
                break;
            int left = x / len;
            int right = x % 10;
            if(left!=right)
                return false;
            x = x%len/10;
            len=len/100;
        }
        return true;

    }

    public static void main(String[] args) {
        Solution541 solution541 = new Solution541();
        System.out.println(solution541.isPalindrome(1));
    }

}
