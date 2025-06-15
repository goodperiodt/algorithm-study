package practice.scanner;

import java.util.Scanner;

public class ScannerPractice {
    public static void main(String[] args) {
        // 타입과 클래스의 차이
        /*
            클래스는 속성과 행동을 갖는다.
            클래스를 기반으로 인스턴스화하면 객체가 생성된다.
            타입은 객체의 인터페이스, 객체가 응답할 수 있는 요청의 집합을 정의한다.

            ex. Scanner 타입 참조변수는 Scanner 클래스로부터 생성된 객체를 가리키므로,
            하기와 같이 참조변수 sc는 생성된 스캐너 객체에 메시지를 요청할 수 있다.
        */
        Scanner sc = new Scanner(System.in);
        /* System.out.print("한 단어를 입력해주세요>> ");
        String next = sc.next();
        System.out.println(next);
        sc.nextLine();


        System.out.print("\n한 문장을 입력해주세요>>");
        String oneLine = sc.nextLine();
        System.out.println("leftData: "+oneLine); */
        System.out.print("1: ");
        String nextLine = sc.nextLine(); // 입력 가정: "스캐너와 입력버퍼를" (엔터) → 스캐너의 입력버퍼에서 읽어들일 값: "스캐너와 입력버퍼를"
        // 스캐너의 입력버퍼에 남아있는데이터가 없음.

        System.out.print("2: ");
        String next1 = sc.next(); // 입력 가정: "공부하고 있습니다." (엔터) → 스캐너의 입력버퍼에서 읽어들일 값: 공부하고
        // 스캐너의 입력버퍼에 남아있는 데이터: 공백문자+있습니다.+개행문자
        System.out.print("3: ");
        String next2 = sc.next(); // 스캐너의 입력버퍼에서 읽어들일 값은 공백문자?
        // next2: 있습니다.
        System.out.print("4: ");
        String next3 = sc.next(); // 입력버퍼가 비어있는 상태라 입력한 데이터가 입력버퍼에 개행문자와 함께 들어가고,
        // 개행문자를 남겨두고, 한 단어 단위가 next3 변수에 대입된다.
        // 그 다음 문자열을 온전히 받으려면 버퍼를 비워주어야 한다. nextLine() 메서드를 사용할 것


        System.out.println("1: "+nextLine); // nextLine: 스캐너와 입력버퍼를
        System.out.println("2: "+next1); // next1: 공부하고
        System.out.println("3: "+next2); // next2: 있습니다.
        System.out.println("4: "+next3);

        sc.close();
    }
}
