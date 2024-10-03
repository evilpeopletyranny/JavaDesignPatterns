package pattern2_structural.struct5_decorator.code.example2_message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedMessageDecorator extends MessageDecorator {

    public TimestampedMessageDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return addTimestamp(message.getContent());
    }

    private String addTimestamp(String content) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        return "[" + timestamp + "] " + content;
    }
}
