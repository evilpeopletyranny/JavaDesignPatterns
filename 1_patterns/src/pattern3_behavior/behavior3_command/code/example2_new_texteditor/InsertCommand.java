package pattern3_behavior.behavior3_command.code.example2_new_texteditor;

// Конкретная команда - вставка
public class InsertCommand implements Command {
    private TextEditor editor;
    private int position;
    private String content;

    public InsertCommand(TextEditor editor, int position, String content) {
        this.editor = editor;
        this.position = position;
        this.content = content;
    }

    @Override
    public void execute() {
        editor.insert(position, content);
    }

    @Override
    public void undo() {
        editor.delete(position, content.length());
    }
}
