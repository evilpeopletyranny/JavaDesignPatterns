package patterns.behavior.chain.code;

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
