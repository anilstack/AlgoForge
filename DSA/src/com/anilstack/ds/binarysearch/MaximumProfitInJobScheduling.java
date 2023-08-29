package com.anilstack.ds.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {

    private class Job {

        private int startTime;
        private int endTime;
        private int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }


    public static void main(String[] args) {

        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        MaximumProfitInJobScheduling maximumProfitInJobScheduling = new MaximumProfitInJobScheduling();
        System.out.println(maximumProfitInJobScheduling.findMaximumProfit(startTime,endTime,profit));

    }

    private int findMaximumProfit(int[] startTime, int[] endTime, int[] profit) {

        List<Job> jobsList = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobsList.add(new Job(startTime[i],endTime[i],profit[i]));
        }

        Collections.sort(jobsList, (a,b) -> (a.endTime - b.endTime));

        //key is endTime
        //value is maxProfit
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int ans = 0;

        for (Job currentJob : jobsList) {

             Integer entryTillStartTime = map.floorKey(currentJob.startTime);
             Integer maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
             ans = Math.max(ans,maxProfitTillStartTime+currentJob.profit);
             map.put(currentJob.endTime,ans);

        }
        return ans;
    }
}
