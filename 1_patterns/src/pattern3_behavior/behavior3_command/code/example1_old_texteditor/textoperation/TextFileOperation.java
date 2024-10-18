package pattern3_behavior.behavior3_command.code.example1_old_texteditor.textoperation;

/**
 * Интерфейс команды, содержащий лишь один метод выполнения команды
 */
public interface TextFileOperation {
    /**
     * Метод выполнения команды
     */
    String execute();
}