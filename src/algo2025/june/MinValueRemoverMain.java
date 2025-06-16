package algo2025.june;

import java.util.Arrays;

public class MinValueRemoverMain {
    public static void main(String[] args) {
        int[] array1 = {4,3,2,1};
        int[] array2 = {10};

        MinValueRemover mr = new MinValueRemover();
        int[] resultArray1 = mr.filterOutMinValue(array1);
        int[] resultArray2 = mr.filterOutMinValue(array2);

        System.out.println(Arrays.toString(resultArray1));
        System.out.println(Arrays.toString(resultArray2));
    }
}
