package algo2025.june.matrix_calculation;

public class MatrixCalculatorMain {
    public static void main(String[] args) {

        int[][] array1 = new int[][] {
                {1,2},
                {2,3}
        };

        int[][] array2 = new int[][] {
                {3,4},
                {5,6}
        };

        MatrixCalculator matrixCalculator = new MatrixCalculator();
        // int[][] ints = matrixCalculator.addMatrices(array1, array2);
        matrixCalculator.print(matrixCalculator.addMatrices(array1, array2));
    }
}
