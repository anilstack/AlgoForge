package com.anilstack.ds.binarysearch;

public class MaximumCandiesAllocatedToChildren {

    public static void main(String[] args) {
        int[] candies = {4,15,6,7};
        long k = 3;
        System.out.println(MaximumCandiesAllocatedToChildren.allocatedCandiesToChildren(candies,k));
    }
//at least we can give 1 candie to all childrens
    private static int allocatedCandiesToChildren(int[] candies, long childrenToDistribute) {

        long low = 1;
        int max = 0;

        for (int candie : candies) {
            max = Math.max(candie,max);
        }

        long high = max;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canAllocateCandies(candies, childrenToDistribute, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (canAllocateCandies(candies, childrenToDistribute, low) ? low : low - 1);
    }

    private static boolean canAllocateCandies(int[] candies, long childrenToDistribute, long totalCandies) {

        if (totalCandies == 0) return true;

        long totalChildrenSupported = 0;

        for (int candie : candies) {

            totalChildrenSupported += candie / totalCandies;

            if (totalChildrenSupported >= childrenToDistribute) {
                return true;
            }

        }


        return false;
    }
}
