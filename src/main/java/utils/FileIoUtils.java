package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIoUtils {
    public static boolean isExistFile(String filePath) throws URISyntaxException {
        try {
            return Files.exists(Paths.get(FileIoUtils.class.getClassLoader().getResource(filePath).toURI()));
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static byte[] loadFileFromClasspath(String filePath) throws IOException, URISyntaxException {
        Path path = Paths.get(FileIoUtils.class.getClassLoader().getResource(filePath).toURI());
        return Files.readAllBytes(path);
    }
}
