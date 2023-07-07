package com.anilstack.ds.binarysearch;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class firstBadVersion {

    public static void main(String[] args) {

      System.out.println(firstBadVersion.findFirstBadVersion(5));

    }

    private static int findFirstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        return left;
    }

    private static boolean isBadVersion(int mid) {
        if(mid==4){
            return true;
        } else {
            return false;
        }
    }
}
