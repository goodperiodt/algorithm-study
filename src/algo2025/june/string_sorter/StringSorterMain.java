package algo2025.june.string_sorter;

public class StringSorterMain {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        StringSorter stringSorter = new StringSorter();
        String result = stringSorter.sortDescending(s);
        System.out.println(result);
    }
}
