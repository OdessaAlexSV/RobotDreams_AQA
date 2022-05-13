package asv.cycles;

/**
 * Created by asvidersky on 5/13/2022.
 */

public class NestedLoopExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        String[] alphabet = {"a", "b", "c", "d"};

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 5) {
                continue;
            }
            for (int j = 0; j < alphabet.length; j++) {

                if (alphabet[j] == "c") {
                    continue;
                }
                System.out.printf("Number %d, char %s %n", numbers[i], alphabet[j]);
            }
        }
    }
}
