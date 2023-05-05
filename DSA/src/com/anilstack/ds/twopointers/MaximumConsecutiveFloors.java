package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 *
 *
 *
 * Alice manages a company and has rented some floors of a building as office space.
 * Alice has decided some of these floors should be special floors, used for relaxation only.
 *
 * You are given two integers bottom and top, which denote that Alice has rented all the floors from bottom to top (inclusive).
 * You are also given the integer array special, where special[i] denotes a special floor that Alice has designated for relaxation.
 *
 * Return the maximum number of consecutive floors without a special floor.
 *
 *  @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 *
 */
public class MaximumConsecutiveFloors {
    public static void main(String[] args) {
        int bottom = 2;
        int top = 9;
        int [] specialFloors = {4,6};
        int maxFloorCount = MaximumConsecutiveFloors.maxConsecutive(bottom, top, specialFloors);
        System.out.println(maxFloorCount);
    }
    //TC: O(n logn)
    //SC: O(1)
    private static int maxConsecutive(int bottom, int top, int[] specialFloors) {

        Arrays.sort(specialFloors);
        int start = bottom;
        int end = top;
        int ans = 0;

        for (int i = 0; i<specialFloors.length; i++) {
            int specialFloorIndex = specialFloors[i];
            int diff = specialFloorIndex - start;
            ans = Math.max(diff, ans);
            start = specialFloorIndex + 1;
        }

        ans = Math.max(ans, end - specialFloors[specialFloors.length-1]);
        return ans;
    }
}
