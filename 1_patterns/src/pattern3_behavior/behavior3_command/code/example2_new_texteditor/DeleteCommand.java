package pattern3_behavior.behavior3_command.code.example2_new_texteditor;

public class DeleteCommand implements Command {
    private TextEditor editor;
    private int position;
    private int length;
    private String removedText;

    public DeleteCommand(TextEditor editor, int position, int length) {
        this.editor = editor;
        this.position = position;
        this.length = length;
    }

    @Override
    public void execute() {
        removedText = editor.getText().substring(position, position + length);
        editor.delete(position, length);
    }

    @Override
    public void undo() {
        editor.insert(position, removedText);
    }
}
