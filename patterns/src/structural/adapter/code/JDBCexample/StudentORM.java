package structural.adapter.code.JDBCexample;

import java.util.List;

/**
 * Интерфейс, к которому мы должны адаптировать ResultSet, получаемый от JDBC
 */
public interface StudentORM {
    Student select(String query);

    List<Student> selectAll(String query);
}
