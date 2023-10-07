package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<User> list1 = new ArrayList<>();
        StudentGroup<User> group1 = new StudentGroup<>("Group1", list1);

        User student1 = new Student("George", "Washington", "Alexandrovich");
        User student2 = new Student("James", "Bond", "Viktorovich");
        User student3 = new Student("John", "Dow", "Igorevich");

        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);

        UserComparator<User> userComparator = new UserComparator<>();
        TreeSet<User> sortedGroup = new TreeSet<>(userComparator);
        for (User l : group1.getGroup()) {
            System.out.println(l);
            sortedGroup.add(l);
        }

        TeacherController teacherController = new TeacherController();
        Teacher teacher = teacherController.newTeacher(group1);
//        Teacher teacher1 = teacherController.newTeacher(group1);
//        Teacher teacher2 = teacherController.newTeacher(group1);
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
//        teachers.add(teacher1);
//        teachers.add(teacher2);
        TeachersGroup<Teacher> teachersGroup = new TeachersGroup<>(teachers);
        teacherController.vievTeachersGroup(teachersGroup);
    }
}