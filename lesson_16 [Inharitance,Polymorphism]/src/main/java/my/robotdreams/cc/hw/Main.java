package my.robotdreams.cc.hw;

import java.util.HashSet;

/**
 * Created by asvidersky on 6/7/2022.
 */

public class Main {
    public static void main(String[] args) {
        HashSet<Man> men = new HashSet<>();
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        men.add(man1);
        Man man2 = new Man("Igor", "Dovbik", 45, false);
        men.add(man2);

        HashSet<Women> women = new HashSet<>();
        Women woman1 = new Women("Mary", "Petrova", 61, "Petrova");
        woman1.setPrevLastName(woman1.getMaidenName());
        women.add(woman1);
        Women woman2 = new Women("Nasty", "Kudry", 40, "Kudry");
        woman2.setPrevLastName(woman2.getMaidenName());
        women.add(woman2);

        System.out.println("\nInitial list of men/women:\n");
        printMenWomen(men, women);

        System.out.println("\nUpdated info after some marriages:\n");
        try {
            woman1.registerPartnership(man1);
            woman2.registerPartnership(man1);
        } catch (AlreadyMarriedException e) {
            e.printStackTrace();
        }

        printMenWomen(men, women);

        System.out.println("\nUpdated info after another marriage:\n");
        try {
            woman2.registerPartnership(man2);
        } catch (AlreadyMarriedException e) {
            e.printStackTrace();
        }
        printMenWomen(men, women);

        System.out.println("\nUpdated info after divorce(via woman):\n");
        woman2.deregisterPartnership(true);
        printMenWomen(men, women);

        System.out.println("\nUpdated info after divorce(via man):\n");
        man1.deregisterPartnership(true);
        printMenWomen(men, women);
    }

    private static void printMenWomen(HashSet<Man> men, HashSet<Women> women) {
        for (Man itemMan : men) {
            PrintInfo infoMan = new PrintInfo(itemMan);
            infoMan.printInfoMan();
        }

        for (Women itemWoman : women) {
            PrintInfo infoWoman = new PrintInfo(itemWoman);
            infoWoman.printInfoWoman();
        }
    }
}

