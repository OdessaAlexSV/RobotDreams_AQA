package asv.string.formatted;

public class MainClass {
    public static void main(String[] args) {
        PrintInt printClass = new PrintInt();
        System.out.printf("~~~ %s ~~~ %n", printClass.printNumber());

        System.out.println("as variant of returning number from 2nd class:");
        System.out.printf("~~~ %d ~~~", printClass.printNumber("as number"));
    }
}
