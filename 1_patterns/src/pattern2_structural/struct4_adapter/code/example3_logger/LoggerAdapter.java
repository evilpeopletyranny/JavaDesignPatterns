package pattern2_structural.struct4_adapter.code.example3_logger;

public class LoggerAdapter implements Logger {
    private NewLogger newLogger;

    public LoggerAdapter(NewLogger newLogger) {
        this.newLogger = newLogger;
    }

    @Override
    public void logInfo(String message) {
        newLogger.log("INFO", message);
    }

    @Override
    public void logError(String message) {
        newLogger.log("ERROR", message);
    }
}
