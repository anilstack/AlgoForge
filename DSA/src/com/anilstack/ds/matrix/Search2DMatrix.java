package com.anilstack.ds.matrix;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int targetElement = 7;
        System.out.println(findTargetElement(matrix,targetElement));
    }

    public static boolean findTargetElement(int[][] matrix, int targetElement) {

        int rowLength = matrix.length;
        if (rowLength == 0) return false;
        int colLength = matrix[0].length;
        if (colLength == 0) return false;

        int i = rowLength - 1;
        int j = 0;
        while (i >=0 && matrix[i][j] > targetElement) {
            i--;
        }

        if (i < 0) return false;

        int[] subMatrix = matrix[i];
        int index = binarySearch(subMatrix,targetElement);
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private static int binarySearch(int[] array, int targetElement) {

        int len = array.length;

        if (len == 0) return -1;

        int low = 0;
        int high = len;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == targetElement) {
                return mid;
            } else if (array[mid] < targetElement) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low < array.length && array[low] == targetElement) {
            return low;
        } else {
            return -1;
        }

    }
}
