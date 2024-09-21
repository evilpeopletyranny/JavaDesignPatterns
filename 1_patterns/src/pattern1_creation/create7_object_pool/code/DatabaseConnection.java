package pattern1_creation.create7_object_pool.code;

public class DatabaseConnection implements Reusable {
    private boolean inUse;
    private String connectionId;

    public DatabaseConnection(String connectionId) {
        this.connectionId = connectionId;
        this.inUse = false;
        // Симуляция установки соединения
        System.out.println("Соединение " + connectionId + " установлено.");
    }

    public boolean isInUse() {
        return inUse;
    }

    public void connect() {
        if (!inUse) {
            inUse = true;
            System.out.println("Соединение " + connectionId + " используется.");
        } else {
            System.out.println("Соединение " + connectionId + " уже используется.");
        }
    }

    public void disconnect() {
        if (inUse) {
            inUse = false;
            System.out.println("Соединение " + connectionId + " освобождено.");
        }
    }

    @Override
    public void reset() {
        disconnect();
        // Дополнительная очистка состояния соединения при необходимости
        System.out.println("Соединение " + connectionId + " сброшено.");
    }

    public String getConnectionId() {
        return connectionId;
    }
}

