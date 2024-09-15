package behavior.memento.code;

/**
 * Снимок текстового окна.
 * Хранит текст.
 */
public class TextWindowState {
    //Не изменяемая строка, т.к. снимок должен быть полностью иммутабельным
    private String text;

    public TextWindowState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
