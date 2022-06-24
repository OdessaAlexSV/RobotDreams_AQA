package cc.robotdreams.my.hw;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by asvidersky on 6/21/2022.
 */

public class TestClassWoman {

    @Test
    public void testClassConstructor() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        Assert.assertNotNull(woman);
    }

    @Test (groups = "Getter")
    public void testGetFirstName() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        Assert.assertEquals(woman.getFirstName(), "Mary");
    }

    @Test (groups = "Setter")
    public void testSetFirstName() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        woman.setFirstName("NewMary");
        Assert.assertEquals(woman.getFirstName(),"NewMary");
    }

    @Test (groups = "Getter")
    public void testGetLastName() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        Assert.assertEquals(woman.getLastName(), "Petrova");
    }

    @Test (groups = "Setter")
    public void testSetLastName() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        woman.setLastName("NewPetrova");
        Assert.assertEquals(woman.getLastName(),"NewPetrova");
    }

    @Test (groups = "Getter")
    public void testGetAge() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        Assert.assertEquals(woman.getAge(),61);
    }

    @Test (groups = "Setter")
    public void testSetAge() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        woman.setAge(60);
        Assert.assertEquals(woman.getAge(),60);
    }

    @Test (groups = "Getter")
    public void testGetMaidenName() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        Assert.assertEquals(woman.getMaidenName(),"Petrova");
    }

    @Test (groups = "Setter")
    public void testSetMaidenName() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        woman.setMaidenName("OldPetrova");
        Assert.assertEquals(woman.getMaidenName(),"OldPetrova");
    }

    @Test
    public void testIsRetriedTrue() {
        Woman woman = new Woman("Mary", "Petrova", 61, "Petrova");
        Assert.assertTrue(woman.isRetired());
    }

    @Test
    public void testIsRetriedFalse() {
        Woman woman = new Woman("Mary", "Petrova", 31, "Petrova");
        Assert.assertFalse(woman.isRetired());
    }

    @Test
    public void testRegisterPartnershipSuccess() throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        Assert.assertEquals(woman1.getPartner(),man1);
    }

    @Test
    public void testRegisterPartnershipSuccessChangeLastName() throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        Assert.assertEquals(woman1.getLastName(),"Ivanova");
    }

    @Test
    public void testRegisterPartnershipSuccessPartnerRegisterPartnership() throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        Assert.assertEquals(man1.getPartner(),woman1);
    }

    @Test
    public void testRegisterPartnershipSuccessTwoMarriage() throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Man man2 = new Man("Igor", "Dovbik", 45, false);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        woman1.registerPartnership(man2);
        Assert.assertEquals(woman1.getPartner(), man2);
    }

    @Test(expectedExceptions = AlreadyMarriedException.class)
    public void testRegisterPartnershipShouldTrowException() throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        Woman woman2 = new Woman("Nasty", "Kudry", 40, "Kudry");
        woman1.registerPartnership(man1);
        woman2.registerPartnership(man1);
    }

    @Test
    public void testDeregisterPartnershipSuccess() throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        woman1.deregisterPartnership(true);
        Assert.assertNull(woman1.getPartner());
    }

    @Test
    public void testDeregisterPartnershipUnsuccessful() throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        woman1.deregisterPartnership(false);
        Assert.assertEquals(woman1.getLastName(), "Ivanova");
    }

    @Test
    public void testDeregisterPartnershipBackToMaidenName () throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        woman1.deregisterPartnership(true);
        Assert.assertEquals(woman1.getLastName(), "Petrova");
    }

    @Test
    public void testDeregisterPartnershipPartnerSetHisPartnerAsNull () throws AlreadyMarriedException {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        woman1.registerPartnership(man1);
        woman1.deregisterPartnership(true);
        Assert.assertNull(man1.getPartner());
    }

}