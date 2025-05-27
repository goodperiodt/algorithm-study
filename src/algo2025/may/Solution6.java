package algo2025.may;

import java.util.ArrayList;
import java.util.List;

import static algo2025.may.Util.kb;
import static algo2025.may.Util.log;

public class Solution6 {
    /**
     * 정수 x와 n를 인자로 받음, x부터 시작, x씩 증가하는 숫자 n개를 지니는 리스트 반환
     * @param x, n
     * @return list:ArrayList
     */
    public List<Integer> getList(int x, int n) {
        if(!isValidateX(x)) throw new IllegalArgumentException("입력한 "+x+"는 유효한 숫자가 아닙니다.");
        if(!isValidateN(n)) throw new IllegalArgumentException("입력한 "+n+"는 유효한 숫자가 아닙니다.");

        List<Integer> list = new ArrayList<>();
        // int x = 2, int n = 3;
        // 2(2*1 → x*1), 4(2*2→ x*2), 6(2*3→ x*3)

        // i를 1로 초기화, 1이 3보다 적은 수이기 때문에
        // 2*1을 리스트에 추가함. 그리고 i는 1이 증가해서 i: 2,

        // 2가 3보다 적은 수이기 때문에 2*2를 list 에 추가
        // 그리고 i는 1이 증가해서 3이됨. i: 3

        // 3은 3보다 같거나 작기 때문에
        // 2*3을 리스트에 추가, 그리고 i는 1이 증가해서 4가됨.
        for(int i = 1; i<=n; i++) {
            list.add(x * i);
        }
        return list;
    }

    public boolean isValidateX(int x) {
        // x는 -10000000 이상, 10000000 이하인 정수입니다.
        return x <= 10000000 && x >= -10000000;
    }

    public boolean isValidateN(int n) {
        return n > 0 && n <= 1000;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();

        log.info("정수 x를 입력해주세요>>");
        int x = kb.nextInt();

        log.info("자연수 x를 입력해주세요>>");
        int y = kb.nextInt();
        kb.close();

        List<Integer> list = s.getList(x, y);
        list.forEach(System.out::println);
    }
}
