package algo2025.june.get_characters;

// @param - word: String
// @return - character: String
// *** 단어의 길이가 짝수일 경우, 가운데 두글자 반환
// *** word.length() - 1 이상, 100이하
public class GetCharacters {
    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 100;

    public String solution(String word) {
        checkWordLength(word); // qwer
        return returnCharacter(isWordLengthIsEven(word), word);
    }

    private void checkWordLength(String word) {
        int length = getWordLength(word);
        if(length < 1 || length > 100)
            throw new IllegalArgumentException("단어의 길이는 "+MIN_LENGTH+"이상 "+MAX_LENGTH+"이하여야 합니다. 입력된 단어 길이:"+length);
    }

    private int getWordLength(String word) {
        return word.length();
    }

    private boolean isWordLengthIsEven(String word) {
        int length = getWordLength(word);
        return length%2==0;
    }

    private String returnCharacter(boolean flag, String word) {
        int length = getWordLength(word);

        if(length == 1 || length == 2) return word;

        return flag?
                returnEvenCharacters(length, word):
                returnOddCharacter(length, word);
    }

    /*
        글자 사이즈가 2*2일 때, 글자 2에서 (2+1)번까지 반환
        글자 사이즈가 2*3일 때, 글자 3에서 (3+1)번까지 반환
        글자 사이즈가 2*4일 때, 글자 4에서 (4+1)번까지 반환
        글자 사이즈가 2*5일 때, 글자 5에서 (5+1)번까지 반환
        글자 사이즈가 2의 배수일 때 → 글자 길이가(word.length()) 짝수일 때 → word.length()%2 == 0
        글자 사이즈를 나눈 몫이 시작 번호가 되어 그 다음 수까지 반환한다. wordLength/2
     */
    private String returnEvenCharacters(int wordLength, String word) {
        int quotient = getQuotientDivideTwo(wordLength);
        return word.substring(quotient-1, quotient+1);
    }

    private int getQuotientDivideTwo(int wordLength) {
        return wordLength / 2;
    }

    /*
        글자 사이즈가 3일 때, 몫이 1, 나머지가 1 // 가나다
        글자 사이즈가 5일 때, 몫이 2, 나머지가 1
        글자 사이즈가 7일 때, 몫이 3, 나머지가 1
        글자 사이즈가 9일 때, 몫이 4, 나머지가 1
        나머지는 1로 고정
        subString(몫, 몫+1)
    */
    private String returnOddCharacter(int wordLength, String word) {
        int quotient = getQuotientDivideTwo(wordLength);// 몫
        return word.substring(quotient, quotient+1);
    }
}
