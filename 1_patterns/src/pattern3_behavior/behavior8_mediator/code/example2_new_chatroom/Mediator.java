package pattern3_behavior.behavior8_mediator.code.example2_new_chatroom;

public interface Mediator {
    void register(User user);
    void sendMessage(String message, User user);
}
