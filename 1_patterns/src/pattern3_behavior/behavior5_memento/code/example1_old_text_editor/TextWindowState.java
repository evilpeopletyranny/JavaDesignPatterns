package pattern3_behavior.behavior5_memento.code.example1_old_text_editor;

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
