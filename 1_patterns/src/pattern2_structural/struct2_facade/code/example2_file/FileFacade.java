package pattern2_structural.struct2_facade.code.example2_file;

import java.io.IOException;

public interface FileFacade {
    void createFile(String path) throws IOException;

    void deleteFile(String path) throws IOException;

    void writeFile(String path, String content) throws IOException;

    String readFile(String path) throws IOException;
}
