package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution476 {

    public int findComplement(int num) {
        int tmp = 1;
        int tmp2 = num;
        while(tmp2!=0){
            tmp<<=1;
            tmp2>>=1;

        }
        tmp-=1;
        return tmp^num;
    }

    }
