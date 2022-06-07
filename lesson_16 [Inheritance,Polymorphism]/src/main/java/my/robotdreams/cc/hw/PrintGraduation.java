package my.robotdreams.cc.hw;

/**
 * Created by asvidersky on 6/8/2022.
 */

public class PrintGraduation implements Graduation {
    private Person person;

    public PrintGraduation(Person person) {
        this.person = person;
    }

    @Override
    public void printGraduation() {
        System.out.println("Graduated             : " + person.getGraduation());
    }
}

