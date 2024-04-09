package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("universityBean")
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudent() {
        Student st1 = new Student("Vladislav Sapozhnikov", 4, 6.3);
        Student st2 = new Student("Mikhail ivanov", 2, 9.3);
        Student st3 = new Student("Elena Sidorova", 1, 9.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Начало работы методы getStudents");
        System.out.println(students.get(3));
        //Выброс Exception

        System.out.println("Information from getStudents");
        System.out.println(students);
        return students;
    }
}
