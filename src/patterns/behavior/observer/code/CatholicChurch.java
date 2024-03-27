package patterns.behavior.observer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Католическая церковь
 */
public class CatholicChurch implements Observable {
    private List<Observer> parishioners;    //список прихожан
    private String newsChurch;              //новость

    public CatholicChurch() {
        parishioners = new ArrayList<>();
    }

    /**
     * Метод изменения новости.
     *
     * @param news новая новость
     */
    public void setNewsChurch(String news) {
        this.newsChurch = news;
        notifyObservers();
    }

    /**
     * Регистрация нового прихожанина
     *
     * @param observer подписчик, который будет зарегистрирован на получение овоещениц.
     */
    @Override
    public void registerObserver(Observer observer) {
        parishioners.add(observer);
    }

    /**
     * Удаление прихожанина
     *
     * @param observer подписчик, который будет больше не будет получать оповещения.
     */
    @Override
    public void removeObserver(Observer observer) {
        parishioners.remove(observer);
    }

    /**
     * Оповещение всех прихожан.
     */
    @Override
    public void notifyObservers() {
        for (Observer o : parishioners) o.update(newsChurch);
    }
}
