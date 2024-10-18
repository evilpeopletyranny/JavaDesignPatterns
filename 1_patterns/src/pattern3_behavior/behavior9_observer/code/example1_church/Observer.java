package pattern3_behavior.behavior9_observer.code.example1_church;

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
