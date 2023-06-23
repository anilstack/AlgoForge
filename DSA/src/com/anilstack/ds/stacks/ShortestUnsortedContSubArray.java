package com.anilstack.ds.stacks;

import java.util.Map;
import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ShortestUnsortedContSubArray {

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(ShortestUnsortedContSubArray.findUnsortedSubarray(nums));
    }

    private static int findUnsortedSubarray(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int left = nums.length-1;

        for (int i=0; i<nums.length;) {
            if (stack.isEmpty()) {
                stack.push(i);
                i++;
            } else {
                if (nums[stack.peek()] > nums[i]) {
                    left = Math.max(left,stack.peek());
                    stack.pop();
                }else {
                    stack.push(i);
                    i++;
                }
            }
        }

        stack.empty();
        int right = 0;

        for (int i = nums.length-1; i >=0;) {
            if (stack.isEmpty()) {
                stack.push(i);
                i--;
            } else {
                if (nums[stack.peek()] < nums[i]) {
                    right = Math.max(right, stack.peek());
                    stack.pop();
                } else {
                    stack.push(i);
                    i--;
                }
            }
        }

        if (left >= right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }
}
