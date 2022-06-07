package my.robotdreams.cc.hw;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by asvidersky on 6/7/2022.
 */
@Setter
@Getter
public class Woman extends Person {
    private String maidenName;

    public Woman(String firstName, String lastName, int age, boolean partner, String graduation, String maidenName) {
        super(firstName, lastName, age, partner, graduation);
        this.maidenName = maidenName;
    }

    @Override
    public boolean isRetired() {
        return getAge() > 60;
    }

    @Override
    public boolean registerPartnership() {
        return !getLastName().equals(getMaidenName());
    }

    @Override
    public boolean deregisterPartnership(boolean isBackToPrevName) {
           if (isBackToPrevName){
               setLastName(getMaidenName());
               return true;
           }
           return false;
    }
}
