package pattern3_behavior.behavior1_chain.code.example1_message;

/**
 * Отправка уведомления по почте
 */
public class EmailMessageSender extends MessageSender {
    public EmailMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    protected void write(String message) {
        System.out.println("Sending email: " + message);
    }
}
