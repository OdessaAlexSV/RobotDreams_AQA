package asv.tlg;

public class Test {
    public static void main(String[] args) {
        int f;
        f = 5;
        f = ++f + f++;
        System.out.println(f);


        // Unboxing - ???
        int i = 10;
        Integer x = new Integer(10);
        if (x == i) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
