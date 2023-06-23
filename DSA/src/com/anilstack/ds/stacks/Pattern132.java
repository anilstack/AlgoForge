package com.anilstack.ds.stacks;

import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class Pattern132 {

    public static void main(String[] args) {
        int[] arr = {7,2,5,9,1,4,3};
        System.out.println(Pattern132.find132PatternTest(arr));
    }


    private static boolean find132PatternTest(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        for (int i = nums.length-1; i >= 0; i--) {

            if (nums[i] < secondMax) return true;

            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                secondMax = Math.max(secondMax,nums[stack.pop()]);
            }
            stack.push(i);
        }

        return false;
    }

















    private static boolean find132Pattern(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        for (int i = arr.length-1; i >=0 ; i--) {

            if (arr[i] < secondMax) return true;

            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                secondMax = Math.max(secondMax, stack.pop());
            }
            stack.push(arr[i]);
        }

        return false;
    }


}
