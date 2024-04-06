package com.anilstack.ds.dp;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RangeSumImmutable {

    private static int[] prefixSum = null;

    public static void main(String[] args) {
        int[] arr = {-2,0,3,-5,2,-1};
        System.out.println(new RangeSumImmutable(arr).rangeSum(2,5));
    }

    public RangeSumImmutable(int[] arr) {

        prefixSum = new int[arr.length+1];

        for (int i=0; i<arr.length; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }

    }

    public static int rangeSum(int left, int right) {
        return prefixSum[right+1]-prefixSum[left];
    }


}
