package my.robotdreams.cc.hw;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SolarPlanets planet = SolarPlanets.EARTH;
        System.out.println(planet);
        System.out.println("-".repeat(15));

        planet = SolarPlanets.valueOf("MARS");
        System.out.println(planet);
        System.out.println("-".repeat(15));

        SolarPlanets[] planets = SolarPlanets.values();
        System.out.println(Arrays.toString(planets));
        for (SolarPlanets pl : planets) {
            System.out.println("-".repeat(15));
            System.out.println("planet name               : " + SolarPlanets.valueOf(pl.name()) + "\n" +
                               "order number from the Sun : " + pl.getNum() + "\n" +
                               "distance from prev planet : " + pl.getDistanceFromPrevPlanet() + "\n" +
                               "distance from the Sun     : " + pl.getDistanceFromSun() + "\n" +
                               "radius                    : " + pl.getRadius() + "\n" +
                               "previous planet           : " + pl.getPrev() + "\n" +
                               "next planet               : " + pl.getNext());
        }
    }
}
