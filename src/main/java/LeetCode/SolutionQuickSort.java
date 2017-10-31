
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class SolutionQuickSort {

    public int findKthNum(int[] num, int len, int k){
        return quickSort(num, 0, len-1,k);
    }

    public int partition(int[] num, int low, int high){
        int tmp = num[low];
        while(low < high){
            while(low<high && tmp>=num[high]){
                high--;
            }
            num[low] = num[high];
            while(low<high && tmp<=num[low]){
                low++;
            }
            num[high] = num[low];
        }
        num[low] = tmp;
        return low;
    }
    public int quickSort(int[] num, int low, int high, int k){
        if(low<=high){
            int pos = partition(num, low, high);
            if(pos == k-1){
                return num[k-1];
            }else if(pos>k-1){
                return quickSort(num, low, pos-1, k);
            }else{
                return quickSort(num, pos+1, high, k);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        SolutionQuickSort solution216 = new SolutionQuickSort();

    }


}
