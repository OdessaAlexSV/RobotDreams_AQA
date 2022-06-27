import cc.robotdreams.my.hw.Man;
import cc.robotdreams.my.hw.Woman;
import dataproviders.ManClassDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by asvidersky on 6/21/2022.
 */

public class TestsClassMan {
    @Test(dataProvider = "Constructor Method test data", dataProviderClass = ManClassDataProvider.class)
    public void testClassConstructor(Man man) {
        Assert.assertNotNull(man);
    }

    @Test(groups = "Getter",
            dataProvider = "Getter First Name test data", dataProviderClass = ManClassDataProvider.class)
    public void testGetFirstName(Man man, String firstName) {
        Assert.assertEquals(man.getFirstName(), firstName);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = ManClassDataProvider.class)
    public void testSetFirstName(Man man) {
        man.setFirstName("Incognito");
        Assert.assertEquals(man.getFirstName(), "Incognito");
    }

    @Test(groups = "Getter",
            dataProvider = "Getter Last Name test data", dataProviderClass = ManClassDataProvider.class)
    public void testGetLastName(Man man, String lastName) {
        Assert.assertEquals(man.getLastName(), lastName);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = ManClassDataProvider.class)
    public void testSetLastName(Man man) {
        man.setLastName("Phantom");
        Assert.assertEquals(man.getLastName(), "Phantom");
    }

    @Test(groups = "Getter",
            dataProvider = "Getter Age test data", dataProviderClass = ManClassDataProvider.class)
    public void testGetAge(Man man, int age) {
        Assert.assertEquals(man.getAge(), age);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = ManClassDataProvider.class)
    public void testSetAge(Man man) {
        man.setAge(45);
        Assert.assertEquals(man.getAge(), 45);
    }

    @Test(groups = "Getter",
            dataProvider = "Getter IsServedArmy test data", dataProviderClass = ManClassDataProvider.class)
    public void testGetIsServedArmyTrue(Man man, boolean isServedArmy) {
        Assert.assertEquals(man.isServedArmy(),isServedArmy);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = ManClassDataProvider.class)
    public void testSetIsServedArmy(Man man) {
        man.setServedArmy(true);
        Assert.assertTrue(man.isServedArmy());
    }

    @Test(dataProvider = "IsRetried test data", dataProviderClass = ManClassDataProvider.class)
    public void testIsRetried(Man man, boolean isRetried) {
        Assert.assertEquals(man.isRetired(),isRetried);
    }

    @Test(dataProvider = "RegisterPartnership", dataProviderClass = ManClassDataProvider.class)
    public void testRegisterPartnershipSuccess(Man man, Woman woman) {
        man.setPartner(woman);
        Assert.assertEquals(man.getPartner(), woman);
    }
}


