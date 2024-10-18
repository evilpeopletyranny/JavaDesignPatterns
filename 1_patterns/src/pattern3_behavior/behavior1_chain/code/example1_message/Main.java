package pattern3_behavior.behavior1_chain.code.example1_message;

/**
 * Цепочка обязаностей для распределения уровня уведомлений
 */
public class Main {
    public static void main(String[] args) {
        //Обработчик для записи в лог, минимальный приоритет
        MessageSender logMessageSender = new LogReportMessageSender(PriorityLevel.LOW);

        //Обработчик для уведомления по email, средний приоритет
        MessageSender emailMessageSender = new EmailMessageSender(PriorityLevel.MIDDLE);

        //Обработчик для уведомления по СМС, высокий приоритет
        MessageSender smsMessageSender = new SMSMessageSender(PriorityLevel.HIGH);

        //Связываем обработчики по возрастанию приоритета
        logMessageSender.setNext(emailMessageSender);
        emailMessageSender.setNext(smsMessageSender);


        //Начинаем работы цепочки с наименьшего приотета
        //сообщение с низким приоритетом
        logMessageSender.handle("Something is happening!", PriorityLevel.LOW);

        //Сообщение со средним приоритетом
        System.out.println("---------------------------------------------------------------------");
        logMessageSender.handle("Something went wrong!", PriorityLevel.MIDDLE);

        //Сообщение с высоким приоритетом
        System.out.println("---------------------------------------------------------------------");
        logMessageSender.handle("We had a problem!", PriorityLevel.HIGH);
    }
}
