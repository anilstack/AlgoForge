package com.anilstack.ds.binarysearch;

public class MaximumRunningTimeOfNComputers {

    public static void main(String[] args) {

        int computers = 3;
        int[] batteries = {10,10,3,5};
        System.out.println(MaximumRunningTimeOfNComputers.maxRunTime(computers,batteries));

    }

    private static boolean canFit(int computers, long timeSpam, int[] batteris) {

        long currBatterySum = 0;
        long targetBatterySum = computers * timeSpam;

        for (int battery:batteris) {
            if (battery < timeSpam) {
                currBatterySum += battery;
            } else {
                currBatterySum += timeSpam;
            }

            if (currBatterySum == targetBatterySum) { return true; }
        }

        return currBatterySum >= targetBatterySum;
    }


    private static long maxRunTime(int computers, int[] batteries) {

        long totalSum = 0;
        long ans = -1;

        long low = 0;
        for (int battery:batteries) {
            totalSum += battery;
            low = Math.min(battery,low);
        }

        long high = (totalSum/computers)+1;

        while (low < high) {

            long mid = low + (high - low)/2;

            if (canFit(computers,mid,batteries)) {

                ans = mid;
                low = mid + 1;

            } else {

                high = mid;
            }

        }










        return ans;
    }

}
