package pattern3_behavior.behavior8_mediator.code.example2_new_chatroom;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements Mediator {
    private List<User> users;

    public ChatRoom() {
        users = new ArrayList<>();
    }

    @Override
    public void register(User user) {
        if(!users.contains(user)){
            users.add(user);
            user.setMediator(this);
            System.out.println(user.getName() + " присоединился к чат-комнате.");
        }
    }

    @Override
    public void sendMessage(String message, User sender) {
        for(User user : users){
            // Не отправлять сообщение отправителю
            if(user != sender){
                user.receive(message);
            }
        }
    }
}
