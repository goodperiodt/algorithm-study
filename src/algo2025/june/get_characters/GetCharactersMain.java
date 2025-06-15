package algo2025.june.get_characters;

public class GetCharactersMain {
    public static void main(String[] args) {
        String test1 = "abcde";
        String test2 = "qwer";

        GetCharacters gc = new GetCharacters();
        String test1Result = gc.solution(test1);
        System.out.println(test1Result); // "c"

        String test2Result = gc.solution(test2);
        System.out.println(test2Result); // "we"
    }
}
