package algo2025.june;

import java.util.ArrayList;
import java.util.List;

import static algo2025.may.Util.log;

public class DivisibleNumberFinder {

    /**
     array element 중 divisor 로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수
     divisor 로 나누어 떨어지는 element 가 하나도 없다면 배열에 -1을 담아 반환

     @param arr: int[], divisor: int
     @return int[]
     */

    // int[] array = {2, 3, 4, 5, 7, 9, 11};
    // int divisor = 3;
    public int[] solution(int[] arr, int divisor) {
        checkArrayLength(arr);
        checkArrayElement(arr);
        checkNaturalNumber(divisor);
        return returnArray(arr, divisor);
    }

    // array 의 length 는 1 이상 이어야 한다 → array.length >= 1
    private void checkArrayLength(int[] arr) {
        if(arr.length == 0)
            throw new IllegalArgumentException("빈 배열은 처리할 수 없습니다.");
    }

    // arr 의 요소는 모두 자연수여야(1이상) 한다.
    // {2, 3, 4, 5, 7, 9, 11}
    private void checkArrayElement(int[] arr) {
        for(int number: arr) {
            checkNaturalNumber(number);
        }
    }

    private void checkNaturalNumber(int number) {
        if(!isNaturalNumber(number))
            throw new IllegalArgumentException(number+" 는 자연수가 아닙니다.");
    }

    // divisor 와 배열의 요소들이 1 이상인지 확인하는 메서드
    private boolean isNaturalNumber(int number) {
        return number >= 1;
    }

    private int[] returnArray(int[] arr, int divisor) {
        if(!hasDivisibleElements(arr, divisor)) return new int[] {-1};
        return getDivisibleElementArray(arr, divisor);
    }

    private boolean hasDivisibleElements(int[] arr, int divisor) {
        for(int number: arr) {
            if(number%divisor == 0) return true;
        } return false;
    }

    private int[] getDivisibleElementArray(int[] arr, int divisor) {
        List<Integer> tempList = new ArrayList<>();

        for(int number: arr) {
            if(number%divisor==0) tempList.add(number);
        }

        int[] result = new int[tempList.size()];

        for(int i=0; i<result.length; i++) {
            result[i] = tempList.get(i);
        }
        return result;
    }
}
