package com.anilstack.ds.stacks;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MakeArrayNonDecreasing {

    public static void main(String[] args) {

        int[] arr = {5,3,4,4,7,3,6,11,8,5,11};

    }

    private static int totalStepsRequried(int[] arr) {

        int n = arr.length;
        int ans = 0;

        Stack<Map<Integer, Integer>> stack = new Stack<>();

        stack.push(new HashMap<>(arr[n-1],0));

        for (int i = n-2; i >=0; i--) {
            int count = 0;
//            while (!stack.isEmpty() && arr[i] > stack.peek().) {
//
//            }
        }

        return 0;
    }
}
