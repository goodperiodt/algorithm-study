package algo2025.june;

public class Temp {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        if(arr1.length != arr2.length)
            return new int[0][0];

        for(int i=0; i < arr1.length; i++) {
            if(arr1[i].length != arr2[i].length)
                return new int[0][0];
        }

        int[][] result = new int[arr1.length][arr1[0].length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1[i].length; j++) {
                result[i][j] = arr1[i][j]+arr2[i][j];
            }
        } return result;
    }
}
