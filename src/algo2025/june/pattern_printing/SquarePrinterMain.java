package algo2025.june.pattern_printing;

public class SquarePrinterMain {
    public static void main(String[] args) {
        /* Scanner kb = new Scanner(System.in);

        System.out.print("직사각형의 너비를 숫자로 입력하세요>> ");
        System.out.println();
        int width = kb.nextInt();

        System.out.print("직사각형의 높이를 숫자로 입력하세요>> ");
        System.out.println();
        int height = kb.nextInt(); */

        UserInputReader userInputReader = new UserInputReader();
        SquarePrinter squarePrinter = new SquarePrinter();

        int width = userInputReader.getUserInput("직사각형의 너비를 숫자로 입력하세요>> ");
        int height = userInputReader.getUserInput("직사각형의 높이를 숫자로 입력하세요>> ");

        squarePrinter.makeSquare(width, height);
        userInputReader.close();
    }
}
