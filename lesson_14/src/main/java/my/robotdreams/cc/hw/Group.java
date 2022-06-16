package my.robotdreams.cc.hw;

import lombok.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Group {
    private Student headOfGroup;
    private Map<String, Student> students = new HashMap<>();
    private Set<String> tasks = new HashSet<>();

    public Group(@NonNull Student headOfGroup) {
        this.headOfGroup = headOfGroup;
    }

    void setHeadOfGroup(@NonNull Student headOfGroup) {
        this.headOfGroup = headOfGroup;
    }

    public Student getHeadOfGroup() {
        return headOfGroup;
    }

    public Student getStudentOfGroup(String id) {
        return students.get(id);
    }

    public void addStudent(Student student) {
        if (!isStudentNull(student)) {
            students.put(student.getId(), student);
        }
    }

    public boolean removeStudent(Student student) {
        if (isStudentExist(student)) {
            students.remove(student.getId());
            return true;
        }
        return false;
    }

    public boolean renameStudent(Student student) {
        if (!isStudentNull(student)) {
            students.replace(student.getId(), student);
            return true;
        }
        return false;
    }

    public void changeHeadOfGroup(Student student) {
        if (!isStudentNull(student)) {
            setHeadOfGroup(getStudentOfGroup(student.getId()));
        }
    }

    public void addTaskToGroup(String task) {
        tasks.add(task);
        for (String id : students.keySet()) {
            Student student = students.get(id);
            student.setStudentTask(task, false);
        }
    }

    public void markTaskDoneByStudent(String task, Student student) {
        if (!isStudentNull(student)) {
            if (isStudentExist(student)) {
                String studID = student.getId();
                student = students.get(studID);
                student.setStudentTask(task, true);
            }
        }
    }

    private boolean isStudentExist(Student student) {
        return students.containsKey(student.getId()) & students.containsValue(student);
    }

    private boolean isStudentNull(Student student) {
        if (student == null) {
            System.out.println("Student is NULL. It's impossible!");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "-------------------------" + "\n" +
                "headOfGroup : " + headOfGroup.getFirstName() + " " + headOfGroup.getLastName() + "\n" +
                "students : " + students + "\n" +
                "tasks : " + tasks;
    }
}
