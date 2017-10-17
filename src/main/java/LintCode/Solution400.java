package LintCode;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-13 11:55
 **/
public class Solution400 {

    public int maximumGap(int[] nums) {
        if(null == nums || nums.length < 2)
        {
            return 0;
        }

        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i < length;i++)
        {
            if(nums[i] < min)
            {
                min = nums[i];
            }

            if(nums[i] > max)
            {
                max = nums[i];
            }
        }
        // 桶的概念
        int bucketCapacity = (max - min) / length + 1;
        System.out.println("bucket" + bucketCapacity);
        int bucketNumber = (max - min) / bucketCapacity + 1;
        System.out.println("bucketNumber" + bucketNumber);
        int[] minBuckets = new int[bucketNumber];
        int[] maxBuckets = new int[bucketNumber];
        int maxDistance = 0;

        for(int i = 0;i < bucketNumber;i++)
        {
            minBuckets[i] = Integer.MAX_VALUE;
            maxBuckets[i] = Integer.MIN_VALUE;
        }

        for(int i = 0;i < length;i++)
        {
            int index = (nums[i] - min) / bucketCapacity;
            if(minBuckets[index] > nums[i])
            {
                minBuckets[index] = nums[i];
            }

            if(maxBuckets[index] < nums[i])
            {
                maxBuckets[index] = nums[i];
            }
        }
        for(int i = 0;i<maxBuckets.length;i++){
            System.out.print(maxBuckets[i] + " ");
        }
        System.out.println(" ");

        for(int i = 0;i<minBuckets.length;i++){
            System.out.print(minBuckets[i] + " ");
        }
        System.out.println(" ");

        int pre = 0;
        for(int i = 1;i < bucketNumber;i++)
        {
            if(minBuckets[i] == Integer.MAX_VALUE && maxBuckets[i]== Integer.MIN_VALUE)
                continue;
            if(minBuckets[i] -  maxBuckets[pre] > maxDistance)
            {
                maxDistance = minBuckets[i] - maxBuckets[pre]; // 因为最大间距不可能在一个桶内，否则bucketNumber ＊ maxDistance > length;
            }
            pre = i;
        }
        return  maxDistance;
    }

    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
        System.out.println(solution400.maximumGap(new int[]{1, 9, 2, 5,2,2,2,2,2}));
    }

}
