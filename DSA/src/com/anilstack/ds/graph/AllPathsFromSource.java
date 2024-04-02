package com.anilstack.ds.graph;

import java.util.*;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class AllPathsFromSource {

    /**
     *    0 --> 1
     *    |     |
     *    v     v
     *    2 --> 3
     * @param args
     */
    public static void main(String[] args) {
        int[][] graphs = {
                {1,2},{3},{3},{}
                         };
        System.out.println(allPathsSourceTarget(graphs));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graphs) {
        List<List<Integer>> ans = new ArrayList<>();
        int endIndex = graphs.length-1;
        int startIndex = 0;

        Queue<List<Integer>> qu = new LinkedList<>();
        qu.add(Arrays.asList(startIndex));

        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size-- > 0) {
              List<Integer> headList = qu.poll();
                if (headList.get(headList.size()-1)==endIndex) {
                    ans.add(headList);
                }
                int lastNode = headList.get(headList.size()-1);
                for (int connection : graphs[lastNode]) {
                    List<Integer> copyList = new ArrayList<>(headList);
                    copyList.add(connection);
                    qu.add(copyList);
                }
            }
        }
        return ans;
    }
}
