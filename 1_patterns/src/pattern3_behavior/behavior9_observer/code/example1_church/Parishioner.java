package pattern3_behavior.behavior9_observer.code.example1_church;

/**
 * Прихожанин церкви
 */
public class Parishioner implements Observer {
    private String name;

    public Parishioner(String name, Observable o) {
        this.name = name;
        o.registerObserver(this);
    }

    /**
     * Реакция на новость.
     *
     * @param news новость
     */
    @Override
    public void update(String news) {
        System.out.println(name + " узнал новость: " + news);
    }
}
