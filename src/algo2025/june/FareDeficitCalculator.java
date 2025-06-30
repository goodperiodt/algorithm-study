package algo2025.june;

/*
* 클래스명을 지을 때, 책임과(Single Responsibility) 의도에 맞게,
* 의도 - 요금을 계산하고, 나머지 금액을 반환한다.
* 도메인 영역 - "놀이기구", "요금", "잔액"과 같은 도메인 관련 단어를 사용한다.
* 동작보다는 책임 중심, 재사용 고려
*
* 책임 중심을 기반으로 클래스명을 짓는다 - 요금을 계산하고, 부족한 금액을 반환한다.
* FareDeficitCalculator - Fare(요금), Deficit(부족), Calculator(계산기)
* */

public class FareDeficitCalculator {
    public long calculate(int price, int money, int count) {
        validateInputs(price, money, count);
        int totalRideFare = calculateTotalRideFare(price, count);
        return calculateDeficitAmount(money, totalRideFare);
    }

    private void validateInputs(int price, int money, int count) {
        // 매개변수로 전달받는 값이 유효한지를 검증
        validateRideFare(price);
        validateMoneyRange(money);
        validateRideCount(count);
    }

    // price: int - 놀이기구 이용료, 1 ≤ price ≤ 2,500
    private void validateRideFare(int price) {
        if(price < 1 || price > 2500)
            throw new IllegalArgumentException("놀이기구 이용료는 1원 이상 2,500원 이하여야 합니다.");
    }

    // money: long - 자본, 1 ≤ money ≤ 1,000,000,000
    private void validateMoneyRange(int money) {
        if(money < 1 || money > 1000000000)
            throw new IllegalArgumentException("자본은 1원 이상 1,000,000,000만원 이하여야 합니다.");
    }

    // count: long - 놀이기구의 이용 횟수, 1 ≤ count ≤ 2,500
    private void validateRideCount(int count) {
        if(count < 1 || count > 2500 )
            throw new IllegalArgumentException("놀이기구 탑승 횟수는 1회이상 2,500회 이하여야 합니다.");
    }

    // 1. 탑승 횟수에 따라 달라지는 총 이용금액 구하기
    // 탑승 횟수가 1이 아닐 경우, 탑승 횟수에 따른 놀이기구 이용료를 구하는 로직을 진행해야 한다.
    private int calculateTotalRideFare(int price, int count) {
        if(count == 1) return price;

        int totalRideFareByCount = 0;
        for(;count>=1; count--) {
            totalRideFareByCount += count*price;
        }
        return totalRideFareByCount;
    }

    private long calculateDeficitAmount(int money, int totalRideFare) {
        return money >= totalRideFare ? 0 : money - totalRideFare;
    }
}