package Algors;

import java.util.Arrays;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-09 20:02
 **/
public class BucketSort {

    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<num.length;i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        int gap = (int)Math.ceil((double)(max-min)/(num.length-1));
        int maxGap[] = new int[num.length-1];
        int minGap[] = new int[num.length-1];
        Arrays.fill(maxGap, Integer.MIN_VALUE);
        Arrays.fill(minGap, Integer.MAX_VALUE);

        for(int i = 0;i<num.length;i++){
            if(num[i] == min || num[i]==max){
                continue;
            }
            int index = (num[i]-min)/gap;
            maxGap[index] = Math.min(num[i], maxGap[index]);
            minGap[index] = Math.max(num[i], minGap[index]);
        }

        int maxGapp = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0;i<num.length-1;i++){
            if(maxGap[i]==Integer.MAX_VALUE && minGap[i] == Integer.MIN_VALUE)
                continue;
            maxGapp = Math.max(maxGapp, minGap[i] - previous);
            previous = maxGap[i];
        }
        maxGapp = Math.max(maxGapp, max - previous);
        return maxGapp;
    }

}
