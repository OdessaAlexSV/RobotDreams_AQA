package my.robotdreams.cc.hw;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private Map<String, Boolean> studentTask = new HashMap<>();

    public Student(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setStudentTask(String task, boolean state) {
        getStudentTask().put(task, state);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.studentTask;
    }
}
