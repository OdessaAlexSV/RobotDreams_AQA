package my.robotdreams.cc.hw;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Created by asvidersky on 6/7/2022.
 */
@Setter
@Getter
public class Women extends Person {
    private String maidenName;
    private String prevLastName;

    public Women(String firstName, String lastName, int age, String maidenName) {
        super(firstName, lastName, age);
        this.maidenName = maidenName;
    }

    @Override
    public boolean isRetired() {
        return getAge() > 60;
    }

    @Override
    public void registerPartnership(@NonNull Person person) throws AlreadyMarriedException {
        String womanLastName = womanLastNameAdjustment(person.getLastName());

        if (person.getPartner() == null) {
            this.setLastName(womanLastName);
            this.setPartner(person);
            person.registerPartnership(this);

        }

        if (!person.getPartner().equals(this))  {
            throw new AlreadyMarriedException(person.getFirstName() + " " + person.getLastName() + " is already married!");
        }
    }

    @Override
    public void deregisterPartnership(boolean isBackToPrevName) {
        if (isBackToPrevName) {
            this.setPrevLastName(getLastName());
            this.setLastName(getMaidenName());
            this.getPartner().setPartner(null);
            this.setPartner(null);
        }
    }

    private String womanLastNameAdjustment(String partnerLastName) {
        String adjustedLastName;
        String twoLastLetters = partnerLastName.substring(partnerLastName.length() - 2);
        switch (twoLastLetters) {
            case ("ov"):
                adjustedLastName = partnerLastName + 'a';
                break;
            case ("iy"):
                adjustedLastName = (partnerLastName.length() - 2) + "ay";
                break;
            default:
                adjustedLastName = partnerLastName;
                break;
        }
        return adjustedLastName;
    }
}
