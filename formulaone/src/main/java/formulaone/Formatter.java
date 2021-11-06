package formulaone;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formatter {
    
    RacerParser racerParser;
    Racer racer;
    private static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("mm:ss.SSS");
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String POINT = ".";
    private static final String NEW_LINE = "\n";
    private static final String EQUAL = "=";
    private static final String VERTICAL_LINE = "|";
    
    public String formatRacersResult(String fileNameAndTeam, String fileStartTime, String fileEndTime,
            RacerParser racerParser, FileReader fileReader) {
        Map<String, Racer> listRacers = racerParser.initializationRacers(fileNameAndTeam, fileStartTime, fileEndTime, fileReader);
        Map<String, Long> resultRacers = new HashMap<>();
        for (Map.Entry<String, Racer> entry : listRacers.entrySet()) {
            String key = entry.getKey();
            Racer value = entry.getValue();
            resultRacers.put(key, value.getResultTime());
        }
        List<String[]> list = new ArrayList();
        resultRacers.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .forEach(s -> list.add(s.toString().split(EQUAL))); 
        
        StringBuilder sb = new StringBuilder();
        for(int j = list.size() - 1; j > - 1; j--) {
            sb.append(list.size() - j).append(POINT).append((j > 9 ? spaces(2) : spaces(1)))
                    .append(listRacers.get(list.get(j)[0]).getFullName())
                    .append(spaces(17 - listRacers.get(list.get(j)[0]).getFullName().length()))
                    .append(SPACE).append(VERTICAL_LINE).append(SPACE)
                    .append(listRacers.get(list.get(j)[0]).getTeam())
                    .append(spaces(26 - listRacers.get(list.get(j)[0]).getTeam().length()))
                    .append(VERTICAL_LINE).append(SPACE)
                    .append(LocalTime.ofNanoOfDay(resultRacers.get(list.get(j)[0]))
                    .format(FORMATTER_TIME)).append(NEW_LINE);
            if(j == 4) {
                sb.append(dashs(61)).append(NEW_LINE);
            }
        }
        return sb.toString();
    }
    
    private String spaces(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append(SPACE);
        }
        return sb.toString();
    }
    
    private String dashs(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
    
}
