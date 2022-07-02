package cc.robordreams.my;

import java.util.*;

/**
 * Created by asvidersky on 7/1/2022.
 */

public class Group {
    private final Set<Student> students;
    private final Map<Integer, String> tasks;
    private final Map<Student, Map<Integer, String>> taskSolutions;
    private Student head;
    private final String name;


    public Group(String name, Student head, Student... students) {
        this(name, head, Arrays.asList(students));
    }

    public Group(String name, Student head, List<Student> students) {
        this(name, head, new HashSet<>(students));
    }

    public Group(String name, Student head, Set<Student> students) {
        if (head == null) throw new IllegalArgumentException("head must not be null");

        this.name = name;
        this.head = head;
        this.students = students;
        this.students.add(head);
        this.tasks = new HashMap<>();
        this.taskSolutions = new HashMap<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Student removeStudent(String id) {
        if (head.getId().equals(id)) {
            throw new IllegalArgumentException("Can not remove head from group, change head first");
        }

        Student student = getStudentById(id);
        students.remove(student);
        taskSolutions.remove(student);
        return student;
    }

    public void changeHead(Student newHead) {
        if (newHead == null) throw new IllegalArgumentException("head must not be null");
        this.head = newHead;
    //    students.add(newHead);
    }

    public Student getHead() {
        return this.head;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public Student getStudentById(String id) {
        for (Student st : students) {
            if (st.getId().equals(id)) {
                return st;
            }
        }
        throw new IllegalArgumentException(String.format("Student with ID=%s not found", id));
    }

    public void addTask(int id, String task) {
        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException(
                    String.format("Task with id=%s already exists with definition %s", id, tasks.get(id))
            );
        }
        tasks.put(id, task);
    }

    public void updateTask(int id, String newTask) {
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException(
                    String.format("Task with id=%s does not exist", id)
            );
        }
        tasks.put(id, newTask);
    }

    public void addTaskSolution(String studentId, Integer taskId, String solution) {
        Student student = getStudentById(studentId);
        if (!taskSolutions.containsKey(student)) {
            taskSolutions.put(student, new HashMap<>());
        }
        taskSolutions.get(student).put(taskId, solution);
    }
}
