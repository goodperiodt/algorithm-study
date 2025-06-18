package algo2025.june.dot_product;

// @param - array1, array2 - array1.length == array2.length, int[], 1차원
// @return - a와 b의 내적
// ex. a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] (n은 a, b의 길이)
public class DotProductCalculator {
    public int getDotProduct(int[] array1, int[] array2) {
        //   array1[0]*array2[0]
        // + array1[1]*array2[1]
        // + array1[2]*array2[2]

        // 우선 인자로 전달받는 배열의 길이는 같다. --> 인자로 전달받는 두 배열의 길이가 다른지는 고려의 대상이 아니다.

        // 유효성 체크
        checkValidLength(array1, array2);
        checkValidElement(array1, array2);

        // 연산
        return calculateDotProduct(array1, array2);
    }

    private void checkValidLength(int[] array1, int[] array2) {
            if(isValidLength(array1))
                // error 를 받는 클래스를 따로 만들 것.
                throw new IllegalArgumentException("배열의 길이는 1이상 1000이하여야 합니다. array1.length: "+array1.length);

            if(isValidLength(array2))
                throw new IllegalArgumentException("배열의 길이는 1이상 1000이하여야 합니다. array2.length: "+array2.length);
        }

            private static boolean isValidLength(int[] array) {
                // return array.length >= 1 && array.length <= 1000;
                return array.length == 0 || array.length > 1000;
            }

    private void checkValidElement(int[] array1, int[] array2) {
        for(int elementInArray: array1) {
            if(isNotValidRange(elementInArray))
                throw new IllegalArgumentException("배열의 요소는 -1,000 이상 1,000 이하여야 합니다. 유효하지 않은 요소 발견: "+elementInArray);
        }

        for(int elementInArray: array2) {
            // 배열의 모든 요소는(모든 수는) -1,000 이상 1,000 이하입니다.
            if(isNotValidRange(elementInArray))
                throw new IllegalArgumentException("배열의 요소는 -1,000 이상 1,000 이하여야 합니다. 유효하지 않은 요소 발견: "+elementInArray);
        }
    }

        // 배열의 모든 요소는(모든 수는) -1,000 이상 1,000 이하입니다.
        private boolean isNotValidRange(int elementInArray) {
            // isValidRange(int elementInArray)
            // return -1000 <= elementInArray && elementInArray <= 1000;
            return elementInArray < -1000  || 1000 < elementInArray;
        }

    private int calculateDotProduct(int[] array1, int[] array2) {
        int total = 0;
        int length = array1.length;

        for(int i = 0; i < length; i++) {
            total += array1[i]*array2[i];
        } return total;
    }
}
