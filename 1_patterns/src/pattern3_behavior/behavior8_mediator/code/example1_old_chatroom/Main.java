package pattern3_behavior.behavior8_mediator.code.example1_old_chatroom;

/**
 * Реализация посредника на примере чат комнаты.
 * Пользователи не имеют явных ссылок друг на друга, всё взаимодействие
 * происходит через посредника.
 */
public class Main
{
    public static void main(String[] args)
    {
        IChatRoom chatroom = new ChatRoom();

        User user1 = new ChatUser(chatroom,"1", "Alex");
        User user2 = new ChatUser(chatroom,"2", "Brian");
        User user3 = new ChatUser(chatroom,"3", "Charles");
        User user4 = new ChatUser(chatroom,"4", "David");

        chatroom.addUser(user1);
        chatroom.addUser(user2);
        chatroom.addUser(user3);
        chatroom.addUser(user4);

        user1.send("Hello brian", "2");
        System.out.println();
        user2.send("Hey buddy", "1");
    }
}
