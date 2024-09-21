package pattern3_behavior.state.code;

/**
 * Посылка доставлена.
 * Конкретное состояние.
 */
public class DeliveredState implements PackageState {

    /**
     * Следующее состояние - вручена.
     *
     * @param pkg посылка, которая будет переведа в следующее состояние.
     */
    @Override
    public void next(Package pkg) {
        pkg.setState(new ReceivedState());
    }

    /**
     * Предедущее состояние - заказано.
     *
     * @param pkg посылка, которая будет переведа в предыдущее состояние.
     */
    @Override
    public void prev(Package pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package delivered to post office, not received yet.");
    }
}
