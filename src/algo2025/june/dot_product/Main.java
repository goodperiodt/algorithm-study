package algo2025.june.dot_product;

import static algo2025.may.Util.log;

public class Main {
    public static void main(String[] args) {

        int[] array1 = {1,2,3,4};
        int[] array2 = {-3,-1,0,2};

        int[] array3 = {-1,0,1};
        int[] array4 = {1,0,-1};

        DotProductCalculator dc = new DotProductCalculator();

        int dotProduct1 = dc.getDotProduct(array1, array2);
        int dotProduct2 = dc.getDotProduct(array3, array4);

        log.info("dotProduct1: "+dotProduct1); // 3
        log.info("dotProduct2: "+dotProduct2); // -2
    }
}
