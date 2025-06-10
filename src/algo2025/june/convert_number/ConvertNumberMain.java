package algo2025.june.convert_number;

public class ConvertNumberMain {
    public static void main(String[] args) {
        String phoneNumber = "01033334444";
        ConvertNumber convertNumber = new ConvertNumber();

        String result = convertNumber.solution(phoneNumber);

        System.out.println("result: "+result);
    }
}
