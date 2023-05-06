package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int water = ContainerWithMostWater.maxWaterBtwContainers(heights);
        System.out.println(water);
    }

    private static int maxWaterBtwContainers(int[] heights) {

        int max = 0;
        int left = 0;
        int right = heights.length-1;
//Area = height * width
        while (left < right) {
            int width = (right-left);
            max = Math.max(max, width * Math.min(heights[left],heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
