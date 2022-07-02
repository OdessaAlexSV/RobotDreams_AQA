package cc.robordreams.my;

import java.util.Locale;

/**
 * Created by asvidersky on 7/1/2022.
 */

public class ClassUnderTest {
    int counter = 0;

    public String methonUnderTest1(String name) {
        if (name.startsWith("T")) {
            throw new IllegalArgumentException("Should not start with T");
        }
        return name.toLowerCase(Locale.ROOT);
    }

    public void doSomeMagic() {
//        if (counter < 8){
//            counter++;
//            return;
//        }
        throw new IllegalStateException("Too much");

    }
}
