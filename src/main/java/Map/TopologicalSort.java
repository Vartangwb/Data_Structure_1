package Map;

import java.util.*;

/**
 * 拓扑排序
 *
 * @author tangwenbo
 * @create 2017-10-09 14:09
 **/
public class TopologicalSort {

    //安排课程
    public boolean canFinish(int numCourses, int[][] preCores){
        List<Set<Integer>> posts = new ArrayList<Set<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            posts.add(new HashSet<Integer>());
        }

        for(int i = 0; i < preCores.length; i++){
            posts.get(preCores[i][1]).add(preCores[i][0]);
        }

        int[] preNums = new int[numCourses];
        for(int i = 0;i < numCourses; i++){
            Set set = posts.get(i);
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                preNums[it.next()]++;
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(preNums[i] == 0){
                queue.add(i);
            }
        }
        while(queue.isEmpty() == false){
            int cur = queue.poll();
            for(int ii: posts.get(cur)){
                preNums[ii]--;
                if(preNums[ii] == 0){
                    queue.offer(ii);
                }
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(preNums[i] != 0)
                return false;
        }
        return true;
    }
    //http://www.cnblogs.com/kisty/p/6687622.html
    private int mEdgNum;//边的数量
    private char[] mVexs;//顶点集合
    private int[][] mMatrix;
    private static final int INF = Integer.MAX_VALUE;

    void Dijkstra(int src, int prev[], int[] dist){

        boolean[] flag = new boolean[mVexs.length];
        for(int i = 0;i<mVexs.length;i++){
            flag[i] = false;
            prev[i] = 0;
            dist[i] = mMatrix[src][i];
        }
        //从源点到顶点的距离
        flag[src] = true;
        dist[src] = 0;
        int k = 0;
        for(int i = 1;i<mVexs.length;i++){
            int min = INF;
            for(int j = 0;j<mVexs.length;j++){
                if(flag[j] == false && dist[j]<min){
                    min = dist[j];
                    k = j;
                }
            }

            flag[k] = true;
            for(int j = 0;j<mVexs.length;j++){
                int tmp = (mMatrix[k][j] == INF ? INF : (min + mMatrix[k][j]));
                if(flag[j] == false && tmp < dist[j]){
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        System.out.printf("dijkstra(%c): \n", mVexs[src]);
        for (int i=0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[src], mVexs[i], dist[i]);


    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        System.out.println(topologicalSort.canFinish(4, new int[][]{{0,1},{1,2}}));
    }

}
