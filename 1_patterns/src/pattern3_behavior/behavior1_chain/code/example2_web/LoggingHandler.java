package pattern3_behavior.behavior1_chain.code.example2_web;

public class LoggingHandler extends AbstarctHandler {
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("log")) System.out.println("LoggingHandler: Logged the request.");
        else System.out.println("LoggingHandler: Cannot handle the request.");
    }
}
