package com.anilstack.ds.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class Shift2DGrid {

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(shiftGrid(grid,4));
    }

    private static List<List<Integer>> shiftGrid(int[][] gird, int k) {

        int m = gird.length;
        int n = gird[0].length;
        int total = m * n;
        k = k % total;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int index = findShiftedIndex(i,j,n,k,total);
                subList.add(gird[index/n][index%n]);
            }
            result.add(subList);
        }
        return result;
    }

    private static int findShiftedIndex(int i, int j, int col, int k, int total) {
        int index = (i * col + j + total - k) % total;
        return index;
    }
}
