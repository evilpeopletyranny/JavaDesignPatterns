package patterns.behavior.mediator.code;

/**
 * Пример с чатом.
 * Интерфейс посредника.
 */
public interface IChatRoom
{
    /**
     * Отправка сообщения пользователю
     * @param msg текст сообщения
     * @param userId id пользователя, которому будет отправлено сообщение.
     */
    void sendMessage(String msg, String userId);

    /**
     * "Добавление пользователя в чат"
     * @param user пользователь
     */
    void addUser(User user);
}
