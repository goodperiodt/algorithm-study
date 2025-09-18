package algo2025.september.eighteenth;

import java.util.Arrays;

public class Temp {
    private int[] findKthValueInSortedRanges(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int i=0; i< commands.length; i++){
            int[] command = commands[i];
            int[] subArray = extractRange(array, command[0], command[1]);
            sortArray(subArray);
            result[i] = subArray[command[2]-1];
        }
        return result;
    }

    private int[] extractRange(int[] array, int begin, int end) {
        int[] subArray = new int[end - begin + 1]; // ex. 2번째부터 5번째까지
        // 요소 두 번째는 인덱스1 --> begin-1
        // Arrays.copyOfRange(array, from, to) from 은 포함, to 는 제외라
        // Arrays.copyOfRange(array, begin - 1, end) 이렇게 작성할 수도 있다.
        for (int i = begin - 1, j = 0; i < end; i++, j++) {
            subArray[j] = array[i];
        }
        return subArray;
    }

    private void sortArray(int[] subArray) {
        // Arrays.sort(subArray);
        for (int i = 0; i < subArray.length - 1; i++) {
            for (int j = 0; j < subArray.length - 1 - i; j++) {
                swapIfGreater(subArray, j);
            }
        }
    }

    private void swapIfGreater(int[] subArray, int j) {
        if (subArray[j] > subArray[j + 1]) {
            int temp = subArray[j];
            subArray[j] = subArray[j + 1];
            subArray[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Temp temp = new Temp();
        int[] result = temp.findKthValueInSortedRanges(array, commands);
        System.out.println(Arrays.toString(result));
    }
}
