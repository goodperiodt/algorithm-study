package algo2025.june;

public class BaseConverterMain {
    public static void main(String[] args) {
        int number = 45;
        BaseConverter baseConverter = new BaseConverter();
        int result = baseConverter.convertReversedTernaryToDecimal(number);
        System.out.println(result);
    }
}
