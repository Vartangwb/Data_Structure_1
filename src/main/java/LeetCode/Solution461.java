package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution461 {

    public int hammingDistance(int x, int y) {
        int count = 0;
        for(int i = 0;i<32;i++){
            int xx = x & 1;
            int yy = y & 1;
            x>>=1;
            y>>=1;
            if((xx ^ yy) == 1)
                count++;
        }
        return count;
    }

}
