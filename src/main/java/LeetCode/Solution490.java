
package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution490 {

    public boolean hasPath(int[][] maze, int[] start, int[] des){
        if(maze.length == 0 || maze[0].length == 0)
            return false;
        if(start[0] == des[0] && start[1] == des[1]){
            return true;
        }
        boolean visited[][] = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, des, visited);
    }

    int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0, -1}};
    public boolean dfs(int[][] maze, int[] start, int[] des, boolean[][] visited){
        if(visited[start[0]][start[1]]){
            return false;
        }
        if(Arrays.equals(start, des))
            return true;
        visited[start[0]][start[1]] = true;
        for(int i = 0;i<4;i++){
            int nx = start[0];
            int ny = start[1];
            while(notWall(nx + dir[i][0], ny + dir[i][1], maze.length, maze[0].length) && maze[nx+dir[i][0]][ny+dir[i][1]]!=1){
                nx+=dir[i][0];
                ny+=dir[i][1];
            }
            if(dfs(maze, new int[]{nx, ny}, des, visited))
                return true;
        }
        return false;
    }
    private boolean notWall(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    int m;
    int n;
    public int shortestDistance(int[][] maze, int[] start, int[] des){
        if(Arrays.equals(start, des)){
            return 0;
        }
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, des);
    }
    int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    private int dfs(int[][] maze, int[] start, int des[]) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis - o2.dis;
            }
        });
        minHeap.offer(new Node(start[0], start[1], 0));
        int[][] visited = new int[m][n];
        for(int[] arr:visited){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        while(!minHeap.isEmpty()){
            Node curr = minHeap.poll();
            if(curr.x == des[0] && curr.y == des[1])
                return curr.dis;
            for(int[] dir: dirs){
                int nx = curr.x;
                int ny = curr.y;
                while(isInMaze(nx + dir[0], ny + dir[1]) && maze[nx + dir[0]][ny + dir[1]] != 1) {
                    nx += dir[0];  ny += dir[1];
                }
                int distance = curr.dis + Math.abs(nx - curr.x) + Math.abs(ny - curr.y);
                if(visited[nx][ny] > distance){
                    minHeap.offer(new Node(nx, ny, distance));
                    visited[nx][ny] = distance;
                }
            }
        }


        return -1;
    }



    private boolean isInMaze(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    class Node{
        int x;
        int y;
        int dis;
        Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
//http://www.cnblogs.com/skywang12345/p/3711516.html
    public int mEdgNum; //边的数量
    public char[] mVexs; //顶点集合
    public int[][] mMatrix; //邻接矩阵
    public static final int INF = Integer.MAX_VALUE;
    public void dijkstra(int vs, int[] prev, int[] dist){
        boolean[] flag = new boolean[mVexs.length];
        for(int i = 0;i<mVexs.length;i++){
            flag[i] = false;
            prev[i] = 0;
            dist[i] = mMatrix[vs][i];
        }
        flag[vs] = true;
        dist[vs] = 0;
        int k = 0;
        for(int i = 1;i<mVexs.length; i++){
            int min = INF;
            for(int j =0;j<mVexs.length;i++){
                if(flag[j] == false && dist[j]<min){
                    min = dist[j];
                    k = j;
                }
            }
            flag[k] = true;

            for(int j = 0;j<mVexs.length;j++){
                int tmp = (mMatrix[k][j] == INF?INF:(min + mMatrix[k][j]));
                if(flag[j] == false && (tmp<dist[j])){
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
    }




    public static void main(String[] args) {
        Solution490 solution216 = new Solution490();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);


    }


}
