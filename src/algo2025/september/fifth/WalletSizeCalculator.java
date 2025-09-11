package algo2025.september.fifth;
// 최소직사각형, https://school.programmers.co.kr/learn/courses/30/lessons/86491

/* @param sizes: int[][] - 명함 가로 길이와 세로 길이
모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때,
지갑의 크기를 반환하는 method 를 가진 클래스 작성
 */

public class WalletSizeCalculator {
    // 각 명함 길이를 긴쪽, 짧은쪽 으로 배치하는 것이 핵심.

    // *** swap 로직 함수화 하기 전에는 아래 두 변수 선언 및 사용이 가능하지만
    // swap 로직 함수화 후에는 사용 불가능으로 적용이 안됨.

    // int WIDTH = 0;
    // int HEIGHT = 1;

    // for-each 문으로 index 없애기 (완료)
        /*
            walletSize --> 가로, 세로 크기를 모두 알 수 있는,
            Math.max() 활용 리팩토링 (완료) ,

            리팩토링 전,

            if(walletSize[0]>widthMax) widthMax = walletSize[0];
            if(walletSize[1]>heightMax) heightMax = walletSize[1];
        */

    // 클래스 상수 선언: WIDTH, HEIGHT
    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;

    // calculateMinimumWalletSize --> 클래스명이 WalletSizeCalculator 라 getMinimum 으로 작명해도 되지 않나?
    // get 은 로직이 포함되어 있지 않은, 단순한 필드 값 반환을 (관습적으로) 의미하는 바
    // compute 또는 calculate 이름을 포함해 함수명을 짓는 것이 좋다.
    // calculateMinimum
    public int calculateMinimum(int[][] sizes) {
        int widthMax = 0;
        int heightMax = 0;

        for(int[] walletSize : sizes) {
            normalizeSize(walletSize);
            widthMax = Math.max(widthMax, walletSize[WIDTH]);
            heightMax = Math.max(heightMax, walletSize[HEIGHT]);
        }

        return widthMax*heightMax;
        /* for(int index = 0 ; index < sizes.length; index++) {


            if(sizes[index][0]<sizes[index][1]) {
                int temp = sizes[index][0];
                sizes[index][0] = sizes[index][1];
                sizes[index][1] = temp;
            }
            // 여기서 가로세로 최댓값을 갱신하는 로직을 작성하기.
            if(sizes[index][0]>0Max) 0Max = sizes[index][0];
            if(sizes[index][1]>1Max) 1Max = sizes[index][1];
        }
        return 0Max*1Max;
         */
    }

    // swap 로직 함수화하기 (완료)
    // Math.max() 사용으로 더 간결하게 표현 가능하나, 굳이..? 할 필요성을 못 느낌.
    private void normalizeSize(int[] walletSize) {
        if(walletSize[WIDTH]< walletSize[HEIGHT]) {
            int temp = walletSize[WIDTH];
            walletSize[WIDTH] = walletSize[HEIGHT];
            walletSize[HEIGHT] = temp;
        }
    }
}
