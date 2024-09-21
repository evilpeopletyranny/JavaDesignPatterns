package pattern3_behavior.observer.code;

/**
 * "Наблюдатель" (подписчик)
 * Реагирует на изменение издателя.
 */
public interface Observer {
    /**
     * Метод реакции.
     * Реакция на новые новости.
     *
     * @param news новость
     */
    void update(String news);
}
