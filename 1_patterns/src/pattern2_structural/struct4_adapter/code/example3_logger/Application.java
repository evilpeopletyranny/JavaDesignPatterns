package pattern2_structural.struct4_adapter.code.example3_logger;

public class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void doWork() {
        logger.logInfo("Application is starting.");
        try {
            // Симуляция работы
            System.out.println("Application is working...");
            throw new RuntimeException("Something went wrong!");
        } catch (Exception e) {
            logger.logError(e.getMessage());
        } finally {
            logger.logInfo("Application is shutting down.");
        }
    }

    public static void main(String[] args) {
        // Подключение новой системы логирования через адаптер
        NewLogger newLogger = new NewLogger();
        Logger loggerAdapter = new LoggerAdapter(newLogger);

        Application app = new Application(loggerAdapter);
        app.doWork();
    }
}
