package com.anilstack.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ShorttestPath {



    private class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1},
                {1,0}
        };

        ShorttestPath shorttestPath= new ShorttestPath();
        System.out.println(shorttestPath.shortestPathBinaryMatrix(arr));
    }

    public int shortestPathBinaryMatrix(int[][] arr) {

        int n = arr.length-1;

        if(arr[0][0] == 1 || arr[n][n] == 1) {
            return -1;
        }

        int level = 0;
        Queue<Point> qu = new LinkedList<>();
        qu.offer(new Point(0,0));

        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size-- > 0) {

                Point head = qu.poll();
                int x = head.x;
                int y = head.y;

                if (x==n && y==n) {
                    return level+1;
                }

                if (x < 0 || y < 0 || x > n || y > n || arr[x][y] == 1) {
                    continue;
                }

                qu.offer(new Point(x-1, y));
                qu.offer(new Point(x+1, y));
                qu.offer(new Point(x, y-1));
                qu.offer(new Point(x, y+1));

                qu.offer(new Point(x-1, y-1));
                qu.offer(new Point(x-1, y+1));
                qu.offer(new Point(x+1, y-1));
                qu.offer(new Point(x+1, y+1));

            }
            level++;
        }
        return -1;

    }


}
