package my.robotdreams.cc.hw;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by asvidersky on 6/7/2022.
 */

@Setter
@Getter
public class Man extends Person {

    private boolean isServedArmy;

    public Man(String firstName, String lastName, int age, boolean partner,String graduation, boolean isServedArmy) {
        super(firstName, lastName, age, partner,  graduation);
        this.isServedArmy = isServedArmy;
    }

    @Override
    public boolean isRetired() {
        return getAge() > 65;
    }

    @Override
    public boolean registerPartnership() {
        return false;
    }

    @Override
    public boolean deregisterPartnership(boolean isBackToPrevName) {
        return isBackToPrevName;
    }
}
