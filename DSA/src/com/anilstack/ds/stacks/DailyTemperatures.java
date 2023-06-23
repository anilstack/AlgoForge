package com.anilstack.ds.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class DailyTemperatures {
//given temperatures represents the daily temperatures, return an array answer such that answer[i] is the no.of days you have to wait
//after i th day to get warmer temperature.(the no. of days that you have to wait after ith date to get warmer temperature)
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = DailyTemperatures.dailyTemperatureTest(temperatures);
        System.out.println(Arrays.toString(ans));
    }


    private static int[] dailyTemperatureTest(int[] temperatures) {

        int[] ans = new int[temperatures.length];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);

        }

        return ans;

    }



























    private static int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }

}
