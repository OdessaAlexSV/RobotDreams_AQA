package dataproviders;

import cc.robotdreams.my.hw.Man;
import cc.robotdreams.my.hw.Woman;
import org.testng.annotations.DataProvider;

/**
 * Created by asvidersky on 6/24/2022.
 */

public class ManClassDataProvider {
    @DataProvider(name = "Constructor Method test data")
    public static Object [] [] getTestDataConstructor() {
        return new Object [] [] {
                {new Man("Vlad",  "Chub", 40, true)},
                {new Man("Petro", "Shur", 50, false)},
                {new Man("Nazar", "Rymar", 60, true)}
        };
    }

    @DataProvider(name = "Getter First Name test data")
    public static Object [] [] getTestDataFirstName() {
        return new Object [] [] {
                {new Man("Vlad",  "Chub", 40, true), "Vlad" },
                {new Man("Petro", "Shur", 50, false),"Petro"},
                {new Man("Nazar", "Rymar", 60, true),"Nazar"}
        };
    }

    @DataProvider(name = "Getter Last Name test data")
    public static Object [] [] getTestDataLastName() {
        return new Object [] [] {
                {new Man("Vlad",  "Chub", 40, true), "Chub" },
                {new Man("Petro", "Shur", 50, false),"Shur" },
                {new Man("Nazar", "Rymar", 60, true),"Rymar"}
        };
    }

    @DataProvider(name = "Getter Age test data")
    public static Object [] [] getTestDataAge() {
        return new Object [] [] {
                {new Man("Vlad",  "Chub", 40, true), 40},
                {new Man("Petro", "Shur", 50, false),50},
                {new Man("Nazar", "Rymar", 60, true),60}
        };
    }

    @DataProvider(name = "Getter IsServedArmy test data")
    public static Object [] [] IsServedArmy() {
        return new Object [] [] {
                {new Man("Vlad",  "Chub", 40, true ),true },
                {new Man("Petro", "Shur", 50, false),false},
                {new Man("Nazar", "Rymar", 60, true),true }
        };
    }

    @DataProvider(name = "IsRetried test data")
    public static Object [] [] IsRetried() {
        return new Object [] [] {
                {new Man("Vlad",  "Chub",64,true ) ,false},
                {new Man("Petro", "Shur", 65,false),false},
                {new Man("Nazar", "Rymar",66,true ),true }
        };
    }

    @DataProvider(name = "RegisterPartnership")
    public static Object [] [] RegisterPartnership() {
        return new Object [] [] {
                {new Man("Vlad","Chub",64,true ),
                        new Woman("Mary", "Petrova", 31, "Petrova")},
                {new Man("Petro", "Shur", 65,false),
                        new Woman("Mary", "Petrova", 31, "Petrova")},
                {new Man("Nazar", "Rymar",66,true ),
                        new Woman("Mary", "Petrova", 31, "Petrova") }
        };
    }

}
