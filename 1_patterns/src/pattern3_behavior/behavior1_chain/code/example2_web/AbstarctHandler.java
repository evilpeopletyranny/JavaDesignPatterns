package pattern3_behavior.behavior1_chain.code.example2_web;

public abstract class AbstarctHandler implements Handler{
    protected Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }
}
