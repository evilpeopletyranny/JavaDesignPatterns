package patterns.behavior.command.code;

/**
 * Реализация конкретной команды - открытие текстового файла.
 */
public class OpenTextFileOperation implements TextFileOperation {
    //команда содержит внутри ссылку на приемника команды
    private TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    /**
     * Выполнение операции открытия
     */
    @Override
    public String execute() {
        return textFile.open();
    }
}
