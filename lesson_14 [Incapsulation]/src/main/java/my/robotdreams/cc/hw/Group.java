package my.robotdreams.cc.hw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Group {
    private Student headOfGroup;
    private Map<String, Student> students = new HashMap<>();
    private Set<String> tasks = new HashSet<>();

    public Group(Student headOfGroup) {
        this.headOfGroup = headOfGroup;
    }

    void setHeadOfGroup(Student headOfGroup) {
        this.headOfGroup = headOfGroup;
    }

    public Student getHeadOfGroup() {
        return headOfGroup;
    }

    public void addStudent(String id, Student student) {
        students.put(id, student);
    }

    public boolean removeStudent(String id) {
        if (isStudentExist(id)) {
            students.remove(id);
            return true;
        }
        return false;
    }

    public boolean renameStudent(String id, Student student) {
        if (isStudentExist(id)) {
            students.replace(id, student);
            return true;
        }
        return false;
    }

    public void changeHeadOfGroup(Student newHeadOfGroup) {
        setHeadOfGroup(newHeadOfGroup);
    }

    public void addTaskToGroup(String task) {
        tasks.add(task);
        for (String id : students.keySet()) {
            Student student = students.get(id);
            student.setStudentTask(task, false);
            students.replace(id, student);
        }
    }

    public void markTaskDoneByStudent(String task, String id) {
        Student student = students.get(id);
        student.setStudentTask(task, true);
        students.replace(id, student);
    }

    private boolean isStudentExist(String id) {
        return students.containsKey(id);
    }

    @Override
    public String toString() {
        return "-------------------------" + "\n" +
                "headOfGroup : " + headOfGroup.getFirstName() + " " + headOfGroup.getLastName() + "\n" +
                "students : " + students + "\n" +
                "tasks : " + tasks;
    }
}
