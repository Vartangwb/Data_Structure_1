package LeetCode;

import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-23 15:41
 **/
public class Solution364 {

    int maxDepth = 0;
    public void dfs(List<NestedList> nestedList, int dep){
        if(dep>maxDepth){
            maxDepth = dep;
        }
        for(NestedList nestedList1 : nestedList){
            if(nestedList1.isInteger())
                continue;
            else{
                dfs(nestedList1.getList(), dep + 1);
            }
        }
    }

    public int helper(List<NestedList> ls, int weight){
        int sum = 0;
        for(NestedList ll : ls){
            if(ll.isInteger()){
                sum+=ll.getInteger();
            }else{
                sum+=helper(ll.getList(), weight - 1);
            }
        }
        return sum;
    }
    public int sum(List<NestedList> ls){
        dfs(ls, 1);
        return helper(ls, maxDepth);
    }

}
