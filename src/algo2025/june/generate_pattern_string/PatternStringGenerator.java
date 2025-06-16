package algo2025.june.generate_pattern_string;

// 숫자 타입 인자 값을 기반으로 패턴 문자열을 반환하는 기능을 갖는 클래스
// 핵심은 패턴 문자열 생성 그리고 반환 → 패턴 문자열 생성기
public class PatternStringGenerator {
    private String patternString = "수박";
    private int count = 500;

    public PatternStringGenerator() {
        this.patternString = repeatPattern();
    }

    private String repeatPattern() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(this.patternString);
        }
        return sb.toString();
    }

    public String generatePatternString(int length) {
        checkLength(length);
        if(length==1) return this.patternString.substring(0, 1);
        return repeatPatternToLength(length);
    }

    private void checkLength(int length) {
        if(length <= 0 || length > 1000)
            throw new IllegalArgumentException("패턴 문자열 생성의 최소 길이는 1이상, 1000이하여야 합니다.");
    }

    private String repeatPatternToLength(int length) {
        return this.patternString.substring(0, length);
    }
}