package cc.robotdreams.my;

import cc.robortdreams.my.Group;
import cc.robortdreams.my.Student;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by asvidersky on 7/1/2022.
 */

public class GroupTest {
    Logger log = LogManager.getLogger(GroupTest.class);

    Student student1 = new Student("Halyna", "Petrenko", 19, "student_1");
    Student student2 = new Student("Natalya", "Ivanenko", 19, "student_2");
    Student student3 = new Student("Sergii", "Sydorenko", 19, "student_3");
    Student student4 = new Student("Mykola", "Kovalenko", 19, "student_4");
    Student student5 = new Student("Volodymyr", "Volodymerynko", 19, "student_5");

    @Test(description = "Test head change")
    public void testChangeHead(){
        Student newHead = new Student("New", "Head", 19, "student_6");
        log.info("Created new Student {}", newHead);
        Group group = new Group("Math", student1, student2, student3, student4, student5);
        log.info("Created new group");
        group.changeHead(newHead);
        assert group.getHead() == newHead;

//        assert group.getStudents().contains(newHead);
//        Assert.assertTrue(group.getStudents().contains(newHead), "Head was not added to the students list");
        assertThat(newHead)
                .as("Head was not added to the group of students")
                .isIn(group.getStudents());
    }

    @Test
    public void testGroup() {
        log.warn("Something went wrong");
    }
}