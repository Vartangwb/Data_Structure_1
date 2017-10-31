package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution646 {

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Collections.sort(Arrays.asList(pairs), new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        System.out.println(pairs[0][0]);
        List<int[]> ll = new ArrayList<>();
        ll.add(pairs[0]);
        for(int i = 1;i<pairs.length;i++){
            int top = ll.get(ll.size() - 1)[0];
            int last = ll.get(ll.size() - 1)[1];
            if(pairs[i][0]>last){
                ll.add(pairs[i]);
            }else if(pairs[i][0]<last){
                if(pairs[i][1]<last){
                    ll.remove(ll.size() - 1);
                    ll.add(pairs[i]);
                }
            }
        }
        System.out.println(ll.size());
        return ll.size();
    }
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            System.out.println(mask);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            System.out.println(set);
            int tmp = max | (1 << i);
            System.out.println(tmp);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution646 solution646 = new Solution646();
        solution646.findLongestChain(new int[][]{{2,3},{1,2},{3,4}});
        solution646.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
    }
}
