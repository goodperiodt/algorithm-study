package algo2025.june;

public class BaseConverter {
    private final int BASE_3 = 3;

    public int convertReversedTernaryToDecimal(int n) {
        String ternaryString = convertToTernary(n);
        return convertTernaryToDecimal(ternaryString);
    }

    private String convertToTernary(int n) {
        StringBuilder ternaryStringBuilder = new StringBuilder();

        while(n != 0) {
            ternaryStringBuilder.append(n%BASE_3);
            n /=BASE_3;
        }

        return ternaryStringBuilder
                .reverse()
                .toString();
    }

    private int convertTernaryToDecimal(String ternaryString) {
        int ternaryToDecimalValue = 0;
        String reversedTernaryString = getTernaryComplement(ternaryString);

        int[] ternaryDigitsArray = reversedTernaryString
                .chars()
                .map(unicodeValue -> unicodeValue - '0')
                .toArray();

        for(int i = 0; i < ternaryDigitsArray.length; i++) {
            int digit = ternaryDigitsArray[i];
            int power = (ternaryDigitsArray.length-1)-i;
            ternaryToDecimalValue += digit * (int) Math.pow(BASE_3, power);
        }

        return ternaryToDecimalValue;
    }

    private String getTernaryComplement(String ternaryString) {
        StringBuilder sb = new StringBuilder(ternaryString);
        return sb.reverse().toString();
    }
}