package asv.operators;

public class PrintResult {

    public String printInfo(String condition, boolean rez, int a, int b) {
        String info = "Is the sum of 1st couple numbers %s than 2nd : %s (%s, %s)";
        return String.format(info, condition, rez, a, b);
    }
}
