package pattern3_behavior.behavior1_chain.code.example2_web;

public interface Handler {
    void setNextHandler(Handler handler);
    void handleRequest(String request);
}
