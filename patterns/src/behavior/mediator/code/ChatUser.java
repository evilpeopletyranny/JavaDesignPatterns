package behavior.mediator.code;

/**
 * Конкретная реализация пользователя посредника
 */
public class ChatUser extends User {

    public ChatUser(IChatRoom room, String id, String name) {
        super(room, id, name);
    }

    /**
     * Отправка сообщения через посредника
     * @param msg сообщение
     * @param userId ид пользователя
     */
    @Override
    public void send(String msg, String userId) {
        System.out.println(this.getName() + " :: Sending Message : " + msg);
        getMediator().sendMessage(msg, userId);     //отправка собщения в посредника
    }

    /**
     * Получение сообщения
     * @param msg
     */
    @Override
    public void receive(String msg) {
        System.out.println(this.getName() + " :: Received Message : " + msg);
    }
}
