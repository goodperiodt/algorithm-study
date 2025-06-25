package algo2025.june.pattern_printing;

import java.util.Scanner;

// 책임 기반으로 작명한 클래스명
// 유저가 입력한 값을 읽어들이는 클래스
public class UserInputReader {
    private Scanner kb;

    public UserInputReader() {
        this.kb = new Scanner(System.in);
    }

    public int getUserInput(String query) {
        displayQuery(query);
        return readUserInput();
    }

    private void displayQuery(String query) {
        System.out.print(query);
    }

    private int readUserInput() {
        return this.kb.nextInt();
    }

    public void close() {
        if(kb != null) kb.close();
    }
}
