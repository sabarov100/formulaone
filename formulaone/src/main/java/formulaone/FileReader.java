package formulaone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private static final String SPACE = " ";
    private static final String UNDERLINE = "_";
    private static final String VERTICAL_LINE = "|";
    
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
    
    public Map<String, String> getDataRacers(String fileName) {
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get(fileName));
            return streamFromFiles
                    .collect(Collectors.toMap(s -> s.substring(0, 3), s ->  s.substring(4, s.length()).split(UNDERLINE)[0]
                            + spaces(17 - s.substring(4, s.length()).split(UNDERLINE)[0].length()) + SPACE + VERTICAL_LINE 
                            + SPACE + s.substring(4, s.length()).split(UNDERLINE)[1]
                            + spaces(26 - s.substring(4, s.length()).split(UNDERLINE)[1].length()) + VERTICAL_LINE + SPACE));
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

}
