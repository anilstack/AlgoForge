package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TrapRainWater {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int totalWater = TrapRainWater.trapWaterBetweenBlocks(arr);
        System.out.println(totalWater);
    }

    public static int trapWaterBetweenBlocks(int[] height) {

        if (height.length <= 0) {
            return 0;
        }

        int n = height.length;

        int[] leftMaxHeight = new int[n];
        int max = height[0];
        for (int i = 0; i<n; i++) {
            max = Math.max(max, height[i]);
            leftMaxHeight[i] = max;
        }

        int[] rightMaxHeight = new int[n];
        max = height[n-1];
        for (int i = n-1; i>=0; i--) {
            max = Math.max(max,height[i]);
            rightMaxHeight[i] = max;
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMaxHeight[i],rightMaxHeight[i])-height[i];
        }

        return totalWater;
    }
}
