package formulaone;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Formatter {
    
    private static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("mm:ss.SSS");
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String POINT = ".";
    private static final String NEW_LINE = "\n";
    private static final String EQUAL = "=";
    private static final String VERTICAL_LINE = "|";
    
    public String formatRacersResult(Map<String, Racer> listRacers) {
        Stream<String> streamFromCollection = listRacers.keySet().stream();
        Map<String, Long> resultRacers = streamFromCollection.collect
                (Collectors.toMap(s -> s, s -> listRacers.get(s).getResultTime()));
        List<String[]> list = new ArrayList();
        resultRacers.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .forEach(s -> list.add(0, s.toString().split(EQUAL))); 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(i + 1).append(POINT).append((i > 8 ? spaces(1) : spaces(2)))
                    .append(listRacers.get(list.get(i)[0]).getFullName())
                    .append(spaces(17 - listRacers.get(list.get(i)[0]).getFullName().length()))
                    .append(SPACE).append(VERTICAL_LINE).append(SPACE)
                    .append(listRacers.get(list.get(i)[0]).getTeam())
                    .append(spaces(26 - listRacers.get(list.get(i)[0]).getTeam().length()))
                    .append(VERTICAL_LINE).append(SPACE)
                    .append(LocalTime.ofNanoOfDay(resultRacers.get(list.get(i)[0]))
                    .format(FORMATTER_TIME)).append(NEW_LINE);
            if(i == 14) {
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
