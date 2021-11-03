package formulaone;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RasersData {
    
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    
    public Map<String, LocalDateTime> getData(String fileName) {
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get(fileName));
            return streamFromFiles
                    .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), FORMATTER)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, String> getDataRasers(String fileName) {
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get(fileName));
            return streamFromFiles
                    .collect(Collectors.toMap(s -> s.substring(0, 3), s ->  s.substring(4, s.length()).split("_")[0]
                            + spaces(17 - s.substring(4, s.length()).split("_")[0].length()) + " | " 
                            + s.substring(4, s.length()).split("_")[1]
                            + spaces(26 - s.substring(4, s.length()).split("_")[1].length()) + "| "));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String spaces(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    public static String dashs(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
