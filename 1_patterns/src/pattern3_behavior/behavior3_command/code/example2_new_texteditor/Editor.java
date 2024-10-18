package pattern3_behavior.behavior3_command.code.example2_new_texteditor;

// Инициатор
// Класс из которого подаются команды и в котором хранится их история
public class Editor {
    protected TextEditor textEditor = new TextEditor();
    private History history = new History();

    public void executeCommand(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
        } else {
            System.out.println("No commands to undo.");
        }
    }

    public void printText() {
        System.out.println("Current Text: \"" + textEditor.getText() + "\"");
    }
}
