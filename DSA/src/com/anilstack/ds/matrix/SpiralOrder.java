package com.anilstack.ds.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,4},{6,3,7},{5,9,8}};
        System.out.println(sprialOrder(matrix));
    }

    public static List<Integer> sprialOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        if (matrix.length == 0) return ans;

        int startRow = 0;
        int endRow = matrix.length-1;
        int startColumn = 0;
        int endColumn = matrix[0].length-1;

        while (startRow <= endRow && startColumn <= endColumn) {

            //move right side
            for (int j = startColumn; j <= endColumn; j++) {
                ans.add(matrix[startRow][j]);
            }
            startRow++;

            //move down side
            for (int j = startRow; j <= endRow; j++) {
                ans.add(matrix[j][endColumn]);
            }
            endColumn--;

            if (startRow <= endRow) {
                //move left side
                for (int j = endColumn; j >= startColumn; j--) {
                    ans.add(matrix[endRow][j]);
                }
                endRow--;
            }

            if (startColumn <= endColumn) {
                //move top side
                for (int i = endRow; i >= startRow; i--) {
                    ans.add(matrix[i][startColumn]);
                }
                startColumn++;
            }

        }
        return ans;
    }


}
