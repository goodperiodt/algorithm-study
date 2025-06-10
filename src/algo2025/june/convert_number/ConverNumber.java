package algo2025.june.convert_number;

// @return - convertPhoneNumber: String, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열
public class ConverNumber {
    public String solution(String phoneNumber) {
        checkNumberLength(phoneNumber);
        return maskPhoneNumber(phoneNumber);
    }

    private String maskPhoneNumber(String phoneNumber) {
        String formatPhoneNumber = "";
        int visibleDigits = 4;
        int unmaskedDigits = phoneNumber.length()-visibleDigits;

        String unMaskedPhoneNumber = phoneNumber.substring(unmaskedDigits);
        formatPhoneNumber += "*".repeat(unmaskedDigits);
        formatPhoneNumber += unMaskedPhoneNumber;

        return formatPhoneNumber;
    }

    private void checkNumberLength(String phoneNumber) {
        int length = phoneNumber.length();
        if(length < 4 || length > 20)
            throw new IllegalArgumentException("전화번호의 길이는 4이상 20이하여야 합니다.");
    }
}
