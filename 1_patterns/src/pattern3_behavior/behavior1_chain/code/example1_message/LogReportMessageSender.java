package pattern3_behavior.behavior1_chain.code.example1_message;

/**
 * Обработчик для записи уведомления в лог файл
 */
public class LogReportMessageSender extends MessageSender {

    public LogReportMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    public void write(String message) {
        System.out.println("Message sender using simple log report: " + message);
    }
}
