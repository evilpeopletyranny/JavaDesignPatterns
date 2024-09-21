package pattern3_behavior.command.code.textoperation;

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
