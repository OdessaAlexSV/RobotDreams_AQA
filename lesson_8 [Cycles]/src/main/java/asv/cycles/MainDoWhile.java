package asv.cycles;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created by asvidersky on 5/13/2022.
 */

public class MainDoWhile {
    public static int getData() {
        System.out.println("Generating random int");
        int result = RandomUtils.nextInt(10, 50);
        System.out.printf("Generated %s %n", result);
        return result;
    }

    public static void main(String[] args) {
        int someResult;
        do {
            someResult = getData();
        } while (someResult < 0);
    }
}
