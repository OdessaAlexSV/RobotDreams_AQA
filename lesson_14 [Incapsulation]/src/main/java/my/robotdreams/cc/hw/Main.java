package my.robotdreams.cc.hw;

public class Main {

    public static void main(String[] args) {
        Student headOfGroup = new Student("111", "Oksana", "Shevchenko");
        Student st1 = new Student("222", "Olga", "Bondarenko");
        Student st2 = new Student("333", "Zlata", "Kovalenko");
        Student st3 = new Student("444", "Bohdan", "Tkachenko");

        System.out.println("\n" + "Initial fill up(adding students) :");
        Group group = new Group(headOfGroup);
        group.addStudent(headOfGroup.getId(), headOfGroup);
        group.addStudent(st3.getId(), st3);
        group.addStudent(st3.getId(), st3);    // specially - check that a student(his ID) is unique
        group.addStudent(st1.getId(), st1);
        group.addStudent(st2.getId(), st2);
        System.out.println(group);

        System.out.println("\n" + "Removing student from group :");
        if (!group.removeStudent("666")) { // specially - check that a student does not exist
            System.out.println("No student exists");
        } else {
            System.out.println(group);
        }

        System.out.println("\n" + "Removing student from group :");
        if (!group.removeStudent(st3.getId())) {
            System.out.println("No student exists");
        } else {
            System.out.println(group);
        }

        System.out.println("\n" + "Renaming student: ");
        st2 = new Student("333", "Nadya", "Muha");
        if (!group.renameStudent(st2.getId(), st2)) {
            System.out.println("No student exists");
        } else {
            System.out.println(group);
        }

        System.out.println("\n" + "Head of group was replaced by an existing student :");
        group.changeHeadOfGroup(st2);
        group.addStudent(headOfGroup.getId(), headOfGroup);
        System.out.println(group);

        System.out.println("\n" + "Head of group was replaced by a new student: ");
        Student newHeadOfGroup = new Student("555", "Petro", "Shevchuk");
        group.changeHeadOfGroup(newHeadOfGroup);
        group.addStudent(newHeadOfGroup.getId(), newHeadOfGroup);
        System.out.println(group);

        System.out.println("\n" + "Head of group was replaced by a new student and left :");
        group.removeStudent(group.getHeadOfGroup().getId());
        group.changeHeadOfGroup(st1);
        System.out.println(group);

        System.out.println("\n" + "Assigned a task for whole group :");
        group.addTaskToGroup("изучить инкапсуляцию");
        group.addTaskToGroup("изучить полезное");
        group.addTaskToGroup("изучить инкапсуляцию"); // specially - check that a task is unique
        group.addTaskToGroup("изучить что-то");
        System.out.println(group);

        System.out.println("\n" + "Mark a task is Done by a student :");
        group.markTaskDoneByStudent("изучить инкапсуляцию", "111");
        group.markTaskDoneByStudent("изучить что-то", "111");
        group.markTaskDoneByStudent("изучить инкапсуляцию", "333");
        group.markTaskDoneByStudent("изучить полезное", "222");
        System.out.println(group);
    }
}
