package pattern1_creation.create5_singleton.code.example5_bill_pugh;

public class BillPughSingleton {
    private BillPughSingleton() {}

    // Внутренний статический класс
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

