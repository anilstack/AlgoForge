package com.anilstack.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class JumpGameII {

    public static void main(String[] args) {

        int[] arr1 = {4,3,3,0,3,1,2};
        int[] arr = {4,2,3,0,3,1,2};
        int index = 5;
        System.out.println(canJump(arr1,index));
    }

    public static boolean canJump(int[] arr, int index) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            if (arr[curr] == 0) return true;

            if (arr[curr] < 0) continue;

            if (curr + arr[curr] < arr.length) {
                queue.add(curr + arr[curr]);
            }

            if (curr - arr[curr] >= 0) {
                queue.add(curr - arr[curr]);
            }

            arr[curr] = -arr[curr];
        }
      return false;
    }


}
