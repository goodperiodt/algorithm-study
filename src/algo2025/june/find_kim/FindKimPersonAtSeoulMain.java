package algo2025.june.find_kim;

import java.util.logging.Logger;

import static algo2025.may.Util.log;

public class FindKimPersonAtSeoulMain {
    public static void main(String[] args) {
        FindKimPersonAtSeoul fk = new FindKimPersonAtSeoul();

        // String[] persons = {"Park", "Kim", "Lee"};
        String[] persons = {"Park", "Lee", "Kim"};
        String result = fk.findKimPersonAtSeoul(persons);
        log.info(result);
    }
}
