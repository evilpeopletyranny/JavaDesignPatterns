package patterns.behavior.chain.code;

import java.util.Objects;

/**
 * Базовый абстрактный обработчик, который пересылает уведомления
 */
public abstract class MessageSender implements Handler {
    private final PriorityLevel priorityLevel;      //уровень
    private Handler nextMessageHandler;             //следующий обработчик

    public MessageSender(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * @param handler следующий обработчик обработчик
     */
    @Override
    public void setNext(Handler handler) {
        this.nextMessageHandler = handler;
    }

    /**
     * Обработка запроса
     *
     * @param message сообщение для отправки
     */
    @Override
    public void handle(String message, PriorityLevel level) {
        //Если уровень этого обротчика ниже или равень уровню сообщения, то обрабатываем
        if (priorityLevel.ordinal() <= level.ordinal()) write(message);

        //В противном случае, если есть следующий обработчик, то передаем ему.
        if (Objects.nonNull(nextMessageHandler)) nextMessageHandler.handle(message, level);
    }

    protected abstract void write(String message);
}
