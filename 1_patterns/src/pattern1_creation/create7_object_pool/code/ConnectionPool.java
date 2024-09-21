package pattern1_creation.create7_object_pool.code;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<DatabaseConnection> pool;
    private int maxSize;

    // Приватный конструктор для реализации паттерна Singleton (опционально)
    private ConnectionPool(int initialSize, int maxSize) {
        this.pool = new ArrayList<>();
        this.maxSize = maxSize;
        for (int i = 1; i <= initialSize; i++) {
            pool.add(new DatabaseConnection("Conn-" + i));
        }
    }

    // Статическая переменная для хранения единственного экземпляра пула (опционально)
    private static ConnectionPool instance;

    // Статический метод для получения экземпляра пула (опционально)
    public static synchronized ConnectionPool getInstance(int initialSize, int maxSize) {
        if (instance == null) {
            instance = new ConnectionPool(initialSize, maxSize);
        }
        return instance;
    }

    // Метод для выдачи соединения из пула
    public synchronized DatabaseConnection borrowConnection() {
        for (DatabaseConnection conn : pool) {
            if (!conn.isInUse()) {
                conn.connect();
                return conn;
            }
        }
        if (pool.size() < maxSize) {
            DatabaseConnection newConn = new DatabaseConnection("Conn-" + (pool.size() + 1));
            newConn.connect();
            pool.add(newConn);
            return newConn;
        }
        // Если пул исчерпан, можно выбросить исключение или ожидать освобождения соединения
        throw new RuntimeException("Все соединения в пуле заняты.");
    }

    // Метод для возврата соединения обратно в пул
    public synchronized void returnConnection(DatabaseConnection conn) {
        if (pool.contains(conn)) {
            conn.reset();
        } else {
            throw new IllegalArgumentException("Соединение не принадлежит пулу.");
        }
    }

    // Метод для вывода текущего состояния пула
    public synchronized void printStatus() {
        System.out.println("Текущее состояние пула соединений:");
        for (DatabaseConnection conn : pool) {
            System.out.println(conn.getConnectionId() + " - " + (conn.isInUse() ? "Используется" : "Свободно"));
        }
    }
}
