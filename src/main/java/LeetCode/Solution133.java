
package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution133 {

    class UndirectedGraphNode{
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x){
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        UndirectedGraphNode newNode = map.get(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode tmp = queue.poll();
            for(UndirectedGraphNode node1 : tmp.neighbors){
                if(map.containsKey(node1)){
                    map.get(tmp).neighbors.add(map.get(node1));
                }else{
                    map.put(node1, new UndirectedGraphNode(node1.label));
                    map.get(tmp).neighbors.add(map.get(node1));
                    queue.add(node1);
                }
            }
        }
        return newNode;
    }



    public static void main(String[] args) {
        Solution133 solution005 = new Solution133();
        solution005.cloneGraph(null);
    }


}
