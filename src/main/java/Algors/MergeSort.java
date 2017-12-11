package Algors;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-06 10:46
 **/
public class MergeSort {
//https://discuss.leetcode.com/topic/33738/share-my-solution/43?page=3
    //http://blog.csdn.net/liuchenjane/article/details/56046889
    public static void mergeSort(int[] arr){

    }

    static int ans = 0;//求逆序对的个数
    public static void sort(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right){
        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int index = left;
        int cindex = left;
        while(left <= mid && r1<=right){
            if(a[left]<=a[r1]){
                tmp[index++] = a[left++];
            }else{
                tmp[index++]=a[r1++];
                ans += mid -left+1;
            }
        }
        while(left<=mid){
            tmp[index++]=a[left++];
        }
        while(r1<=right){
            tmp[index++]=a[r1++];
        }
        while(cindex<=right){
            a[cindex] = tmp[cindex];
            cindex++;
        }
    }

    int count = 0;
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        long[] temp = new long[nums.length + 1];
        sum[0] = 0;
        this.lower = lower;
        this.upper = upper;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (long) nums[i - 1];
        }

        mergesort(sum, 0, sum.length - 1, temp);
        return count;
    }

    private void mergesort(long[] sum, int start, int end, long[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(sum, start, mid, temp);
        mergesort(sum, mid + 1, end, temp);
        merge(sum, start, mid, end, temp);
    }

    private void merge(long[] sum, int start, int mid, int end, long[] temp) {
        int right = mid + 1;
        int index = start;
        int low = mid + 1, high = mid + 1;
        for (int left = start; left <= mid; left++) {
            while (low <= end && sum[low] - sum[left] < lower) {
                low++;
            }
            while (high <= end && sum[high] - sum[left] <= upper) {
                high++;
            }
            while (right <= end && sum[right] < sum[left]) {
                temp[index++] = sum[right++];
            }
            temp[index++] = sum[left];
            count += high - low;
        }
        while (right <= end) {
            temp[index++] = sum[right++];
        }

        for (int i = start; i <= end; i++) {
            sum[i] = temp[i];
        }
    }


    public int partition(int arr[], int low, int high){
        int povit = arr[low];
        while(low < high){
            while(low<high && arr[high]>povit)high--;
            arr[low] = arr[high];
            while(low<high && arr[low]<=povit)low++;
            arr[high] = arr[low];
        }
        arr[low] = povit;
        return low;
    }
    public void quick_sort(int[] arr, int low, int high){
        int loc = 0;
        if(low<high){
            loc = partition(arr, low, high);
            quick_sort(arr, low, loc-1);
            quick_sort(arr, loc+1, high);
        }
    }

    public static void main(String[] args) {
        sort(new int[]{3,2,1}, 0, 2);
        System.out.println(ans);
        //sort2(new int[]{0,-2, 3, 2}, 0, 3);

        int nums[] = new int[]{0, 2147483647,-2147483648,-1,0};
        int sums[] = new int[nums.length+1];
        for (int i = 0; i < nums.length; ++i) {
            sums[i + 1] = sums[i] + nums[i];
            System.out.println(sums[i+1]);;
        }
    }
}
