package com.anilstack.ds.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class LargestRectangleHistogram {
    //area = len * breadth
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(LargestRectangleHistogram.largestRectangleHistogram(heights));
    }

    private static int largestRectangleHistogram(int[] heights) {

        int len = heights.length;

        int[] leftSpan = new int[len];
        Arrays.fill(leftSpan, -1);

        int[] rightSpan = new int[len];
        Arrays.fill(rightSpan, len);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                rightSpan[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.empty();

        for (int i = len-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                leftSpan[stack.pop()] = i;
            }
            stack.push(i);
        }

        int maxResponse = 0;
        for (int i = 0; i < len; i++) {
            maxResponse = Math.max((rightSpan[i] - leftSpan[i] - 1) * heights[i], maxResponse);
        }


        return maxResponse;
    }
}
