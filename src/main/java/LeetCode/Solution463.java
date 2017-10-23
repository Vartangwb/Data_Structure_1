package LeetCode;

/**
 * 计算多边形面积，贪心
 *
 * @author tangwenbo
 * @create 2017-10-16 20:59
 **/
public class Solution463 {

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int lenx = grid.length;
        int leny = grid[0].length;
        for(int i = 0;i<lenx;i++){
            for(int j = 0; j<leny;j++){
                if(grid[i][j] == 1){
                    count+=4;

                    if(i>0 && grid[i-1][j]==1){
                        count-=2;
                    }
                    if(j>0 && grid[i][j-1]==1){
                        count-=2;
                    }
                }
            }
        }
        return count;
    }



}
