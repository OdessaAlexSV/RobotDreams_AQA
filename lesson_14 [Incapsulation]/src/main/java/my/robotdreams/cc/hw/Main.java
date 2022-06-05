package my.robotdreams.cc.hw;

public class Main {

    public static void main(String[] args) {
        Student headOfGroup = null;
        Student st1 = new Student("222", "Olga", "Bondarenko");
        Student st2 = new Student("333", "Zlata", "Kovalenko");
        Student st3 = null;
        Student st6 = new Student("666", "Oleh", "Surmach");

        System.out.println("\n" + "Create a group w/o head of group :");
        if (isHeadOfFGroupNull(headOfGroup)) {
            Group group = new Group(headOfGroup);
            System.out.println(group);
        }

        System.out.println("\n" + "Initial fill up(adding students) :");
        headOfGroup = new Student("111", "Oksana", "Shevchenko");
        if (isHeadOfFGroupNull(headOfGroup)) {
            Group group = new Group(headOfGroup);
            group.addStudent(headOfGroup);
            group.addStudent(st3);           // specially - check that a student is NULL
            group.addStudent(st1);
            group.addStudent(st1);           // specially - check that a student(his ID) is unique
            group.addStudent(st2);
            System.out.println(group);

            System.out.println("\n" + "Removing student from group :");
            if (!group.removeStudent(st6)) { // specially - check that a student does not exist
                System.out.println("No student exists");
            } else {
                System.out.println(group);
            }

            System.out.println("\n" + "Removing student from group :");
            if (!group.removeStudent(st2)) {
                System.out.println("No student exists");
            } else {
                System.out.println(group);
            }

            System.out.println("\n" + "Renaming student: ");
            st2 = new Student("222", "Nadya", "Muha");
            if (!group.renameStudent(st2)) {
                System.out.println("No student exists");
            } else {
                System.out.println(group);
            }

            System.out.println("\n" + "Head of group was replaced by an existing student :");
            group.changeHeadOfGroup(st1);
            group.addStudent(headOfGroup);
            System.out.println(group);

            System.out.println("\n" + "Head of group was replaced by a new student :");
            Student newHeadOfGroup = new Student("555", "Petro", "Shevchuk");
            group.addStudent(newHeadOfGroup);
            group.changeHeadOfGroup(newHeadOfGroup);
            System.out.println(group);

            System.out.println("\n" + "Head of group was replaced by a student from group and left :");
            group.removeStudent(group.getHeadOfGroup());
            group.changeHeadOfGroup(group.getStudentOfGroup("222"));
            System.out.println(group);

            System.out.println("\n" + "Assigned a task for whole group :");
            group.addTaskToGroup("изучить инкапсуляцию");
            group.addTaskToGroup("изучить полезное");
            group.addTaskToGroup("изучить инкапсуляцию"); // specially - check that a task is unique
            group.addTaskToGroup("изучить что-то");
            System.out.println(group);

            System.out.println("\n" + "Mark a task is Done by a student :");
            group.markTaskDoneByStudent("изучить инкапсуляцию", headOfGroup);
            group.markTaskDoneByStudent("изучить инкапсуляцию", st1);
            group.markTaskDoneByStudent("изучить что-то", st1);
            group.markTaskDoneByStudent("изучить инкапсуляцию", st3); // specially - check that a student does not exist
            group.markTaskDoneByStudent("изучить полезное", st2);
            System.out.println(group);
        }
    }

    private static boolean isHeadOfFGroupNull(Student headOfGroup) {
        if (headOfGroup != null) {
            return true;
        } else {
            System.out.println("Head of Group is NULL. Group can not exist w/o a head of group!");
            return false;
        }
    }
}