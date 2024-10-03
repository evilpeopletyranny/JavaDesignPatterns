package pattern2_structural.struct5_decorator.code.example2_message;

public class MessageMain {
    public static void main(String[] args) {
        // Создание простого сообщения
        Message simpleMessage = new SimpleMessage("Hello, World!");
        System.out.println("Simple Message: " + simpleMessage.getContent());

        // Добавление шифрования
        Message encryptedMessage = new EncryptedMessageDecorator(simpleMessage);
        System.out.println("Encrypted Message: " + encryptedMessage.getContent());

        // Добавление временной метки
        Message timestampedMessage = new TimestampedMessageDecorator(simpleMessage);
        System.out.println("Timestamped Message: " + timestampedMessage.getContent());

        // Комбинирование декораторов: сначала шифрование, затем добавление метки
        Message encryptedTimestampedMessage = new TimestampedMessageDecorator(encryptedMessage);
        System.out.println("Encrypted & Timestamped Message: " + encryptedTimestampedMessage.getContent());
    }
}
