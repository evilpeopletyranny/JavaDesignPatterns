package patterns.behavior.command.code;

/**
 * Интерфейс команды, содержащий лишь один метод выполнения команды
 */
public interface TextFileOperation {
    /**
     * Метод выполнения команды
     */
    String execute();
}