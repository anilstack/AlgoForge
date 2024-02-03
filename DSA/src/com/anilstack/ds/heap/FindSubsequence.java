package com.anilstack.ds.heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FindSubsequence {

    public int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> (a[0]-b[0]));

        for (int i = 0; i < nums.length; i++) {

            queue.offer(new int[]{nums[i],i});
            if (queue.size() > k) {
                queue.poll();
            }
        }

        Set<Integer> indexSet = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            indexSet.add(top[1]);
        }
        int[] ans = new int[k];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indexSet.contains(i)) {
                ans[p] = nums[i];
                p++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,3};
        int k = 3;
        FindSubsequence findSubsequence = new FindSubsequence();
        int[] result = findSubsequence.maxSubsequence(nums,k);
        System.out.println(Arrays.toString(result));
    }


}
