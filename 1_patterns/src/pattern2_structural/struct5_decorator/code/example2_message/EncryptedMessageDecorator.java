package pattern2_structural.struct5_decorator.code.example2_message;

public class EncryptedMessageDecorator extends MessageDecorator {

    public EncryptedMessageDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return encrypt(message.getContent());
    }

    private String encrypt(String content) {
        // Простая симуляция шифрования: разворот строки
        return new StringBuilder(content).reverse().toString();
    }
}
