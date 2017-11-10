package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-08 15:17
 **/
public class Solution542 {

    int dirx[] = new int[]{1,0, -1,0};
    int diry[] = new int[]{0, 1, 0, -1};
    public void solve(int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }else{
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] tt = queue.poll();
            for(int i = 0;i<4;i++){
                int xx = tt[0]+dirx[i];
                int yy = tt[1]+diry[i];
                if(xx>=0 && xx<grid.length && yy>=0 && yy < grid[0].length){
                    if(grid[xx][yy]<=grid[tt[0]][tt[1]]){

                    }else{
                        grid[xx][yy] = grid[tt[0]][tt[1]] + 1;
                    }
                }
                queue.add(new int[]{xx,yy});
            }
        }
    }

}
