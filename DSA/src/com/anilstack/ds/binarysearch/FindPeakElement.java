package com.anilstack.ds.binarysearch;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */

public class FindPeakElement {

    //given an array which is unsorted in nature, we need to tell any index of that element which is greater than its neighbors.
    //assume that left most value is -Infinity  and right most element is also -Infinity for example. if arr = [1,2,3,4] return last index.
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        int[] firstArr = {1,2,1,3,5,6,10,15,8};

        System.out.println(FindPeakElement.findPeakElement(arr));

    }

    private static int findPeakElement(int[] arr) {

        int left = 0;
        int right = arr.length-1;


        while (left < right) {
            int mid = left + (right-left)/2;
            //remember here we are working on unsorted array so we are making choice to move both left and right based on our approach.
            if (arr[mid] < arr[mid+1] ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


}
