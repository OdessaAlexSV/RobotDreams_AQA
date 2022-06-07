package my.robotdreams.cc.hw;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by asvidersky on 6/7/2022.
 */

@Setter
@Getter
public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private boolean partner;
    private String graduation;

    public Person(String firstName, String lastName, int age, boolean partner, String graduation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = partner;
        this.graduation = graduation;
    }

    public abstract boolean isRetired();
    public abstract boolean registerPartnership();
    public abstract boolean deregisterPartnership(boolean isBackToMaidenName);
}
