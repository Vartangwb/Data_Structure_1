package Tree;

/**
 * Ïß¶ÎÊ÷
 *
 * @author tangwenbo
 * @create 2017-10-09 17:04
 **/
public class BinTree {
    public static final int N = 100;
    int tre[] = new int[N * 4];


    public void build(int arr[], int index, int left, int right){
        if(left == right){
            tre[index] = arr[left];
        }else{
            int mid = (left + right) / 2;
            build(arr, index * 2 + 1, left, mid);
            build(arr, index * 2 + 2, mid + 1, right);
            tre[index] = Math.min(tre[index * 2 + 1] , tre[index * 2 + 2]);
        }
    }

    //public int query(int index, int left, int right, int )
}
