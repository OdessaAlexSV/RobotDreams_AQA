package my.robotdreams.cc.hw;

public enum SolarPlanets {
    MERCURY(1,0,2439,null),
    VENUS(2,50,6052,MERCURY),
    EARTH(3,42,6378,VENUS),
    MARS(4,78,3488,EARTH),
    JUPITER(5,550,71300,MARS),
    SATURN(6,651,60100,JUPITER),
    URANUS(7,1446,26500,SATURN),
    NEPTUN(8,1622,2439,URANUS),
    PLUTO(9,1416,2000,NEPTUN);

    private int num;
    private int distanceFromPrevPlanet;
    private int distanceFromSun;
    private int radius;
    private SolarPlanets prev;
    private SolarPlanets next;

    SolarPlanets(int num, int distanceFromPrevPlanet, int radius, SolarPlanets prev) {
        this.num = num;
        this.distanceFromPrevPlanet = distanceFromPrevPlanet;
        if (prev == null) {
            this.distanceFromSun = this.distanceFromPrevPlanet + 58;
        } else {
            this.distanceFromSun = prev.getDistanceFromSun() + this.distanceFromPrevPlanet;
        }
        this.radius = radius;
        this.prev = prev;
        if (prev != null) {
            prev.next = this;
        }
    }

    public int getNum() {
        return num;
    }

    public int getDistanceFromPrevPlanet() {
        return distanceFromPrevPlanet;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public SolarPlanets getPrev() {
        return prev;
    }

    public SolarPlanets getNext() {
        return next;
    }
}