package Algors;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-08 14:27
 **/
public class UnionFind {

    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[2000];
        for(int i = 0;i<2000;i++){
            parent[i] = i;
        }
        for(int i = 0;i<edges.length;i++){
            int[] tmp = edges[i];
            int node1 = tmp[0];
            int node2 = tmp[1];
            int p1 = getParent(node1, parent);
            int p2 = getParent(node2, parent);
            if(p1 == p2)
                return tmp;
            parent[p1] = p2;
        }
        return new int[]{0,0};
    }

    public int getParent(int i, int[] parent){
        while(i!=parent[i]){
            i = parent[i];
        }
        return i;
    }

}
