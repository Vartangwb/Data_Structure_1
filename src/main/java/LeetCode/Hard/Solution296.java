package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-25 21:40
 **/
public class Solution296 {

    public int solve(int[][] points){
        List<Integer> ls_x = new ArrayList<>();
        List<Integer> ls_y = new ArrayList<>();
        for(int i = 0;i<points.length;i++){
            for(int j = 0;j<points[0].length;j++){
                if(points[i][j]==1){
                    ls_x.add(i);
                    ls_y.add(j);
                }
            }
        }
        Collections.sort(ls_x);
        Collections.sort(ls_y);
        int left = 0;
        int right = ls_x.size() - 1;
        int res = 0;
        while(left<right){
            res+=(ls_x.get(right) - ls_x.get(left));
            left++;
            right--;
        }
        left = 0;
        right = ls_y.size() - 1;
        while(left<right){
            res+=(ls_y.get(right) - ls_y.get(left));
            left++;
            right--;
        }
        System.out.println(res);
        return res;
    }

    public int solve(int n){
        return Integer.parseInt(Integer.toString(n,9));
    }
    public static void main(String[] args) {
        Solution296 solution296 = new Solution296();
        solution296.solve(new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}});
        System.out.println(solution296.solve(9));
    }

}
