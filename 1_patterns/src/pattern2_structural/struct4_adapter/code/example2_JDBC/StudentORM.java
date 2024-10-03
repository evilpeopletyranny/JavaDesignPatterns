package pattern2_structural.struct4_adapter.code.example2_JDBC;

import java.util.List;

/**
 * Интерфейс, к которому мы должны адаптировать ResultSet, получаемый от JDBC
 */
public interface StudentORM {
    Student select(String query);

    List<Student> selectAll(String query);
}
