package Algors;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-28 19:01
 **/
public class DijkstraAlg {

    //n 定点个数
    //e 边的个数
    public static final int NUM = 100;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    int dist[] = new int[NUM];
    int path[] = new int[NUM];
    public void solve(int[][] dis, int v0){
        boolean[] visited = new boolean[dis.length];
        for(int i = 0;i<dis.length;i++){
            visited[i] = false;
            if(dis[v0][i]>0 && i!=v0){
                dist[i] = dis[v0][i];//找到所有的v0到i的最短距离
                path[i] = v0;
            }else{
                dist[i] = MAX_VALUE;
                path[i] = -1;
            }
        }
        visited[v0] = true;
        dist[v0] = 0;
        path[v0] = v0;

        for(int i = 1; i<dis.length;i++){
            int mindis = MAX_VALUE;
            int u=0;
            for(int j = 0;j<dis.length;j++){
                if(dist[j]<mindis && visited[j]==false){
                    mindis = dist[j];
                    u =j;
                }
            }
            visited[u] = true;
            for(int k = 0;k<dis.length;k++){
                if(visited[k]==false && dis[u][k]>0 &&
                   dis[u][k]+dist[u]<dist[k]){
                    dist[k] = dis[u][k] + dist[u];
                    path[k] = u;
                }
            }
        }
    }


    int edge[][] = new int[MAX_VALUE][MAX_VALUE];


}
