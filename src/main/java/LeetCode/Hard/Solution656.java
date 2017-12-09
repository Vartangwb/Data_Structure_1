

package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution656 {

    public List<Integer> cheapestJump(int[] A, int B){
        List<Integer> ans = new ArrayList<>();
        boolean[] canJump = new boolean[A.length];
        canJump[0] = true;
        int res[] = new int[A.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = A[0];
        int tmp[] = new int[A.length];
        tmp[0] = -1;

        for(int i = 1;i<A.length;i++){
            for(int b = 1;b<=B;b++){
                if(b<=i) {
                    if (A[i - b] != -1 && canJump[i - b]) {
                        canJump[i] = true;
                        if(A[i]+res[i-b]<res[i]){
                            tmp[i] = i-b;
                        }
                        res[i] = Math.min(res[i], res[i-b]+A[i]);
                    }
                }
            }
        }
        for(boolean can : canJump){
            System.out.println(can);

        }
        System.out.println(res[A.length-1]);
        System.out.println(canJump[A.length-1]);
        if(canJump[A.length-1]){
            int index = A.length-1;
            while(tmp[index]!=-1){
                System.out.println(A[index]);
                index = tmp[index];
            }
            System.out.println(1);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution656 solution044 = new Solution656();
        solution044.cheapestJump(new int[]{1,2,4,-1,2}, 2);
    }

}
