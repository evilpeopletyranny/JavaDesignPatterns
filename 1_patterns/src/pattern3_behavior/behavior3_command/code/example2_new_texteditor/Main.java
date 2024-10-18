package pattern3_behavior.behavior3_command.code.example2_new_texteditor;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();

        // Вставка текста
        Command insertHello = new InsertCommand(editor.textEditor, 0, "Hello ");
        editor.executeCommand(insertHello);
        editor.printText(); // Output: "Hello "

        Command insertWorld = new InsertCommand(editor.textEditor, editor.textEditor.getText().length(), "World!");
        editor.executeCommand(insertWorld);
        editor.printText(); // Output: "Hello World!"

        // Удаление текста
        Command deleteWorld = new DeleteCommand(editor.textEditor, 6, 6);
        editor.executeCommand(deleteWorld);
        editor.printText(); // Output: "Hello "

        // Отмена последних операций
        editor.undo(); // Отмена удаления "World!"
        editor.printText(); // Output: "Hello World!"

        editor.undo(); // Отмена вставки "World!"
        editor.printText(); // Output: "Hello "

        editor.undo(); // Отмена вставки "Hello "
        editor.printText(); // Output: ""

        editor.undo(); // Нет команд для отмены
    }
}
