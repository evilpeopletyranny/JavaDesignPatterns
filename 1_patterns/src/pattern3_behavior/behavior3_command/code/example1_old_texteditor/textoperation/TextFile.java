package pattern3_behavior.behavior3_command.code.example1_old_texteditor.textoperation;

/**
 * Класс приемни команд.
 * Класс, на который направлены команды.
 */
public class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}
