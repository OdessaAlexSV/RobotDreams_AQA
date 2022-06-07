package my.robotdreams.cc.hw;

/**
 * Created by asvidersky on 6/7/2022.
 */

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Vlad", "Ivanov", 0, false, "OGU",true);
        man.setAge(62);
        System.out.println("A man is              : " + man.getFirstName() + " " + man.getLastName());
        System.out.println("Age                   : " + man.getAge());
        System.out.println("Is he a retired       : " + man.isRetired());
        System.out.println("Had he served in Army : " + man.isServedArmy());
        PrintGraduation graduation = new PrintGraduation(man);
        graduation.printGraduation();

        System.out.println("\n" + "-".repeat(25) + "\n");

        Woman woman = new Woman("Mary", "Ivanova", 0, false, "OPI","Petrova");
        woman.setAge(61);
        System.out.println("A woman is            : " + woman.getFirstName() + " " + woman.getLastName());
        System.out.println("Age                   : " + woman.getAge());
        System.out.println("Is she a retired      : " + woman.isRetired());
        String s = (woman.registerPartnership()) ? "\nPrevious name(maiden) was       : " + woman.getMaidenName() : "";
        System.out.println("Has she changed her maiden name : " + woman.registerPartnership() + s);
        System.out.println("Has she back to the previous name(maiden) : " +
                ((woman.deregisterPartnership(false)) ? "yes, to " + woman.getLastName() : "no"));
        graduation = new PrintGraduation(woman);
        graduation.printGraduation();
    }
}

