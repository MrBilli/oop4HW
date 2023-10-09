package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student extends User {

    public Student(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }


}

class User {
    protected String name;
    protected String surname;
    protected String patronymic;

    public User() {
    }

    ;

    @Override
    public String toString() {
        return name + ' ' +
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
        int resultOfComparing = ((User) (o1)).getSurname().compareTo(((User) (o2)).getSurname());
        if (resultOfComparing == 0) {
            resultOfComparing = ((User) (o1)).getName().compareTo(((User) (o2)).getName());
            if (resultOfComparing == 0) {
                return ((User) (o1)).getPatronymic().compareTo(((User) (o2)).getPatronymic());
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
        return "teacher=" + teacher +
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
