package com.anilstack.ds.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class NextGreaterElementOne {
    //for a number in nums1 we need to check the same number in nums2 then we need to find next higher element
//(immediate to right side of ur current element)
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ans = NextGreaterElementOne.findNextHigherElementTest(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }


    private static int[] findNextHigherElementTest(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextHigherElementForNo = new HashMap<>();

        for (int num : nums2) {

            while (!stack.isEmpty() && num > stack.peek()) {
                nextHigherElementForNo.put(stack.peek(), num);
                stack.pop();
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextHigherElementForNo.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
























    private static int[] findNextHigherElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
//current element in nums2 is higher than peek most element of the stack.
        //remove peek most element for lower element this current value is higher value we will store in map.
        Stack<Integer> stack = new Stack<>();

        for (int value : nums2) {
            while (!stack.isEmpty() && stack.peek() < value) {
                map.put(stack.pop(), value);
            }
            stack.push(value);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
