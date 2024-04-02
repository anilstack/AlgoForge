package com.anilstack.ds.graph;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class UniquePathsIII {

    /**
     * You are given an m x n integer array grid where grid[i][j] could be:
     *
     * 1 representing the starting square. There is exactly one starting square.
     * 2 representing the ending square. There is exactly one ending square.
     * 0 representing empty squares we can walk over.
     * -1 representing obstacles that we cannot walk over.
     *
     * return maximum no.of four directional ways.
     */
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePathsIII(grid));
    }


    private static int uniquePathsIII(int[][] grid) {

        int zero = 0;
        int sx = 0;
        int sy = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c]==0) zero++;
                else if (grid[r][c]==1) {
                    sx = r;
                    sy = c;
                }
            }
        }
        return dfs(grid,sx,sy,zero);
    }

    private static int dfs(int[][] grid, int x, int y, int zero) {

        if (x < 0 || y < 0 || x>= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            return zero == -1 ? 1 : 0;
        }

        grid[x][y] = -1; //mark as visited.
        zero--;

        int totalPaths = dfs(grid,x+1,y,zero) + dfs(grid,x-1,y,zero) + dfs(grid,x, y+1,zero) + dfs(grid,x,y-1,zero);

        grid[x][y] = 0;
        zero++;

        return totalPaths;

    }

}
