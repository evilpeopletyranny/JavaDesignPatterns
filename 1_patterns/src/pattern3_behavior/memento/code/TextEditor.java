package pattern3_behavior.memento.code;

import java.util.Stack;

/**
 * Текстовый редактор.
 * Содержит текстовое окно.
 * "Класс-создатель" (Швец)
 */
public class TextEditor {
    //Текстовое окно
    private TextWindow textWindow;

    //История состояний окна через стэк
    private Stack<TextWindowState> savedTextWindow = new Stack<>();

    public TextEditor(TextWindow textWindow) {
        this.textWindow = textWindow;
    }

    /**
     * Запись текста
     * @param text для записи
     */
    public void write(String text) {
        textWindow.addText(text);
    }

    /**
     * Получение (вывод) текста
     * @return текст из текстового окна
     */
    public String print() {
        return textWindow.getCurrentText().toString();
    }

    /**
     * Сохранение состояния.
     * Помещаем состояние в верхушку стека
     */
    public void hitSave() {
        savedTextWindow.push(textWindow.save());
    }

    /**
     * Отмена действия.
     * Переходим в состояние изщ верхушки стека.
     */
    public void hitUndo() {
        textWindow.restore(savedTextWindow.pop());
    }
}
