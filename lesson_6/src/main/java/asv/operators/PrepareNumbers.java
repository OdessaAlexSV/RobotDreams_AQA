package asv.operators;

import java.util.Scanner;

public class PrepareNumbers {
    public static int s1, s2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input 1st int number:");
        int i1 = in.nextInt();

        System.out.println("Input 2nd int number:");
        int i2 = in.nextInt();

        System.out.println("Input 3rd int number:");
        int i3 = in.nextInt();

        System.out.println("Input 4th int number:");
        int i4 = in.nextInt();

        ComparisonNumbers comparisonNumbers = new ComparisonNumbers();
        System.out.println("-".repeat(10));

        s1 = sum(i1, i2);
        s2 = sum(i3, i4);

        PrintResult printResult = new PrintResult();
        System.out.println(printResult.printInfo("greater", comparisonNumbers.isGreater(s1, s2), s1, s2));
        System.out.println(printResult.printInfo("fewer  ", comparisonNumbers.isFewer(s1, s2), s1, s2));
        System.out.println("-".repeat(10));

        s1 = increaseBy1(sum(i1, i2));
        s2 = decreaseBy2(sum(i3, i4));

        System.out.println(printResult.printInfo("greater", comparisonNumbers.isGreater(s1, s2), s1, s2));
        System.out.println(printResult.printInfo("fewer  ", comparisonNumbers.isFewer(s1, s2), s1, s2));
        System.out.println("-".repeat(10));

        System.out.println("Is there an even sum : " + (even(s1) == 0 || even(s2) == 0)
                + " (" + s1 + ", " + s2 + ")");

        in.close();
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int increaseBy1(int a) {
        return ++a;
    }

    private static int decreaseBy2(int a) {
        a--;
        return --a;
    }

    private static int even(int a) {
        return a % 2;
    }
}
