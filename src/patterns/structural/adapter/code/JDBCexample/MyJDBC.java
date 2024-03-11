package patterns.structural.adapter.code.JDBCexample;

import java.sql.ResultSet;
import java.util.List;

/**
 * Имитация голово JDBC
 */
public class MyJDBC {
    public ResultSet select() {
        return null;
    }

    public List<ResultSet> selectAll() {
        return null;
    }
}
