package patterns.behavior.command.code.textoperation;

import java.util.List;
import java.util.ArrayList;

/**
 * Класс исполнитель команд.
 * Не обязателен в паттерне.
 * Хранит список команд, в дальнейшем может служить для работы с очередью/историей команд.
 */
public class TextFileOperationExecutor {
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    /**
     * Выполнить команду и занести её в историю
     */
    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
