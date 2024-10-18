package pattern3_behavior.behavior1_chain.code.example1_message;

/**
 * Обработчик, отправляющий уведомления по СМС
 */
public class SMSMessageSender extends MessageSender {

    public SMSMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    protected void write(String message) {
        System.out.println("Sending SMS to manager: " + message);
    }
}
