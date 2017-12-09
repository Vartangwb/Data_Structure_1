
package LeetCode.Hard;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution493 {

    int res = 0;
    public int maxReversePairs(int[] nums){
        int r = nums.length-1;
        sort(nums, 0, r);
        return res;
    }
    public void sort(int[] nums, int l, int r){
        if(l >= r)
            return;
        int mid = (l+r)/2;
        sort(nums, l, mid);
        sort(nums, mid+1, r);
        int j = mid+1;
        int i = l;
        while(j<=r){
            while(i<=mid && nums[i]/2.0<=nums[j]){
                i++;
            }

            res+=mid-i+1;
            System.out.println(res);
            j++;
        }
        merge(nums, l, mid, r);
    }
    //https://segmentfault.com/a/1190000008418738
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


    public static void main(String[] args) {
        Solution493 solution044 = new Solution493();
        System.out.println(solution044.maxReversePairs(new int[]{1,3,2,3,1}));
    }

}
