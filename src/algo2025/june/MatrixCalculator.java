package algo2025.june;

import java.util.Arrays;

public class MatrixCalculator {
    public int[][] addMatrices(int[][] arr1, int[][] arr2) {
        validateSameShape(arr1, arr2);
        return sumElementWise(arr1, arr2);
    }

    private void validateSameShape(int[][] arr1, int[][] arr2) {
        if(arr1.length != arr2.length)
            // 행의 길이가 다른경우
            throw new IllegalArgumentException("배열의 길이가 다릅니다.");

        for(int i=0; i < arr1.length; i++) {
            if(arr1[i].length != arr2[i].length)
                // 열의 길이가 다른 경우
                throw new IllegalArgumentException("각 배열의 요소의 길이가 다릅니다.");
        }
    }

    private int[][] sumElementWise(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr1[0].length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1[i].length; j++) {
                result[i][j] = arr1[i][j]+arr2[i][j];
            }
        } return result;
    }

    public void print(int[][] matrix) {
        for(int[] array : matrix)
            System.out.println(Arrays.toString(array));
    }
}