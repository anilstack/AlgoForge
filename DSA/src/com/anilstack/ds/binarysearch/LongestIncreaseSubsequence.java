package com.anilstack.ds.binarysearch;

import java.util.TreeSet;

public class LongestIncreaseSubsequence {

    public static void main(String[] args) {
        int[] arr = {2,3,7,5,9,101,18};
        System.out.println(LongestIncreaseSubsequence.findLongestIncreaseSubsequence(arr));
    }

    private static int findLongestIncreaseSubsequence(int[] arr) {

        TreeSet<Integer> binarySearch = new TreeSet<>();
        for (int num : arr) {
            Integer higerOrEqualNumber = binarySearch.ceiling(num);
            if (higerOrEqualNumber==null) {
                binarySearch.add(num);
            } else {
                binarySearch.remove(higerOrEqualNumber);
                binarySearch.add(num);
            }
        }
        System.out.println(binarySearch.toString());
        return binarySearch.size();
    }
}
