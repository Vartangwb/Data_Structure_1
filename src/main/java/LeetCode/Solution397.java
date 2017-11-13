package LeetCode;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-10 14:46
 **/
public class Solution397 {

    public int integerRelacement(int n){
        int res = 0;
        while(n>1){
            res++;
            if(n%2 == 1){
                if((n&2)==0 && n!=3){
                    n++;
                }else{
                    n--;
                }
            }else{
                n>>=2;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution397 solution228 = new Solution397();
        }

}
