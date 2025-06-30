package algo2025.june;

public class FareDeficitCalculatorMain {
    public static void main(String[] args) {

        int price = 3;
        int money = 20;
        int count = 4;

        FareDeficitCalculator fareDeficitCalculator = new FareDeficitCalculator();
        long result = fareDeficitCalculator.calculate(price, money, count);
        System.out.println(result);
    }
}
