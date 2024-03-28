package patterns.behavior.state.code;

/**
 * Посылка заказана.
 * Конкретное состояние.
 */
public class OrderedState implements PackageState {

    /**
     * Следующее состояние - доставляется.
     *
     * @param pkg посылка, которая будет переведа в следующее состояние.
     */
    @Override
    public void next(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    /**
     * У данного состояния нет предудыщего, так как оно является начальным.
     *
     * @param pkg посылка, которая будет переведа в предыдущее состояние.
     */
    @Override
    public void prev(Package pkg) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Package ordered, not delivered to the office yet.");
    }
}
