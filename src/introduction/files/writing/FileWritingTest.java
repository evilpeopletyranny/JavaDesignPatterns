package introduction.files.writing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class FileWritingTest {
    /**
     * Вариант ввода без использования механизма try-catch с ресурсами.
     * Вообще так уже не делают, просто показываю вам.
     * @param path путь к файлу
     * @param text коллекция строк для записи
     */
    public static void bufferedWriting(String path, Collection<String> text) {
        BufferedWriter writer = null;   //буфферезированный вывод

        //попытка открытия потока ввода и сам ввод должны проверяться
        try {
            writer = Files.newBufferedWriter(Paths.get(path));
            for (var line: Objects.requireNonNull(text)) writer.write(line);    //тут же проверка на null
        } catch (IOException e) {
            e.printStackTrace();
        }
        //затем поток ввода должен закрываться, ради освобождение и устранения учечки памяти
        //но попытка закрытия тоже должна проверяться и обрабатываться
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Пример записи.
     *
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

        bufferedWriting("src/introduction/files/TestIO", text);
    }
}
