package pattern2_structural.struct2_facade.code.example2_file;

import java.io.IOException;

public class FileMain {
    public static void main(String[] args) {
        FileFacade fileFacade = new FileFacadeImpl();
        String filePath = "example.txt";

        try {
            // Создание файла
            fileFacade.createFile(filePath);

            // Запись в файл
            fileFacade.writeFile(filePath, "Hello, Facade Pattern!");

            // Чтение из файла
            String content = fileFacade.readFile(filePath);
            System.out.println("File Content: " + content);

            // Удаление файла
            fileFacade.deleteFile(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}