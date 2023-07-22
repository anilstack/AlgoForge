package com.anilstack.ds.binarysearch;

public class KokoEatingBananas {
    //we are giving piles[i] bananas. koko can chooses some pile of bananas and eats k bananas;
    //if pile has less than k thn she will eat all of them she wont eat any more in that hours.
    //need to identify k minimum integer k. then she will eat all the bananas in given h hours.
    public static void main(String[] args) {

        int[] piles = {3,6,7,11}; int h = 8;
        int[] piles1 = {30,11,23,4,20}; int h1 = 5;
        //range(on values)
        // based binary search
        System.out.println(KokoEatingBananas.minEatingSpeed(piles,h));
    }

    private static int minEatingSpeed(int[] piles, int hours) {

        long low = 1;
        long high = piles[0];
        for (int pile : piles) {
            high = Math.max(pile,high);
        }

        while (low < high) {
            long mid = low + (high - low) / 2;
            if(!isPossibleToEatAll(piles,hours,mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) low;
    }

    private static boolean isPossibleToEatAll(int[] piles, int hours, long currK) {

        long count = 0;
        for (int pile : piles) {
            count += pile/currK;
            if (pile/currK != 0) {
                count++;
            }
        }

        return (count <= currK);


    }

}
