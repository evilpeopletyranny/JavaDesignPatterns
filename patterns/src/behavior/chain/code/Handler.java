package behavior.chain.code;

/**
 * Интерфейс обрабочка.
 * Данный интерфейс должы реализовывать обработчики в цепочке.
 */
public interface Handler {
    /**
     * Добавление следующего обработчика
     *
     * @param handler обработчик
     */
    void setNext(Handler handler);

    /**
     * Обработка запроса
     */
    void handle(String message, PriorityLevel level);

}
