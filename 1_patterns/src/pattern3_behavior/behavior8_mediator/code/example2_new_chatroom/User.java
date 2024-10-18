package pattern3_behavior.behavior8_mediator.code.example2_new_chatroom;

public class User {
    private String name;
    private Mediator mediator;

    public User(String name){
        this.name = name;
    }

    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }

    public String getName(){
        return name;
    }

    public void send(String message){
        System.out.println(this.name + " отправил сообщение: " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message){
        System.out.println(this.name + " получил сообщение: " + message);
    }
}
