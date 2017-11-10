package Algors;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-06 10:46
 **/
public class MergeSort {

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
    }
}
