package Algors;

import java.util.*;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-08 13:53
 **/
public class Graph {

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            for(int j =0;j<2;j++){
                if(graph.containsKey(edges[i][j])){
                    graph.get(edges[i][j]).add(edges[i][1-j]);
                }else{
                    Set<Integer> set = new HashSet<>();
                    set.add(edges[i][1-j]);
                    graph.put(edges[i][j], set);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int tmp = queue.poll();
                if(!graph.containsKey(tmp)){
                    continue;
                }else{
                    Set<Integer> set = graph.get(tmp);
                    for(Integer integer : set){
                        if(visited.contains(integer))
                            return false;
                        else{
                            visited.add(integer);
                            queue.add(integer);
                        }
                        graph.get(integer).remove(tmp);
                    }
                }
            }
        }
        return visited.size() == n;

    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println(graph.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    }
}
