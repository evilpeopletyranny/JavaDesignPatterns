package pattern2_structural.adapter.code.JDBCexample;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Адаптер, который преобразует данные, получечнные от JDBC в виде ResultSet
 * к необходимому типу данных.
 * <p>
 * Наверное, примерно такие костыли и генерируются при использовании ORM.
 */
public class StudentJDBCAdapter implements StudentORM {
    private final MyJDBC jdbc;

    public StudentJDBCAdapter(MyJDBC jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Student select(String query) {
        ResultSet res = jdbc.select();
        String firstName = /* преобразование данных из ResultSet */ null;
        String secondName = /* преобразование данных из ResultSet */ null;
        Integer age = /* преобразование данных из ResultSet */ null;
        return new Student(firstName, secondName, age);
    }

    @Override
    public List<Student> selectAll(String query) {
        List<ResultSet> resList = jdbc.selectAll();
        List<Student> studentList = new LinkedList<>();

        for (var res : resList) {
            String firstName = /* преобразование данных из ResultSet */ null;
            String secondName = /* преобразование данных из ResultSet */ null;
            Integer age = /* преобразование данных из ResultSet */ null;
            studentList.add(new Student(firstName, secondName, age));
        }

        return studentList;
    }
}
