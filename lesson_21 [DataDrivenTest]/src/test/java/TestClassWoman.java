import cc.robotdreams.my.hw.AlreadyMarriedException;
import cc.robotdreams.my.hw.Man;
import cc.robotdreams.my.hw.Woman;
import dataproviders.WomanClassDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by asvidersky on 6/21/2022.
 */

public class TestClassWoman {

    @Test(dataProvider = "Constructor Method test data", dataProviderClass = WomanClassDataProvider.class)
    public void testClassConstructor(Woman woman) {
        Assert.assertNotNull(woman);
    }

    @Test(groups = "Getter",
            dataProvider = "Getter First Name test data", dataProviderClass = WomanClassDataProvider.class)
    public void testGetFirstName(Woman woman, String firstName) {
        Assert.assertEquals(woman.getFirstName(), firstName);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = WomanClassDataProvider.class)
    public void testSetFirstName(Woman woman) {
        woman.setFirstName("Nataliy");
        Assert.assertEquals(woman.getFirstName(), "Nataliy");
    }

    @Test(groups = "Getter",
            dataProvider = "Getter Last Name test data", dataProviderClass = WomanClassDataProvider.class)
    public void testGetLastName(Woman woman, String lastName) {
        Assert.assertEquals(woman.getLastName(), lastName);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = WomanClassDataProvider.class)
    public void testSetLastName(Woman woman) {
        woman.setLastName("Nova");
        Assert.assertEquals(woman.getLastName(), "Nova");
    }

    @Test(groups = "Getter",
            dataProvider = "Getter Age test data", dataProviderClass = WomanClassDataProvider.class)
    public void testGetAge(Woman woman, int age) {
        Assert.assertEquals(woman.getAge(), age);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = WomanClassDataProvider.class)
    public void testSetAge(Woman woman) {
        woman.setAge(45);
        Assert.assertEquals(woman.getAge(), 45);
    }

    @Test(groups = "Getter",
            dataProvider = "Getter Maiden Name test data", dataProviderClass = WomanClassDataProvider.class)
    public void testGetMaidenName(Woman woman, String maidenName) {
        Assert.assertEquals(woman.getMaidenName(), maidenName);
    }

    @Test(groups = "Setter",
            dataProvider = "Constructor Method test data", dataProviderClass = WomanClassDataProvider.class)
    public void testSetMaidenName(Woman woman) {
        woman.setMaidenName("Moloda");
        Assert.assertEquals(woman.getMaidenName(), "Moloda");
    }

    @Test(dataProvider = "IsRetried test data", dataProviderClass = WomanClassDataProvider.class)
    public void testIsRetriedTrue(Woman woman, boolean isRetried) {
        Assert.assertEquals(woman.isRetired(), isRetried);
    }

    @Test(dataProvider = "RegisterPartnership", dataProviderClass = WomanClassDataProvider.class)
    public void testRegisterPartnershipSuccess(Man man, Woman woman) throws AlreadyMarriedException {
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getPartner(), man);
    }

    @Test(dataProvider = "RegisterPartnership", dataProviderClass = WomanClassDataProvider.class)
    public void testRegisterPartnershipSuccessChangeLastName(Man man, Woman woman) throws AlreadyMarriedException {
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }

    @Test(dataProvider = "RegisterPartnership", dataProviderClass = WomanClassDataProvider.class)
    public void testRegisterPartnershipSuccessPartnerRegisterPartnership(Man man, Woman woman) throws AlreadyMarriedException {
        woman.registerPartnership(man);
        Assert.assertEquals(man.getPartner(), woman);
    }

    @Test(dataProvider = "RegisterPartnershipTwoMarriage", dataProviderClass = WomanClassDataProvider.class)
    public void testRegisterPartnershipSuccessTwoMarriage(Man man1, Man man2, Woman woman) throws AlreadyMarriedException {
        woman.registerPartnership(man1);
        woman.registerPartnership(man2);
        Assert.assertEquals(woman.getPartner(), man2);
    }

    @Test(expectedExceptions = AlreadyMarriedException.class,
            dataProvider = "RegisterPartnershipShouldTrowException", dataProviderClass = WomanClassDataProvider.class)
    public void testRegisterPartnershipShouldTrowException(Man man, Woman woman1, Woman woman2) throws AlreadyMarriedException {
        woman1.registerPartnership(man);
        woman2.registerPartnership(man);
    }

    @Test(dataProvider = "DeregisterPartnership", dataProviderClass = WomanClassDataProvider.class)
    public void testDeregisterPartnership(Man man, Woman woman, boolean isBackToPrevName) throws AlreadyMarriedException {
        woman.registerPartnership(man);
        woman.deregisterPartnership(isBackToPrevName);
        if (isBackToPrevName) {
            Assert.assertNull(woman.getPartner());
        } else {
            Assert.assertNotNull(woman.getPartner());
        }
    }

    @Test(dataProvider = "DeregisterPartnership", dataProviderClass = WomanClassDataProvider.class)
    public void testDeregisterPartnershipBackToMaidenName(Man man, Woman woman, boolean isBackToPrevName) throws AlreadyMarriedException {
        woman.registerPartnership(man);
        woman.deregisterPartnership(isBackToPrevName);
        if (isBackToPrevName) {
            Assert.assertEquals(woman.getLastName(), woman.getMaidenName());
        } else {
            Assert.assertNotEquals(woman.getLastName(), woman.getMaidenName());
        }
    }

    @Test(dataProvider = "DeregisterPartnership", dataProviderClass = WomanClassDataProvider.class)
    public void testDeregisterPartnershipPartnerSetHisPartnerAsNull(Man man, Woman woman, boolean isBackToPrevName) throws AlreadyMarriedException {
        woman.registerPartnership(man);
        woman.deregisterPartnership(isBackToPrevName);
        if (isBackToPrevName) {
            Assert.assertNull(man.getPartner());
        } else {
            Assert.assertNotNull(man.getPartner());
        }
    }
}