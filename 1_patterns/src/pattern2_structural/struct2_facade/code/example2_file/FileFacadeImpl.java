package pattern2_structural.struct2_facade.code.example2_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileFacadeImpl implements FileFacade {

    @Override
    public void createFile(String path) throws IOException {
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println("File created: " + path);
        } else {
            System.out.println("File already exists: " + path);
        }
    }

    @Override
    public void deleteFile(String path) throws IOException {
        Files.deleteIfExists(Paths.get(path));
        System.out.println("File deleted: " + path);
    }

    @Override
    public void writeFile(String path, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(content);
        writer.close();
        System.out.println("Written to file: " + path);
    }

    @Override
    public String readFile(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println("Read from file: " + path);
        return content;
    }
}
