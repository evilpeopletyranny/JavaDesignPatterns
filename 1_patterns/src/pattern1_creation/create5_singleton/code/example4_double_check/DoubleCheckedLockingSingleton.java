package pattern1_creation.create5_singleton.code.example4_double_check;

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // Первая проверка (без синхронизации)
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // Вторая проверка (с синхронизацией)
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
