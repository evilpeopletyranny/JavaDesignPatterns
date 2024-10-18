package pattern3_behavior.behavior3_command.code.example2_new_texteditor;

// Получатель
public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void insert(int position, String content) {
        if (position < 0 || position > text.length()) throw new IllegalArgumentException("Invalid position");

        text.insert(position, content);
        System.out.println("Inserted \"" + content + "\" at position " + position);
    }

    public void delete(int position, int length) {
        if (position < 0 || position + length > text.length())
            throw new IllegalArgumentException("Invalid position or length");

        String removed = text.substring(position, position + length);
        text.delete(position, position + length);
        System.out.println("Deleted \"" + removed + "\" from position " + position);
    }

    public String getText() {
        return text.toString();
    }
}
