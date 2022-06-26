package cc.robotdreams.my.hw;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Created by asvidersky on 6/7/2022.
 */

@Getter
@Setter
public class Man extends Person {

    private boolean isServedArmy;

    public Man(String firstName, String lastName, int age, boolean isServedArmy) {
        super(firstName, lastName, age);
        this.isServedArmy = isServedArmy;
    }

    @Override
    public boolean isRetired() {
        return this.getAge() > 65;
    }

    @Override
    public void registerPartnership(@NonNull Person person) {
       this.setPartner(person);
    }

    @Override
    public void deregisterPartnership(boolean isBackToPrevName) {
        if (isBackToPrevName) {
            this.getPartner().setPartner(null);
            this.setPartner(null);
        }
    }

}
