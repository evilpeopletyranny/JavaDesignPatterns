package pattern3_behavior.behavior5_memento.code.example1_old_text_editor;

/**
 * Текстовое окно.
 * Объект, снимки которого мы хотим схронять.
 */
public class TextWindow {
    //StringBuilder - изменяемые строки
    private StringBuilder currentText;

    public TextWindow() {
        this.currentText = new StringBuilder();
    }

    public void addText(String text) {
        currentText.append(text);
    }

    public StringBuilder getCurrentText() {
        return currentText;
    }

    /**
     * Метод создания снимка.
     * @return снимок текста
     */
    public TextWindowState save() {
        return new TextWindowState(currentText.toString());
    }

    /**
     * Востановление состояния
     * @param save состояние в которое необходимо вернуться.
     */
    public void restore(TextWindowState save) {
        currentText = new StringBuilder(save.getText());
    }
}
