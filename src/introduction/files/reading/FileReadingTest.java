package introduction.files.reading;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadingTest {
    /**
     * Пример буфференезированного чтения, с использованием механизма
     * try with resources.
     *
     * @param path путь к файлу для чтения
     * @return коллекция строк
     */
    public static List<String> bufferedReading(String path) {
        List<String> strList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            //lines() позволяет получить стрим строк - Stream<String>
            //Но поскольку механизм стримов сложен и не относиться к нашему курсу
            //то предлагается просто всё собрать в Список конструкцией .collect(Collectors.toList())
            strList = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strList;
    }

    public static void main(String[] args) {
        List<String> list = bufferedReading("src/introduction/files/TestIO");
        for (var line : list) System.out.println(line);
    }
}
