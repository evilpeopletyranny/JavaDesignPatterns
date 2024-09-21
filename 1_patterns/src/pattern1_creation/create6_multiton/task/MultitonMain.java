package pattern1_creation.create6_multiton.task;

public class MultitonMain {
    public static void main(String[] args) {
//        // Получение фабрик для разных типов логгеров
//        LoggerFactory authFactory1 = LoggerFactoryMultiton.getFactory(LoggerType.AUTHENTICATION);
//        LoggerFactory authFactory2 = LoggerFactoryMultiton.getFactory(LoggerType.AUTHENTICATION);
//
//        LoggerFactory paymentFactory1 = LoggerFactoryMultiton.getFactory(LoggerType.PAYMENT);
//        LoggerFactory paymentFactory2 = LoggerFactoryMultiton.getFactory(LoggerType.PAYMENT);
//
//        LoggerFactory notificationFactory1 = LoggerFactoryMultiton.getFactory(LoggerType.NOTIFICATION);
//        LoggerFactory notificationFactory2 = LoggerFactoryMultiton.getFactory(LoggerType.NOTIFICATION);
//
//        // Проверка, что для каждого типа логгера создаётся только одна фабрика
//        System.out.println("Проверка экземпляров фабрик:");
//        System.out.println("authFactory1 == authFactory2: " + (authFactory1 == authFactory2));
//        System.out.println("paymentFactory1 == paymentFactory2: " + (paymentFactory1 == paymentFactory2));
//        System.out.println("notificationFactory1 == notificationFactory2: " + (notificationFactory1 == notificationFactory2));
//
//        System.out.println("\nСоздание логгеров через фабрики:");
//
//        // Создание логгеров через фабрики
//        Logger authLogger = authFactory1.createLogger();
//        Logger paymentLogger = paymentFactory1.createLogger();
//        Logger notificationLogger = notificationFactory1.createLogger();
//
//        // Запись логов
//        authLogger.log("Пользователь успешно аутентифицирован.");
//        paymentLogger.log("Платёж обработан успешно.");
//        notificationLogger.log("Уведомление отправлено пользователю.");
    }
}
