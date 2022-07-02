package cc.robotdreams.my;

import cc.robordreams.my.Student;
import org.testng.annotations.Test;

/**
 * Created by asvidersky on 7/1/2022.
 */

public class StudentTest {
    @Test(dataProvider = "student data from CSV", dataProviderClass = DataProviders.class)
    public void testStudent(String name, String lastName, String age, String grade){
        Student st = new Student(name, lastName, Integer.parseInt(age), "student_1");
        assert st.getEducation().equals(grade);
    }
}
