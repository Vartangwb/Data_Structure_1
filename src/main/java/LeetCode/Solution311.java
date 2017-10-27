package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution311 {

    public void solve(int[][] A, int[][] B){
        int lena = A.length;
        int lenb = B.length;
        int lenb1 = B[0].length;
        int lena1 = A[0].length;
        int res[][] = new int[lena][lenb1];
        for(int i = 0;i<lena;i++){
            for(int k = 0;k<A[0].length;k++){
                if(A[i][k] != 0){
                    for(int j = 0;j<B[0].length;j++){
                        res[j][k] += A[i][k]*B[k][j];
                    }
                }
            }
        }
    }

}
