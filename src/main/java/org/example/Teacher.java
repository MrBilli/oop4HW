package org.example;

//-- Создать класс Учитель

import java.util.ArrayList;
import java.util.List;

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
        return  "name '" + name + '\'' + '\n' +
                "surname '" + surname + '\'' + '\n' +
                "patronymic '" + patronymic + '\'' + '\n' +
                "studyGroup " + studyGroup + '\n';
    }

    public Teacher(String name, String surname, String patronymic, StudentGroup group) {
        super(name, surname, patronymic);
        this.studyGroup = group.nameGroup;
        group.teacher = this;
    }
}
   class TeachersGroup<T extends User>{

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

   class TeacherViev{
       public TeacherViev() {
       }

       public void vievTeachersGroup(TeachersGroup group){
        for (int i = 0; i < group.teachers.size(); i++) {
            System.out.println(group.teachers.get(i));
        }
    }
    }

   class TeacherController{
       public TeacherController() {
       }

       public void addTeacherToGroup(Teacher teacher, TeachersGroup group){
        group.teachers.add(teacher);
    }

       public void removeTeacherToGroup(Teacher teacher, TeachersGroup group){
           group.teachers.remove(teacher);
    }
}

