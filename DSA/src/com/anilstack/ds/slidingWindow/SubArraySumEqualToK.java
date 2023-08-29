package com.anilstack.ds.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {
//identify continuous subarrays whose sum is equal to K.
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int[] nums1 = {4,1,6,2,1,1,1,9,5};
        int k1 = 5;

        System.out.println(SubArraySumEqualToK.findContinuousSubArraysSumEqualToK(nums1,k1));


    }

    public static int findContinuousSubArraysSumEqualToK(int[] nums, int k) {

        //key is running sum.
        //value is frequency of running sum.
        Map<Integer,Integer> runningSumAndFrequency = new HashMap<>();
        runningSumAndFrequency.put(0,1);
        int ans = 0;
        int runningSum = 0;

        for (int num : nums) {

            runningSum += num;
            if (runningSumAndFrequency.containsKey(runningSum - k)) {
                ans += runningSumAndFrequency.get(runningSum-k);
            }

            runningSumAndFrequency.put(runningSum, runningSumAndFrequency.getOrDefault(runningSum,0)+1);

        }

        return ans;
    }
}
