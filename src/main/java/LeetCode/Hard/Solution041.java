

package LeetCode.Hard;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution041 {

    int firstMissingPositive(int A[], int n) {
         int i = 0;
         while (i < n)
         {
             if (A[i] != (i+1) && A[i] >= 1 && A[i] <= n && A[A[i]-1] != A[i]) {
                 swap(A, i, A[i] - 1);
             }else
                 i++;
         }
         for (i = 0; i < n; ++i)
             if (A[i] != (i+1))
                 return i+1;
         return n+1;
     }
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        Solution041 solution044 = new Solution041();
        solution044.firstMissingPositive(new int[]{3,2,1,5}, 4);
    }



}
