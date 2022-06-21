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
    private Person partner;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public abstract boolean isRetired();
    public abstract void registerPartnership(Person person) throws AlreadyMarriedException;
    public abstract void deregisterPartnership(boolean isBackToMaidenName);

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
