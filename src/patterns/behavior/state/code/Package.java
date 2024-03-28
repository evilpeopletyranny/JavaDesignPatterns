package patterns.behavior.state.code;

/**
 * Класс посылки - "контекст".
 * Класс, который меняет состояния.
 */
public class Package {
    private PackageState state = new OrderedState();    //ссылка на состояние заказа

    public PackageState getState() {
        return state;
    }

    public void setState(PackageState state) {
        this.state = state;
    }

    /**
     * Перевод посылки в прошлое состояние.
     */
    public void previousState() {
        state.prev(this);
    }

    /**
     * Перевод посылки в следующее состояние
     */
    public void nextState() {
        state.next(this);
    }

    /**
     * Получение сведение о состоянии
     */
    public void printStatus() {
        state.printStatus();
    }
}
