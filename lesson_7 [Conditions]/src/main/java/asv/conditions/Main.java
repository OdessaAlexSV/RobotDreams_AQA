package asv.conditions;

public class Main {

    public static void switchExample(Integer s, int s2) {
        switch (s) {

            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B");
                break;
            case 3:
                System.out.println("C");
                break;
            default:
                System.out.println("Something else");

        }
    }

    public static boolean isEven(int number) {
        System.out.printf("Checking if %s is even %n", number);
        return number%2 == 0;
    }

    //    public static String checkIf(int x, int y) {
//
//    }
    public static String returnString() {
        return "Greater";
    }

    public static int returnInt() {
        return 10;
    }

    public static void returnVoid() {
    }

    // Пример того как правильно строить многоуровневые конструкции IF ELSE
    public static int calculate(int x, int y, int z, int a, int b, int c) {
        if (x <= 10) {
            return 0;
        }
        // DB call to fetch Y
        if (y >= 11) {
            return 0;
        }
        // Another DB call

        if (z == 100) {
            System.out.println("SUCESS");
            return 10;
        } else {
            return 0;
        }

        // Пример того как НЕ правильно строить многоуровневые конструкции IF ELSE
//        if (x > 10) {
//            // DB call to fetch Y
//            if (y < 11) {
//                // Another DB call
//                if (z == 100) {
//                    System.out.println("SUCESS");
//                } else {
//                    return 0;
//                }
//            } else {
//                return 0;
//            }
//        } else {
//            return 0;
//        }
    }

    public static void main(String[] args) {
        int x = 10;
        String s2;
//        String s;
//        if (x > 10) {
//            s = "Greater";
//        } else {
//            s = "Less";
//        }
//        boolean b = x == 10;
//        int i = (x > 10) ? returnInt() : 10;
//        String s = (x > 10) ? "Greater" : "Less";
//        double result = (x > 10)
//                ?
//                calculate(1,2,3,4,5,6)
//                :
//                calculate(6,7,8,9,10, 11) + Math.pow(2, 9) + 10 + 16 + calculate(8,7,8,9,10, 11);

        switchExample(2 ,3);
    }
}
