package pattern3_behavior.behavior1_chain.code.example2_web;

import java.util.Objects;

public class AuthorizationHandler extends AbstarctHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("authorize")) {
            System.out.println("AuthorizationHandler: Authorized the request.");
            if (Objects.nonNull(nextHandler)) nextHandler.handleRequest("log");
        } else {
            System.out.println("AuthorizationHandler: Cannot handle the request. Passing to next handler.");
            if (Objects.nonNull(nextHandler)) nextHandler.handleRequest(request);
        }
    }
}
