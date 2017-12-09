package Algors;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * BFS×î¶ÌÂ·¾¶
 *
 * @author tangwenbo
 * @create 2017-12-04 10:25
 **/
public class BFS {

    int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(int[][] forest){


        if(forest == null || forest.length <= 0)
            return 0;
        int steps = 0;
        int len = forest.length;
        TreeMap<Integer, int[]> treeMap = new TreeMap<>();
        for(int i = 0;i<forest.length;i++){
            for(int j = 0;j<forest.length;j++){
                if(forest[i][j] > 1)
                    treeMap.put(forest[i][j], new int[]{i,j});
            }
        }
        System.out.println(treeMap);
        int startx = 0;
        int starty = 0;
        for(int[] t : treeMap.values()){
            int step = bfs(forest, startx, starty, t[0], t[1]);
            if(step == -1)
                return -1;
            steps += step;
            startx = t[0];
            starty = t[1];
        }
        return steps;
    }
    public int bfs(int[][] forest, int startx, int starty, int tx, int ty){
        if(startx == tx && starty == ty){
            return 0;
        }
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startx, starty});
        boolean[][] flag = new boolean[forest.length][forest[0].length];
        flag[startx][starty] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            while(size > 0){
                int cx = queue.peek()[0];
                int cy = queue.peek()[1];
                queue.poll();
                for(int i = 0;i<4;i++){
                    int txx = cx+dir[i][0];
                    int tyy = cy+dir[i][1];
                    if(txx>=0 && txx<forest.length && tyy>=0 && tyy<forest[0].length && flag[txx][tyy]==false && forest[txx][tyy]>=1){
                        if(txx == tx && tyy == ty){
                            return step;
                        }
                        flag[txx][tyy] = true;
                        queue.add(new int[]{txx, tyy});
                    }
                }
                size--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        System.out.println(bfs.cutOffTree(new int[][]{{1,2,3}, {0,0,4}, {7,6,5}}));
    }
}
