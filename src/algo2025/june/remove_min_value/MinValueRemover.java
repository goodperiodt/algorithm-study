package algo2025.june.remove_min_value;

// 가장 작은 수를 제거하는 기능(메서드)을 갖는 클래스
// 객체니까 1. 명사형으로 2. 역할 기반으로(무엇을 담당하는가? → Remover)
// 3. 구체적으로 책임중심으로 → 가장 작은 수를 제거하는: MinValueRemover, SmallestNumberRemover

import java.util.Arrays;

// 정수를 저장한 배열에서 가장 작은 수를 제거한 배열을 반환하는 함수
// 단, 반환하는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
// @param - arr: int[]
// @return - result: int[]
// ex. arr - [4,3,2,1]인 경우, [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴
public class MinValueRemover {
    public int[] filterOutMinValue(int[] array) {
        validateArrayLength(array);
        return removeMinValue(array);
    }

    // arr - 길이 1 이상이어야 한다.
    private void validateArrayLength(int[] array) {
        int length = array.length;
        if(length < 1)
            throw new IllegalArgumentException("빈 배열은 처리할 수 없습니다. 입력한 배열의 길이는 "+length);
    }

    private int[] removeMinValue(int[] array) {
        if(array.length == 1) return new int[]{-1};
        return removeValueFromArray(array);
    }

    private int[] removeValueFromArray(int[] array) {
        int minValue = findMinValue(array);
        return Arrays.stream(array)
                .filter(val -> val != minValue)
                .toArray();
    }

    private int findMinValue(int[] array) {
        return Arrays.stream(array)
                .min()
                .getAsInt();
    }
}
