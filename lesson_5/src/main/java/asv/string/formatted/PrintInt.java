package asv.string.formatted;

public class PrintInt {
    int i = 4567;

    public String printNumber() {
        System.out.println("--- " + i + " ---");
        return String.format("%s", i);
    }

    public int printNumber(String s1) {
        System.out.println("--- " + i + " ---");
        return i;
    }

}
