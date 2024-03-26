package patterns.behavior.mediator.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализация посредника.
 * "Пересылает сообщение нужному пользователю"
 */
public class ChatRoom implements IChatRoom {
    //таблица пользователей
    private final Map<String, User> usersMap = new HashMap<>();

    /**
     * Отправка сообщения пользотваелю.
     * @param msg текст сообщения
     * @param userId id пользователя, которому будет отправлено сообщение.
     */
    @Override
    public void sendMessage(String msg, String userId)
    {
        User u = usersMap.get(userId);  //передача сообщения конкретному пользователю
        u.receive(msg);
    }

    /**
     * Добавление пользователя.
     * @param user пользователь
     */
    @Override
    public void addUser(User user) {
        this.usersMap.put(user.getId(), user);
    }
}
