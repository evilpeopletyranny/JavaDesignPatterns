package pattern3_behavior.behavior8_mediator.code.example2_new_chatroom;

public class Main {
    public static void main(String[] args) {
        Mediator chatRoom = new ChatRoom();

        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        chatRoom.register(alice);
        chatRoom.register(bob);
        chatRoom.register(charlie);

        alice.send("Привет всем!");
        bob.send("Привет, Alice!");
        charlie.send("Здравствуйте!");
    }
}
