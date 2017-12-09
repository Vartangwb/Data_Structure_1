package Algors;

/**
 * Ïß¶ÎÊ÷
 *
 * @author tangwenbo
 * @create 2017-12-04 10:25
 **/
//http://blog.csdn.net/qq508618087/article/details/51303552
public class SegmentTree {

    int tem[];
    int bit[];
    SegmentTree(int size){
        tem = new int[size];
        bit = new int[size+1];
        for(int i = 0;i<tem.length;i++){
            add(i+1, tem[i]);
        }
    }
    public void add(int index, int d){
        while(index<=tem.length){
            bit[index]+=d;
            index+=(index&-index);
        }
    }
    int sum(int index){
        int ans = 0;
        while(index>0){
            ans+=bit[index];
            index-=(index&-index);
        }
        return ans;
    }
    void update(int i, int val){
        add(i+1, val-tem[i]);
        tem[i] = val;
    }
    int sumRange(int i, int j){
        return sum(j+1)-sum(i);
    }

    public static void main(String[] args) {

    }
}
