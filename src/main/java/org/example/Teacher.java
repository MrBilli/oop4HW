package org.example;

//-- Создать класс Учитель

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// -- Создать класс УчительСервис ;(добавляем валидацию)
//— Создать класс УчительВью;(Выводим в консоль)
//— Создать класс УчительКонтроллер(Работа с данными: принимает данные в класс Учитель и отправляет в Учитель вью)
// и реализовать возможность создания, редактирования конкретного учителя и отображения списка учителей, имеющихся в системе.
//--Создать класс ГруппаУчителей
//--Добавить поле учитель в учебную группу

class Teacher extends User {

    protected String studyGroup;

    @Override
    public String toString() {
        return '\n' + "name '" + name + '\'' + '\n' +
                "surname '" + surname + '\'' + '\n' +
                "patronymic '" + patronymic + '\'' + '\n' +
                "Group of students " + studyGroup;
    }

    public Teacher(StudentGroup<User> group) {
        TeacherController newTeacher = new TeacherController();
        this.name = newTeacher.setNameTeacher();
        this.surname = newTeacher.setSurnameTeacher();
        this.patronymic = newTeacher.setPatronymicTeacher();
        this.studyGroup = group.nameGroup;
    }
}


class TeachersGroup<T extends User> {

    protected ArrayList<T> teachers = new ArrayList<>();

    @Override
    public String toString() {
        return "teachers: " + '\n' +
                teachers;
    }

    public TeachersGroup(ArrayList<T> teachers) {
        this.teachers.addAll(teachers);
    }
}

interface TeachersViev {

    void vievTeachersGroup(TeachersGroup group);
}


class TeacherController implements TeachersViev {
    public TeacherController() {
    }

    @Override
    public void vievTeachersGroup(TeachersGroup group) {
        System.out.println('\n');
        System.out.println(group);
    }

    public void addTeacherToGroup(Teacher teacher, TeachersGroup group) {
        group.teachers.add(teacher);
    }

    public void removeTeacherFromGroup(Teacher teacher, TeachersGroup group) {
        group.teachers.remove(teacher);
    }

    public void vievTeachers(TeachersGroup group) {
        System.out.println('\n');
        System.out.println(group);
    }

    public Teacher newTeacher(StudentGroup group) {
        return new Teacher(group);
    }

    public void redactTeacherName(Teacher teacher) {
        Scanner console = new Scanner(System.in);
        teacher.name = console.nextLine();
    }


    public void redactTeacherSurname(Teacher teacher) {
        Scanner console = new Scanner(System.in);
        teacher.surname = console.nextLine();
    }

    public void redactTeacherPatronymic(Teacher teacher) {
        Scanner console = new Scanner(System.in);
        teacher.patronymic = console.nextLine();
    }

    public void changeGroupTeacher(Teacher teacher, StudentGroup newGroup) {
        teacher.studyGroup = newGroup.nameGroup;
    }

    public String setNameTeacher() {
        String name = null;
        while (name == null) {
            Scanner console = new Scanner(System.in);
            System.out.println("Input name of teacher: ");
            name = console.nextLine();
//            if (name.equals("q"))
//                return "q";
            if (name.isEmpty()) {
                System.out.println("The name must not contain null. Try again or q to exit: ");
                return setNameTeacher();
            }
            for (int i = 0; i < name.length(); i++) {
                if (Character.isDigit(name.charAt(i))) {
                    System.out.println("The name must not contain numbers. Try again or q to exit: ");
                    return setNameTeacher();
                }
            }

        }
        return name;
    }

    public String setSurnameTeacher() {
        String surname = null;
        while (surname == null) {
            Scanner console = new Scanner(System.in);
            System.out.println("Input surname or q to exit: ");
            surname = console.nextLine();
            if (surname.equals("q"))
                return "q";
            if (surname.isEmpty()) {
                System.out.println("The surname must not contain null. Try again or q to exit: ");
                return setNameTeacher();
            }
            for (int i = 0; i < surname.length(); i++) {
                if (Character.isDigit(surname.charAt(i))) {
                    System.out.println("The surname must not contain numbers. Try again or q to exit: ");
                    return setSurnameTeacher();
                }
            }

        }
        return surname;
    }

    public String setPatronymicTeacher() {
        String patronymic = null;
        while (patronymic == null) {
            Scanner console = new Scanner(System.in);
            System.out.println("Input patronymic or q to exit: ");
            patronymic = console.nextLine();
            if (patronymic.equals("q"))
                return "q";
            if (patronymic.isEmpty()) {
                System.out.println("The patronymic must not contain null. Try again or q to exit: ");
                return setNameTeacher();
            }
            for (int i = 0; i < patronymic.length(); i++) {
                if (Character.isDigit(patronymic.charAt(i))) {
                    System.out.println("The patronymic must not contain numbers. Try again or q to exit: ");
                    return setPatronymicTeacher();
                }
            }

        }
        return patronymic;
    }
}

