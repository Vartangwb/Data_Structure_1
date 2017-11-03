
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution361 {

    int maxKilledEnemies(int[][] grid){
        int len = grid.length;
        int len1 = grid[0].length;
        int rowVal = 0;
        int[] colVal = new int[len1];
        int res = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len1; j++){
                if(j == 0 || grid[i][j - 1] == 'W'){
                    rowVal = 0;
                    for(int k = j;k<len1 && grid[i][k]!='W';k++){
                        rowVal += grid[i][k] == 'E'?1:0;
                    }
                }
                if(i == 0 || grid[i-1][j] == 'W'){
                    colVal[j] = 0;
                    for(int k = i; k < len && grid[k][j]!='W'; k++){
                        colVal[j] += grid[k][j] == 'E'?1:0;
                    }
                }
                if(grid[i][j] == '0'){
                    res = Math.max(res, rowVal + colVal[j]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution361 solution216 = new Solution361();
        System.out.println(solution216.maxKilledEnemies(new int[][]{{'0','E','0','0'}, {'E','0','W','E'}, {'0','E','0','0'}}));
    }


}
