package pattern3_behavior.behavior3_command.code.example2_new_texteditor;

import java.util.ArrayDeque;
import java.util.Deque;

// История изменений
// Паттерн снимок через Стек
public class History {
    private Deque<Command> commandHistory = new ArrayDeque<>();

    public void push(Command cmd) {
        commandHistory.push(cmd);
    }

    public Command pop() {
        if (!commandHistory.isEmpty()) return commandHistory.pop();
        return null;
    }

    public boolean isEmpty() {
        return commandHistory.isEmpty();
    }
}
