package asv.cycles;
import org.apache.commons.lang3.RandomUtils;

public class LoopControls {
    public static int getRandomInt() {
//        System.out.println("Generating random int");
        int result = RandomUtils.nextInt(10, 50);
//        System.out.printf("Generated %s %n", result);
        return result;
    }

    public static String getData() {
        while(getRandomInt() < 50) {
            int data = getRandomInt();
            if (data % 2 == 0) {
                return "Done " + data;
            }
        }
        System.out.println("AfterLoop");
        return "Failed";
    }

    public static String getDataWithBreak() {
        while(getRandomInt() < 50) {
            int data = getRandomInt();
            if (data % 2 == 0) {
                break;
            }
        }
        System.out.println("AfterLoop");
        return "Failed";
    }

    public static String getDataWithContinue() {
        while(getRandomInt() < 50) {
            int data = getRandomInt();
            if (data % 2 == 0) {
                continue;
            }
            System.out.println(data);

        }
        System.out.println("AfterLoop");
        return "Failed";
    }

    public static void main(String[] args) {
//        String result = getData();
//        System.out.println(result);

//        String result = getDataWithBreak();
//        System.out.println(result);
        getDataWithContinue();
    }
}

