package com.anilstack.ds.graph;

import java.util.*;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class JumpGameIV {

    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumpsToReachEnd(arr));
    }


    public static int minJumpsToReachEnd(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> indices = map.getOrDefault(arr[i],new ArrayList<>());
            indices.add(i);
            map.put(arr[i],indices);
        }
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> qe = new LinkedList<>();
        qe.offer(0);

        int level = 0;
        while (!qe.isEmpty()) {
            int size = qe.size();
            while (size-- > 0) {
              Integer head = qe.poll();


                if (head < 0 || head >= arr.length || !visited[head]) {
                    continue;
                }

              if (head == arr.length-1) return level;

              if (head - 1 > 0 && !visited[head-1]) {
                    qe.offer(head-1);
              }

              if (head + 1 < arr.length && !visited[head+1]) {
                qe.offer(head+1);
              }

              if (map.containsKey(arr[head])) {
                    for (int index : map.get(arr[head])) {
                        if (index >=0 && index < arr.length && !visited[index]) {
                            qe.offer(index);
                        }
                    }
              }
            }
            level++;
        }

        return -1;
    }
}
