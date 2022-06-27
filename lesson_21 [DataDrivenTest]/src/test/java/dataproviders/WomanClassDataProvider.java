package dataproviders;

import cc.robotdreams.my.hw.Man;
import cc.robotdreams.my.hw.Woman;
import org.testng.annotations.DataProvider;

/**
 * Created by asvidersky on 6/24/2022.
 */

public class WomanClassDataProvider {
    @DataProvider(name = "Constructor Method test data")
    public static Object[][] getTestDataConstructor() {
        return new Object[][]{
                {new Woman("Mariy", "Shasliva", 59, "Zoriy")},
                {new Woman("Nasty", "Kudriy", 60, "Vesela")},
                {new Woman("Eva", "Polska", 61, "Zhuyko")}
        };
    }

    @DataProvider(name = "Getter First Name test data")
    public static Object[][] getTestDataFirstName() {
        return new Object[][]{
                {new Woman("Mariy", "Shasliva", 59, "Zoriy"), "Mariy"},
                {new Woman("Nasty", "Kudriy", 60, "Vesela"), "Nasty"},
                {new Woman("Eva", "Polska", 61, "Zhuyko"), "Eva"}
        };
    }

    @DataProvider(name = "Getter Last Name test data")
    public static Object[][] getTestDataLastName() {
        return new Object[][]{
                {new Woman("Mariy", "Shasliva", 59, "Zoriy"), "Shasliva"},
                {new Woman("Nasty", "Kudriy", 60, "Vesela"), "Kudriy"},
                {new Woman("Eva", "Polska", 61, "Zhuyko"), "Polska"}
        };
    }

    @DataProvider(name = "Getter Age test data")
    public static Object[][] getTestDataAge() {
        return new Object[][]{
                {new Woman("Mariy", "Shasliva", 59, "Zoriy"), 59},
                {new Woman("Nasty", "Kudriy", 60, "Vesela"), 60},
                {new Woman("Eva", "Polska", 61, "Zhuyko"), 61}
        };
    }

    @DataProvider(name = "Getter Maiden Name test data")
    public static Object[][] getTestDataMaidenName() {
        return new Object[][]{
                {new Woman("Mariy", "Shasliva", 59, "Zoriy"), "Zoriy"},
                {new Woman("Nasty", "Kudriy", 60, "Vesela"), "Vesela"},
                {new Woman("Eva", "Polska", 61, "Zhuyko"), "Zhuyko"}
        };
    }

    @DataProvider(name = "IsRetried test data")
    public static Object[][] IsRetried() {
        return new Object[][]{
                {new Woman("Mariy", "Shasliva", 59, "Zoriy"), false},
                {new Woman("Nasty", "Kudriy", 60, "Vesela"), false},
                {new Woman("Eva", "Polska", 61, "Zhuyko"), true}
        };
    }

    @DataProvider(name = "RegisterPartnership")
    public static Object[][] RegisterPartnership() {
        return new Object[][]{
                {new Man("Vlad", "Chub", 64, true),
                        new Woman("Mariy", "Shasliva", 59, "Zoriy")
                },
                {new Man("Petro", "Shur", 65, false),
                        new Woman("Nasty", "Kudriy", 60, "Vesela")
                },
                {new Man("Nazar", "Rymar", 66, true),
                        new Woman("Eva", "Polska", 61, "Zhuyko")
                }
        };
    }

    @DataProvider(name = "RegisterPartnershipTwoMarriage")
    public static Object[][] RegisterPartnershipTwoMarriage() {
        return new Object[][]{
                {new Man("Vlad", "Chub", 64, true),
                        new Man("Petro", "Shur", 65, false),
                        new Woman("Mariy", "Shasliva", 59, "Zoriy")
                }
        };
    }

    @DataProvider(name = "RegisterPartnershipShouldTrowException")
    public static Object[][] RegisterPartnershipShouldTrowException() {
        return new Object[][]{
                {new Man("Vlad", "Chub", 64, true),
                        new Woman("Eva", "Polska", 61, "Zhuyko"),
                        new Woman("Mariy", "Shasliva", 59, "Zoriy")
                }
        };
    }

    @DataProvider(name = "DeregisterPartnership")
    public static Object[][] DeregisterPartnership() {
        return new Object[][]{
                {new Man("Vlad", "Chub", 64, true),
                        new Woman("Mariy", "Shasliva", 59, "Zoriy"),
                        true
                },
                {new Man("Petro", "Shur", 65, false),
                        new Woman("Nasty", "Kudriy", 60, "Vesela"),
                        false
                },
                {new Man("Nazar", "Rymar", 66, true),
                        new Woman("Eva", "Polska", 61, "Zhuyko"),
                        true
                }
        };
    }
}
