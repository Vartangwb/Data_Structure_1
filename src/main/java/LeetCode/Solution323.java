package LeetCode;

/**
 * tree ตÝน้
 *
 * @author tangwenbo
 * @create 2017-10-16 20:59
 **/
public class Solution323 {

    int countComponents(int n, int[][] edges) {

        int len = n;
        int root[] = new int[len];
        for(int i = 0;i<len;i++){
            root[i] = i;
        }
        for(int[] rr : edges){
            int xx = rr[0];
            int yy = rr[1];
            int rootx = getRoot(root, xx);
            int rooty = getRoot(root, yy);
            root[rootx] = rooty;
        }
        int count = 0;
        for(int i = 0;i<len;i++){
            if(root[i] == i){
                count++;
            }
        }
        return count;


    }
    public int getRoot(int[] root, int xx){
        while(root[xx] != xx){
            xx = root[root[xx]];
        }
        return xx;
    }

    public static void main(String[] args) {
        Solution323 solution323 = new Solution323();
        System.out.println(solution323.countComponents(3, new int[][]{{1,2},{2,0}}));
    }
}