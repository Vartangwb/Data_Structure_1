package Algors;

/**
 * Ïß¶ÎÊ÷
 *
 * @author tangwenbo
 * @create 2017-12-04 10:25
 **/
//http://blog.csdn.net/qq508618087/article/details/51303552
//http://blog.csdn.net/qq508618087/article/details/50952147
public class NumMatrix {

    int[][] tem;
    int[][] bit;
    NumMatrix(int msize, int nsize){
        bit = new int[msize][nsize+1];
        tem = new int[msize][nsize];
        for(int i = 0; i<msize;i++){
            for(int j = 1;j<=nsize;j++){
                add(tem[i][j-1], i, j);
            }
        }
    }
    public void add(int val, int x, int y){
        while(y<tem[x].length){
            bit[x][y]+=val;
            y+=(y&-y);
        }
    }
    int sum(int x, int y){
        int ans = 0;
        while(y>0){
            ans+=bit[x][y];
            y-=(y&-y);
        }
        return ans;
    }
    void update(int row, int col, int val){
        int d = val - tem[row][col];
        add(d, row, col+1);
        tem[row][col] = val;
    }
    int sumRange(int row1, int row2, int col1, int col2){
        int ans = 0;
        for(int i = row1; i<=row2;i++){
            ans+=(sum(i, col2+1)-sum(i, col1+1));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
