package cc.robotdreams.my.hw;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by asvidersky on 6/21/2022.
 */

public class TestsClassMan {

    @Test
    public void testClassConstructor() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        Assert.assertNotNull(man);
    }

    @Test (groups = "Getter")
    public void testGetFirstName() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        Assert.assertEquals(man.getFirstName(), "Vlad");
    }

    @Test (groups = "Setter")
    public void testSetFirstName() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        man.setFirstName("NewVlad");
        Assert.assertEquals(man.getFirstName(), "NewVlad");
    }

    @Test (groups = "Getter")
    public void testGetLastName() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        Assert.assertEquals(man.getLastName(), "Ivanov");
    }

    @Test (groups = "Setter")
    public void testSetLastName() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        man.setLastName("NewIvanov");
        Assert.assertEquals(man.getLastName(), "NewIvanov");
    }

    @Test (groups = "Getter")
    public void testGetAge() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        Assert.assertEquals(man.getAge(), 62);
    }

    @Test (groups = "Setter")
    public void testSetAge() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        man.setAge(60);
        Assert.assertEquals(man.getAge(), 60);
    }

    @Test (groups = "Getter")
    public void testGetIsServedArmyTrue() {
        Man man = new Man("Vlad", "Ivanov", 62, true);
        Assert.assertTrue(man.isServedArmy());
    }

    @Test (groups = "Getter")
    public void testGetIsServedArmyFalse() {
        Man man = new Man("Vlad", "Ivanov", 62, false);
        Assert.assertFalse(man.isServedArmy());
    }

    @Test (groups = "Setter")
    public void testSetIsServedArmy() {
        Man man = new Man("Vlad", "Ivanov", 62, false);
        man.setServedArmy(true);
        Assert.assertTrue(man.isServedArmy());
    }

    @Test
    public void testIsRetriedTrue() {
        Man man = new Man("Vlad", "Ivanov", 66, false);
        Assert.assertTrue(man.isRetired());
    }

    @Test
    public void testIsRetriedFalse() {
        Man man = new Man("Vlad", "Ivanov", 64, false);
        Assert.assertFalse(man.isRetired());
    }

    @Test
    public void testRegisterPartnershipSuccess() {
        Man man1 = new Man("Vlad", "Ivanov", 62, true);
        Woman woman1 = new Woman("Mary", "Petrova", 31, "Petrova");
        man1.setPartner(woman1);
        Assert.assertEquals(man1.getPartner(), woman1);
    }

}


