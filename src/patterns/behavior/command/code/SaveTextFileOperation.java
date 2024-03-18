package patterns.behavior.command.code;

/**
 * Реализация конкретной команды - сохранение текстового файла.
 */
public class SaveTextFileOperation implements TextFileOperation {
    //команда содержит внутри ссылку на приемника команды
    private TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    /**
     * Выполнение операции сохранения
     */
    @Override
    public String execute() {
        return textFile.save();
    }
}
