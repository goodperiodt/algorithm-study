package algo2025.june.pattern_printing;

// @param - n: int 가로길이, m: int 세로길이
// @return - n*m(가로*세로) 길이의 직사각형 출력
public class SquarePrinter {
    public void makeSquare(int n, int m) {
        /* for(int j = 0; j<m; j++) {
            for(int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
        } */

        for(int i=0; i<m; i++) {
            System.out.println("*".repeat(n));
        }
    }
}
