package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ThreeEqualPartsArray {

    public static void main(String[] args) {
        int[] arr = {0,0,1,0,1,0,1,0,1,0,0,1,0,1};
        int[] result = ThreeEqualPartsArray.dividedIntoThreeParts(arr);
        System.out.println(Arrays.toString(result));

    }

    private static int[] dividedIntoThreeParts(int[] arr) {

        int[] ans = new int[]{-1,-1};

        int numOf1s = 0;
        for (int val:arr) {
            numOf1s += val;
        }

        if (numOf1s == 0) {
            return new int[]{0,2};
        }

        if (numOf1s %3 != 0) {
            return ans;
        }

        int noOfOnesInEachPart = numOf1s / 3;
        int indexOfFirst1InPart0 = -1;
        int indexOfFirst1InPart1 = -1;
        int indexOfFirst1InPart2 = -1;
        numOf1s = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                numOf1s++;
            }
            if (numOf1s == 2 + 1) {
                indexOfFirst1InPart1 = i;
            } else if (numOf1s == 2 * noOfOnesInEachPart + 1) {
                indexOfFirst1InPart2 = i;
            } else if (numOf1s == 1) {
                indexOfFirst1InPart0 = i;
            }
        }

        while (indexOfFirst1InPart2 < arr.length) {
            if (arr[indexOfFirst1InPart2] == arr[indexOfFirst1InPart0] && arr[indexOfFirst1InPart2] == arr[indexOfFirst1InPart1]) {
                indexOfFirst1InPart0++;
                indexOfFirst1InPart1++;
                indexOfFirst1InPart2++;
            } else {
                return ans;
            }
        }
        return new int[]{indexOfFirst1InPart0-1,indexOfFirst1InPart1};
    }

}
