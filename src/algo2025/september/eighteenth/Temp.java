package algo2025.september.eighteenth;

// @param - array: int[], commands: int[][]
//ex. array - [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3
//array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//배열 정렬 후, [2, 3, 5, 6]
//정렬된 배열의 3번째 숫자는 5
// @return int[]
public class Temp {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int resultIndex = 0;

        for(int[] command : commands) // command: [i, j, k]
        {
            int startIndex = command[0];
            int endIndex = command[1];
            int target = command[2];

            int[] splitArray = new int[endIndex-startIndex+1]; // ex. 2번째부터 5번째까지
            // 요소 두 번째는 인덱스1 --> startIndex-1
            for(int i=startIndex-1, j=0; i<endIndex; i++, j++) {
                splitArray[j]=array[i];
            }

            // 배열요소 정렬하기
            for(int i=0; i< splitArray.length-1; i++) {
                for(int j=0; j < splitArray.length-1-i; j++) {
                    if(splitArray[j]>splitArray[j+1]) {
                        int temp = splitArray[j];
                        splitArray[j] = splitArray[j+1];
                        splitArray[j+1] = temp;
                    }
                }
            }

            result[resultIndex] = splitArray[target-1];
            resultIndex++;
        } return result;
    }
}
