package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Абстрактный класс для представления студента
class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class StudentExtended extends Student{
    public StudentExtended(String name) {
        super(name);

    }
}

// Параметризованный класс для представления группы студентов
class User {
    protected String name;
    protected String surname;
    protected String patronymic;

    public User(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return  name + ' ' +
                surname + ' ' +
                patronymic + ' ';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

}

class UserComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int resultOfComparing = ((User)(o1)).getSurname().compareTo(((User)(o2)).getSurname());
        if (resultOfComparing == 0) {
            resultOfComparing = ((User)(o1)).getName().compareTo(((User)(o2)).getName());
            if (resultOfComparing == 0) {
                return ((User)(o1)).getPatronymic().compareTo(((User)(o2)).getPatronymic());
            } else {
                return resultOfComparing;
            }
        } else {
            return resultOfComparing;
        }
    }
}

class StudentGroup<T> {

protected Teacher teacher;
    protected String nameGroup;
    protected List<T> group;

    public StudentGroup(String nameGroup, List<T> group) {
        this.nameGroup = nameGroup;
        this.group = group;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public List<T> getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return  "teacher=" + teacher +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }

    public void addStudent(T user) {
        group.add(user);
    }

    public void removeStudent(T user) {
        group.remove(user);
    }
}



//class StudentGroup<T extends User> {
//    private String groupName;
//    private List<T> students;
//
//    public StudentGroup(String groupName) {
//        this.groupName = groupName;
//        this.students = new ArrayList<>();
//    }
//
//    public void addStudent(T student) {
//        students.add(student);
//    }
//
//    public void removeStudent(T student) {
//        students.remove(student);
//    }
//
//    public List<T> getStudents() {
//        return students;
//    }
//
//    public String getGroupName() {
//        return groupName;
//    }
//}

// Контроллер для работы с группами студентов
class GroupController<T extends Student> {
    private List<StudentGroup<T>> groups;

    public GroupController() {
        groups = new ArrayList<>();
    }

    public void createGroup(String groupName, List students) {
        StudentGroup<T> group = new StudentGroup<>(groupName, students);
        groups.add(group);
    }

    public void addStudentToGroup(StudentGroup<T> group, T student) {
        group.addStudent(student);
    }

    public void removeStudentFromGroup(StudentGroup<T> group, T student) {
        group.removeStudent(student);
    }

    public List<StudentGroup<T>> getGroups() {
        return groups;
    }
}
//class Cat{
//    private int age;
//    private String name;
//
//    public Cat(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        // Создаем контроллер
//        GroupController<StudentExtended> controller = new GroupController<>();
//
//        // Создаем группу и добавляем студентов
//        controller.createGroup("Group A");
//        StudentExtended student1 = new StudentExtended("Alice");
//        StudentExtended student2 = new StudentExtended("Bob");
//        controller.addStudentToGroup(controller.getGroups().get(0), student1);
//        controller.addStudentToGroup(controller.getGroups().get(0), student2);
//
//        // Выводим список студентов в группе
//        StudentGroup<StudentExtended> groupA = controller.getGroups().get(0);
//        System.out.println("group " + groupA.getGroupName() + " contains:");
//        for (Student student : groupA.getStudents()) {
//            System.out.println(student.getName());
//        }
//
//    }
//
//}