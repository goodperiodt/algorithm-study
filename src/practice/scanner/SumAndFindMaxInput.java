package practice.scanner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalInt;

import static algo2025.may.Util.kb;
import static algo2025.may.Util.log;

public class SumAndFindMaxInput {
    // 사용자로부터 n개의 정수를 입력받은 후, 합과 최댓값을 구해서 출력하기

    // 입력받은 정수로 배열을 생성하기.
    private int[] makeIntArray(int n) {
        checkNumber(n);
        return new int[n];
    }

    private void checkNumber(int n) {
        if(!isValid(n))
            throw new IllegalArgumentException("500이하의 자연수 입력만 가능합니다.");
    }

    private boolean isValid(int n) {
        return n>=1 && n<=500;
    }

    private void execute() {
        log.info("입력하실 정수의 갯수를 입력해주세요.");
        int arrayLength = kb.nextInt();
        // int arrayLength = Integer.parseInt(kb.nextLine());
        String isBuffer = kb.nextLine();
        int[] intArray = makeIntArray(arrayLength);

        log.info(",로 구분하여 정수 "+intArray.length+"개를 입력해주세요");
        String inputNumberOneLine = kb.nextLine();
        String[] splits = inputNumberOneLine.split(",");
        if(splits.length<=1)
            throw new IllegalArgumentException("최소 2개 이상은 입력하셔야 합니다.");

        for(int i=0; i< splits.length; i++) {
            intArray[i] = Integer.parseInt(splits[i].trim());
        }

        int sum = Arrays
                .stream(intArray)
                .sum();

        int max = Arrays
                .stream(intArray)
                .max()
                .getAsInt();

        log.info("sum: "+sum+", max"+max);
    }

    public static void main(String[] args) {
        SumAndFindMaxInput sm = new SumAndFindMaxInput();
        sm.execute();
    }
}
