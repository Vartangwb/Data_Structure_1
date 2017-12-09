package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-04 15:08
 **/

//http://blog.csdn.net/worldwindjp/article/details/22066307
public class Solution131 {

    void dp(String s, boolean[][] map, int count[]){
        int[] count1 = new int[s.length()];
        Arrays.fill(count1, Integer.MAX_VALUE);
        count1[0] = 1;
        for(int i = s.length()-1;i>=0;i--){
            for(int j = s.length()-1;j>i;j--){
                if(map[i][j] == true){
                    if(j == 0)
                        count1[i] = 1;
                    else
                        count1[i] = Math.min(count1[j]+1, count1[i]);
                }else{
                    count1[i] = count1[j]+1;
                }
            }
        }
        for(int i = 0;i<s.length();i++){
            System.out.print(count1[i]+" ");
        }
    }


    void dp(String s, boolean[][] map){
        for(int i = 0;i<s.length();i++){
            for(int j = i;j>=0;j--){
                if(i == j){
                    map[i][j] = true;
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(j == i-1 || map[j+1][i-1] == true){
                            map[j][i] = true;
                        }
                    }
                }
            }
        }
        for(int i = 0;i<s.length();i++){
            for(int j = 0;j<s.length();j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    public List<ArrayList<String>> partition(String s){
        List<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();
        if(s == null || s.length() == 0) {
            res.add(array);
            return res;
        }
        boolean[][] map = new boolean[s.length()][s.length()];
        dp(s, map);
        dp(s, map, new int[]{1,2});
        dfs(s, 0, map, array, res);
        return res;
    }

    public void dfs(String s, int index, boolean[][] map, List<String> arr, List<ArrayList<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(arr));

        }
        for(int i = index;i<s.length();i++){
            if(map[index][i] == true){
                arr.add(s.substring(index, i+1));
                dfs(s, i+1, map, arr, res);
                arr.remove(arr.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("abaddba"));

    }

}
