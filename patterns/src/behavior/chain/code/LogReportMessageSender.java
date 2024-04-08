package behavior.chain.code;

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
