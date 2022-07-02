package cc.robordreams.my;

import java.util.Objects;

/**
 * Created by asvidersky on 7/1/2022.
 */

public class Student {
    private String name;
    private String lastName;
    private int age;
    private String education;
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && name.equals(student.name) && lastName.equals(student.lastName) && education.equals(student.education) && id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age, education, id);
    }

    public String getName() {
        return name;
    }

    public String getEducation(){
        return this.education;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return this.id;
    }

    public Student(String name, String lastName, int age, String id) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        if (age > 22) this.education = "Graduated";
        if (age < 22) this.education = "Student";
        if (age < 17) this.education = "School";
        if (age < 6) this.education = "Daycare";
    }

    @Override
    public String toString() {
        return String.format("id:'%s' name:'%s' last name:'%s' age:'%s'", this.id, this.name, this.lastName, this.age);
    }
}
