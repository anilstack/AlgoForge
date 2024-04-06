package com.anilstack.ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MarkAIsland {
    /**
     * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        System.out.println(largestIsland(grid));
    }

    public static int largestIsland(int[][] grid) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);

        int n = grid.length;
        int gridId = 2;
        for (int i=0; i < n; i++) {
            for (int j=0; j<n;j++) {
                if (grid[i][j] == 1) {
                    int size = assignIdAndReturn(grid, i, j, gridId);
                    map.put(gridId, size);
                    gridId++;
                }
            }
        }

        int res = map.getOrDefault(2,0);
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 0) {

                    Set<Integer> set = new HashSet<>();
                    set.add(i > 0 ? grid[i-1][j] : 0);
                    set.add(i < n - 1 ? grid[i+1][j] : 0);
                    set.add(j > 0 ? grid[i][j-1] : 0);
                    set.add(j < n - 1 ? grid[i][j+1] : 0);

                    int totalArea = 1;
                    for (int id:set) totalArea += map.get(id);
                    res = Math.max(res,totalArea);

                }
            }
        }
        return res;
    }


    private static int assignIdAndReturn(int[][] grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        return 1 + assignIdAndReturn(grid,i+1,j,id) + assignIdAndReturn(grid,i-1,j,id) + assignIdAndReturn(grid,i,j+1,id)
                + assignIdAndReturn(grid,i,j-1,id);
    }
}
