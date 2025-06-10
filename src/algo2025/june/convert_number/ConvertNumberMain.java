package algo2025.june.convert_number;

public class ConvertNumberMain {
    public static void main(String[] args) {
        String phoneNumber = "01033334444";
        ConverNumber converNumber = new ConverNumber();

        String result = converNumber.solution(phoneNumber);

        System.out.println("result: "+result);
    }
}
