package pattern1_creation.create5_singleton.code;

import java.util.Objects;

/**
 * Простой, не потоко-безопасный синглтон на примере
 * класса доступа к БД
 */
public class Database {
    private static Database instance = null;    //одна единнственная ссылка на класс

    private Database() {
    }

    /**
     * Получение сссылки на объект
     *
     * @return ссылку на единсвтенный экземпляр класс
     */
    public static Database getInstance() {
        if (Objects.isNull(instance)) instance = new Database();
        return instance;
    }

    public String query(String sql) {
        return sql;
    }
}
