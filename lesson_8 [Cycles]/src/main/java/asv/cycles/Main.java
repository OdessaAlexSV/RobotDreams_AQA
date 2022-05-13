package asv.cycles;

/**
 * Created by asvidersky on 5/13/2022.
 */

public class Main {
    public static void main(String[] args) {
        int i = 5;
        i = i + 2;
        i += 2;

        String name = "Tar";
        name += "as";
        System.out.println(name);

        for (String s = "A" ; s.length() < 10 ; s += "b") {
            System.out.printf("Itteration %s %n", s);
        }
      //  for ( ; ; ) { }
    }
}
