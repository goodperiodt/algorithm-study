package algo2025.june.convert_number;

public class ConvertNumber {
    public String solution(String phoneNumber) {
        checkNumberLength(phoneNumber);
        return maskPhoneNumber(phoneNumber);
    }

    private String maskPhoneNumber(String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        int visibleDigits = 4;
        int unmaskedDigits = phoneNumber.length()-visibleDigits;

        return sb.append("*".repeat(unmaskedDigits))
                .append(phoneNumber.substring(unmaskedDigits))
                .toString();
    }

    private void checkNumberLength(String phoneNumber) {
        int length = phoneNumber.length();
        if(length < 4 || length > 20)
            throw new IllegalArgumentException("전화번호의 길이는 4이상 20이하여야 합니다. 입력 값 길이: "+length);
    }
}
