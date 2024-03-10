package introduction.files.writing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileWritingWithResources {
    /**
     * Вариант ввода c использованием механизма try с ресурсами.
     * Закрытие потока просиходит автоматически при выходе из блока try{} - блок final с закрытием
     * не нужен.
     * Для использование блока try с ресурсами ресур должен реализовывать интерфейс Closeable
     *
     * @param path путь к файлу
     * @param text коллекция строк для записи
     */
    public static void bufferedWritingWithResources(String path, List<String> text) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            for (var line : Objects.requireNonNull(text)) writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Пример записи.
     * <p>
     * При выполнении ЛР, если вам придеться работать с файлами - мне всё равно каким образом вы будете
     * это делать.
     * В данном случае вам просто показан пример буфферезированного вывода из Java NIO - один из наилуших вариантов.
     */
    public static void main(String[] args) {
        List<String> text = List.of("Вот дом,\n",
                "Который построил Джек.\n",
                "А это пшеница,\n",
                "Которая в тёмном чулане хранится\n",
                "В доме,\n",
                "Который построил Джек.\n");

        bufferedWritingWithResources("src/introduction/files/TestIO", text);
    }
}
