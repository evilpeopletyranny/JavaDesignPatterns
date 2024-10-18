package pattern3_behavior.behavior1_chain.code.example2_web;

public class Main {
    public static void main(String[] args) {
        // Создание обработчиков
        Handler authHandler = new AuthenticationHandler();
        Handler authorizationHandler = new AuthorizationHandler();
        Handler loggingHandler = new LoggingHandler();

        // Настройка цепочки
        authHandler.setNextHandler(authorizationHandler);
        authorizationHandler.setNextHandler(loggingHandler);

        // Отправка запроса в цепочку
        System.out.println("Client: Sending 'authenticate' request.");
        authHandler.handleRequest("authenticate");

        System.out.println("\nClient: Sending 'unknown' request.");
        authHandler.handleRequest("unknown");
    }
}
