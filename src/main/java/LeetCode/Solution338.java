package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution338 {

    public int[] countBits(int num) {
        int res[] = new int[num+1];
        res[0] = 0;
        for(int i = 1;i<=num;i++){
            res[i] = res[i>>1] + i&1;
        }
        return res;
    }
}
