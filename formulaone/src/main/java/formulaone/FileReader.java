package formulaone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private static final String UNDERLINE = "_";
    private static final String EXCEPTION_MESSAGE = "File name cannot be NULL";
    
    public Map<String, LocalDateTime> getData(String fileName) {
        if (fileName == null) { 
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get(fileName));
            return streamFromFiles
                    .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), FORMATTER)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }
    
    public Map<String, String[]> getDataRacersAndTeams(String fileName) {
        if (fileName == null) { 
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get(fileName));
            return streamFromFiles
                    .collect(Collectors.toMap(s -> s.substring(0, 3), s ->  s.substring(4, s.length()).split(UNDERLINE)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

}
