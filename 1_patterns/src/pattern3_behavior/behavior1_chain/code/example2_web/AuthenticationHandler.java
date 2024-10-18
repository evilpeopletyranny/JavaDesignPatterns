package pattern3_behavior.behavior1_chain.code.example2_web;

import java.util.Objects;

public class AuthenticationHandler extends AbstarctHandler {

    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("authenticate")) {
            System.out.println("AuthenticationHandler: Authenticated the request.");
            if (Objects.nonNull(nextHandler)) nextHandler.handleRequest("authorize");
        } else {
            System.out.println("AuthenticationHandler: Cannot handle the request. Passing to next handler.");
            if (Objects.nonNull(nextHandler)) nextHandler.handleRequest(request);
        }
    }
}
