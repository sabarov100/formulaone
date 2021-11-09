package formulaone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private static final String EXCEPTION_MESSAGE = "File name cannot be NULL";
    
    public List<String> getListData(String fileName) {
        if (fileName == null) { 
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        Path path = Path.of(fileName);
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
