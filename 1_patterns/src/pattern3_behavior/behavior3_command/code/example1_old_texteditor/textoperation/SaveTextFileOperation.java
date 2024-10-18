package pattern3_behavior.behavior3_command.code.example1_old_texteditor.textoperation;

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
