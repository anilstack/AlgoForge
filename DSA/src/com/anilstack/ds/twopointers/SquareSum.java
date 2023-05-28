package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class SquareSum {
    public static void main(String[] args) {
        int c = 89;
        Boolean result = SquareSum.findSquareSum(c);
        System.out.println(result);
    }
//a2+b2=c
    private static Boolean findSquareSum(int c) {

        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int total = left * left + right * right;
            if (total == c) {
                return true;
            } else if (total > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }


}
