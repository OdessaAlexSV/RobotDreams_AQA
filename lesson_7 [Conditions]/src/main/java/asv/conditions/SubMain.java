package asv.conditions;

/**
 * Created by asvidersky on 5/13/2022.
 */

public class SubMain {
    public static void main(String[] args) {
        String result = returnStringWithNumber();
        System.out.println("Заданное число - " + result);
        System.out.printf("%1$20s", result);
        System.out.println();
    }

    public static String returnStringWithNumber() {
        int x = 777333;
        return String.valueOf(x);
    }
}
