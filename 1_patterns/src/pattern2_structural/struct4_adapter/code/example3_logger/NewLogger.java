package pattern2_structural.struct4_adapter.code.example3_logger;

public class NewLogger {
    public void log(String severity, String message) {
        System.out.println("[" + severity + "] " + message);
    }
}
