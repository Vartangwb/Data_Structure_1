

package LeetCode.Hard;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class Solution004 {

    //https://segmentfault.com/a/1190000002988010
    public int solve(int[] nums1, int[] nums2, int k){

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1+len2;
        if(total%2==0){
            return findKNum(nums1, nums2, total/2)+findKNum(nums1, nums2, total/2+1);
        }else{
            return findKNum(nums1, nums2, total/2+1);
        }

    }
    public int findKNum(int[] nums1, int[] nums2, int k){
        int p = 0;
        int q = 0;
        for(int i = 0;i<k-1;i++){
            if(p>=nums1.length && q<nums2.length){
                q++;
            }else if(q>=nums2.length && p<nums1.length){
                p++;
            }else if(nums1[p]<nums2[q]){
                p++;
            }else{q++;}
        }
        if(p>=nums1.length){
            return nums2[q];
        }else if(q>=nums2.length){
            return nums1[p];
        }else{
            return Math.min(nums1[p], nums2[q]);
        }
    }

    public int solve2(int[] nums1, int[] nums2, int k){

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1+len2;
        if(total%2==0){
            return findKNum(nums1, nums2, 0,0,len1,len2,total/2)+findKNum(nums1, nums2,0,0,len1,len2, total/2+1);
        }else{
            return findKNum(nums1, nums2, 0,0,len1,len2,total/2+1);
        }

    }
    public int findKNum(int[] nums1, int[] nums2, int start1, int start2, int len1, int len2, int k){
        if(len1>len2){
            return findKNum(nums2, nums1, start2, start1, len2, len1, k);
        }
        if(len1==0)
            return nums2[start2+k-1];
        if(k==1)
            return Math.min(nums1[start1], nums2[start2]);
        int p1 = Math.min(k/2, len1);
        int p2 = k-p1;
        if(nums1[start1+p1-1]<nums2[start2+p2-1]){
            return findKNum(nums1, nums2, start1+p1, start2, len1-p1, len2, k-p1);
        }else if(nums1[start1+p1-1]>nums2[start2+p2-1]){
            return findKNum(nums1, nums2, start1, start2+p2, len1, len2-p2, k-p2);
        }else{
        return nums1[start1+p1-1];
        }
    }




    public static void main(String[] args) {
        Solution004 solution044 = new Solution004();
        System.out.println(solution044.solve(new int[]{0,1,2,3},new int[]{4,5,6,7}, 4));
        System.out.println(solution044.solve2(new int[]{0,1,2,3},new int[]{4,5,6,7}, 4));

    }



}
