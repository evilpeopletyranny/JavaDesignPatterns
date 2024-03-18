package patterns.behavior.command.code;

/**
 * Клиентский код, работающий с историей/очередью команд на текстовым файлом.
 */
public class Main {
    public static void main(String[] args) {
        //Очередь операций
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

        //Операция открытия над text1.txt
        System.out.println(textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt"))));

        //Операция сохранения над text2.txt
        System.out.println(textFileOperationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt"))));
    }
}
