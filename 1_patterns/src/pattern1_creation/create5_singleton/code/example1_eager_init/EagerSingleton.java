package pattern1_creation.create5_singleton.code.example1_eager_init;

public class EagerSingleton {
    // Создание экземпляра при загрузке класса
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // Приватный конструктор
    private EagerSingleton() {}

    // Публичный метод доступа
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
