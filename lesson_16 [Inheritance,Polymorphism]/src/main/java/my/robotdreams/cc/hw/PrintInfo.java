package my.robotdreams.cc.hw;

/**
 * Created by asvidersky on 6/8/2022.
 */

public class PrintInfo implements Info {
    private Man man;
    private Women woman;

    public PrintInfo(Man man) {
        this.man = man;
    }

    public PrintInfo(Women woman) {
        this.woman = woman;
    }

    @Override
    public void printInfoMan() {
        System.out.println("A man is              : " + man.getFirstName() + " " + man.getLastName());
        System.out.println("Age                   : " + man.getAge());
        System.out.println("Is he a retired       : " + man.isRetired());
        String state = (man.getPartner() == null ? "no" : "yes, " + man.getPartner().toString());
        System.out.println("Does he have a partner: " + state);
        System.out.println("Had he served in Army : " + man.isServedArmy());
        System.out.println("-".repeat(25));
    }

    @Override
    public void printInfoWoman() {
        System.out.println("A woman is              : " + woman.getFirstName() + " " + woman.getLastName());
        System.out.println("Age                     : " + woman.getAge());
        System.out.println("Is she a retired        : " + woman.isRetired());
        String state = (woman.getPartner() == null ? "no" : "yes, " + woman.getPartner().toString());
        System.out.println("Does she have a partner : " + state);
        System.out.println("Has she changed her maiden name : " + ((!woman.getLastName().equals(woman.getMaidenName()))
                                                                ? "yes, to " + woman.getLastName() : "no"));
        System.out.println("Previous name was               : " + woman.getPrevLastName());
        System.out.println("Has she back to the maiden name : " + ((!woman.getPrevLastName().equals(woman.getMaidenName())) ? "yes" : "no"));
        System.out.println("-".repeat(25));
    }
}

