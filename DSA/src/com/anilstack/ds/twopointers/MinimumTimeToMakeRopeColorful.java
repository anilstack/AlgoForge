package com.anilstack.ds.twopointers;

public class MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        String colors = "abacc";
        int[] neededTime = {1,2,3,4,5};
        int timeRequired = MinimumTimeToMakeRopeColorful.minCost(colors,neededTime);
        System.out.println(timeRequired);
    }
//we dont want two consecutive balloons with same color.
//we need to identfiy minimum time needed to make rope colorful.
//TC: O(n)
//SC: O(1)
    private static int minCost(String colors, int[] neededTime){

        int start = 0;
        int end = 0;
        int totalTime = 0;
        int n = colors.length();

        while (start < n && end < n) {
            int maxTime = 0;
            int groupTotal = 0;
            while (end < n && colors.charAt(start) == colors.charAt(end)) {
                maxTime = Math.max(maxTime,neededTime[end]);
                groupTotal += neededTime[end];
                end++;
            }
            totalTime += (groupTotal - maxTime);
            start = end;
        }
        return totalTime;
    }
}
