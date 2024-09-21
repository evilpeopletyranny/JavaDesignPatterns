package pattern3_behavior.state.code;

/**
 * Незамысловатый пример с посылкой и ее состояними.
 * В данном примере кол-во состояний и их порядок опделены заранее.
 * Состояния связываются друг с другом внутри собственного класс, а не в клиентском коде.
 */
public class Main {
    public static void main(String[] args) {
        Package pkg = new Package();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();
    }
}
