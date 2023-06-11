package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class PartitionDisjoint {

    public static void main(String[] args) {
        int [] arr = {5,0,3,8,6};
        int result = PartitionDisjoint.partationArray(arr);
        System.out.println(result);
        System.out.println(PartitionDisjoint.partitionDisjointOne(arr));
    }

    public static int partationArray(int[] arr) {

        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            leftMax[i]=max;
        }

        int min = Integer.MAX_VALUE;
        for (int i = arr.length-1; i >=0; i--) {
            min = Math.min(min,arr[i]);
            rightMin[i]=min;
        }

        for (int i = 1; i < arr.length; i++) {
            if (leftMax[i-1] <= rightMin[i]) return i;
        }
        return arr.length;
    }

    public static int partitionDisjointOne(int[] arr) {

        int maxUntillI = arr[0];
        int maxInLeftPart = arr[0];
        int partitionId = 0;
        for (int i = 1; i < arr.length; i++) {
            maxUntillI = Math.max(maxUntillI, arr[i]);
            if (arr[i] < maxInLeftPart) {
                maxInLeftPart = maxUntillI;
                partitionId = i;
            }
        }
        return partitionId+1;
    }
}
