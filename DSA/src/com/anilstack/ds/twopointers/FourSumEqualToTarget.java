package com.anilstack.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FourSumEqualToTarget {

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, 2, -2};
        int target = 0;
        System.out.println(FourSumEqualToTarget.findFourSum(arr,target));
    }


    private static List<List<Integer>> findFourSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {

            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < arr.length - 2; j++) {

                if (j != i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> combinations = new ArrayList<>();
                        combinations.add(arr[i]);
                        combinations.add(arr[j]);
                        combinations.add(arr[left]);
                        combinations.add(arr[right]);

                        ans.add(combinations);

                        left++;
                        right--;

                        while (left < right && arr[left] == arr[left - 1]) {
                            left++;
                        }

                        while (left < right && arr[right] == arr[right + 1]) {
                            right--;
                        }
                    }
                }

            }
        }
        return ans;
    }
}
